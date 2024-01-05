import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CSVSerializedPersistentStorage implements Storage, Serializable {
    private Map<String, Object> storage;
    private String filePath;

    public CSVSerializedPersistentStorage(String filePath) {
        this.filePath = filePath;
        this.storage = loadFromFile();
    }
    @Override
    public void put(String key, Object value) {
        storage.put(key, value);
        saveToFile();
    }

    @Override
    public Object get(String key) {
        return storage.get(key);
    }

    @Override
    public boolean contains(String key) {
        return storage.containsKey(key);
    }

    @Override
    public boolean remove(String key) {
        boolean removed = storage.remove(key) != null; // Check if key was present before removal
        if (removed) {
            saveToFile();
        }
        return removed;
    }

    private Map<String, Object> loadFromFile() {
        Map<String, Object> loadedData = new HashMap<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            Object obj = objectInputStream.readObject();

            if (obj instanceof Map) {
                loadedData = (Map<String, Object>) obj;
            } else {
                System.err.println("Unexpected data format in the serialized file.");
            }
        } catch (FileNotFoundException e) {

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return loadedData;
    }

    private void saveToFile() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(storage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

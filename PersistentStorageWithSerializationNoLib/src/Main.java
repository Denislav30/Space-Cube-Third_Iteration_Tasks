import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Example usage of SerializedCustomMap with serialization
        SerializedCustomMap<String, String> customMap = new SerializedCustomMap<>();

        customMap.put("Gosho", "0878111111");
        customMap.put("Pesho", "0877222222");

        // Serialize the map
        serializeMap(customMap, "CustomMap.ser");

        // Deserialize the map
        SerializedCustomMap<String, String> deserializedMap = deserializeMap("CustomMap.ser");

        // Access and print values from the deserialized map
        System.out.println("Is Gosho in the map? " + deserializedMap.contains("Gosho"));
        System.out.println("What is the number of Pesho in the map? " + deserializedMap.get("Pesho"));
    }

    private static void serializeMap(CustomMap<?, ?> map, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static <K, V> SerializedCustomMap<K, V> deserializeMap(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            Object obj = objectInputStream.readObject();

            if (obj instanceof SerializedCustomMap) {
                return (SerializedCustomMap<K, V>) obj;
            } else {
                throw new IOException("Unexpected data format in the serialized file.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Storage persistentStorage = new CSVSerializedPersistentStorage("PersistentStorage.csv");

        persistentStorage.put("Test", "1111");
        persistentStorage.put("Denis", "3333");

        System.out.println("Is Test in the map? " + persistentStorage.contains("Test"));
        System.out.println("What is the number of Denis in the map? " + persistentStorage.get("Denis"));

        System.out.println("Lets remove Denis from the map!");
        persistentStorage.remove("Denis");

        System.out.println("Check if Denis is still in the map: " + persistentStorage.contains("Denis"));
    }
}
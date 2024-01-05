public interface Storage {
    /**
     * Stores a value under a given key.
     *
     * @param key   The key under which the value will be stored.
     * @param value The value to be stored.
     */
    void put(String key, Object value);

    /**
     * Retrieves the value for a given key.
     *
     * @param key The key for which to retrieve the value.
     * @return The value associated with the key, or null if the key is not found.
     */
    Object get(String key);

    /**
     * Checks if the key is already used to store a value in the persistent storage.
     *
     * @param key The key to check for existence.
     * @return True if the key is present, false otherwise.
     */
    boolean contains(String key);

    /**
     * Removes a value associated with the given key from the persistent storage.
     *
     * @param key The key for which to remove the value.
     * @return True if the removal was successful, false if the key was not present.
     */
    boolean remove(String key);
}

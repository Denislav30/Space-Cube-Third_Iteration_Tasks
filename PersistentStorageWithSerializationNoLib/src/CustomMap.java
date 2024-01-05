import java.io.Serializable;

public interface CustomMap<K, V> extends Serializable {
    void put(K key, V value);
    V get(K key);
    boolean contains(K key);
    boolean remove(K key);
}

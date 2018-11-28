public interface Map<K,V> {
    int size();
    boolean isEmpty();
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    //not sure if necessary for our implementation
//    Iterable<K> keySet();
//    Iterable<V> values();
    Iterable<MapEntry> entrySet();
}

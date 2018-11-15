/**
 * Interface instantiated by {@link PriorityQueue}, implemented by Job
 * and several other classes to help with the generic implementation
 * @param <K> Key
 * @param <V> Value
 */
public interface Entry<K, V> {
    K getKey();
    V getValue();
}

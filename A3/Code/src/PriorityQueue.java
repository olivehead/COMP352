/**
 * This interface outlines the methods to be used in the priority queue
 * @param <K> A key
 * @param <V> A value
 */
public interface PriorityQueue<K,V> {
    /**
     * This method returns the size of the PQ
     * @return the size of the PQ
     */
    int size();

    /**
     * Returns whether or not the PQ is empty
     * @return if the PQ is empty
     */
    boolean isEmpty();

    /**
     * Returns and removes the element with the smallest key in the PQ
     * @return the element with the smallest key
     */
    Entry<K,V> removeMin();

    /**
     * This method makes sure that no job in the PQ is in there for too long without being run
     */
    void starvation();
}

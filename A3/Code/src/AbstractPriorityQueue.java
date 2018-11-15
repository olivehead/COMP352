import java.util.Comparator;

/**
 * This class defines some of the methods to be used in the implementation of a PQ
 * @param <K> A key
 * @param <V> A value
 */
public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {

    protected static class PQEntry<K,V> implements Entry<K,V> {
        private K k;
        private V v;

        /**
         * Constructor for the PQEntry
         * @param key A key
         * @param value A value
         */
        public PQEntry(K key, V value) {
            k = key;
            v = value;
        }

        /**
         * Getter for the key
         * @return the key
         */
        @Override
        public K getKey() {
            return k;
        }

        /**
         * Getter for the value
         * @return the value
         */
        @Override
        public V getValue() {
            return v;
        }

    }

    private Comparator<K> comp;

    /**
     * Constructor for the AbstractPriorityQueue
     * @param c a Comparator for jobs
     */
    protected AbstractPriorityQueue(Comparator<K> c) {
        comp = c;
    }

    /**
     * The default constructor for the AbstractPriorityQueue
     */
    protected AbstractPriorityQueue() {
        comp = null;
    }

    /**
     * This method compares two jobs based on there currentPriority
     * @param a a job priority
     * @param b another job priority
     * @return
     */
    protected int compare(Entry<K,V> a, Entry<K,V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    /**
     * This method checks if a given key is valid
     * @param key a key
     * @return whether or not the key is valid
     * @throws IllegalArgumentException
     */
    protected boolean checkKey(K key) throws IllegalArgumentException {
        try{
            return (comp.compare(key,key) == 0);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    /**
     * Checks to see if the PQ is empty
     * @return whether or not the PQ is empty
     */
    public boolean isEmpty() {
        return size() == 0;
    }

}

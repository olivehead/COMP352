/**
 * This class is an Abstract class for the Hash Table data structure.
 * It is implemented by ChainHashMap, LinearProbeHashMap, and QuadraticProbeHashMap
 */
public abstract class AbstractHashMap {

    protected int n=0;
    protected int capacity;
    protected int collisions = 0;

    /**
     * Constructor for a hash table with the given capacity
     * @param capacity the capacity of the hash table
     */
    public AbstractHashMap(int capacity) {
        this.capacity = capacity;
    }

    /**
     * getter for the capacity
     * @return the capacity of the hash table
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * getter for the collisions
     * @return the number of collisions
     */
    public int getCollisions() {
        return collisions;
    }

    /**
     * gets the element stored at the given key
     * @param key a key
     * @return the element stored at the given key
     */
    public String get(int key) {
        String s = bucketGet(hashValue(key), key);
        return s;
    }

    /**
     * puts the element at the given key
     * @param key a key
     * @param value a value to be stored
     * @return the previous value stored
     */
    public String put(int key, String value) {
        String answer = bucketPut(hashValue(key), key, value);
        return answer;
    }

    /**
     * removes an element from the hash table
     * @param key a key
     * @return the element stored at the given key
     */
    public String remove(int key) {
        String s = bucketRemove(hashValue(key),key);
        return s;
    }

    /**
     * returns the size of the table
     * @return the number of elements in the table
     */
    public int size() {
        return n;
    }

    /**
     * Hashes the key so it fits inside the table
     * @param key a key
     * @return a hashed key
     */
    private int hashValue(int key) {
        return key % capacity;
    }

    /**
     * method to create a new table
     */
    protected abstract void createTable();

    /**
     * method the get the value stored at a given key using different implementations
     * @param h a hashed key
     * @param k the stored key
     * @return the value stored at the hashed key
     */
    protected abstract String bucketGet(int h, int k);

    /**
     * method that puts an element into a hash table using different implementations
     * @param h a hashed key
     * @param k a key
     * @param v a value
     * @return the previous element stored at that hashed key
     */
    protected abstract String bucketPut(int h, int k, String v);

    /**
     * method that removes the element at the given key
     * @param h a hashed key
     * @param k a key
     * @return the element at the given hashed key
     */
    protected abstract String bucketRemove(int h, int k);

}

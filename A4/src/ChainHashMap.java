/**
 * Hash table implemented using separate chaining
 */
public class ChainHashMap extends AbstractHashMap {

    private LinkedList[] table;

    /**
     * constructor for the hash table
     * @param cap the capacity of the hash table
     */
    public ChainHashMap(int cap) {
        super(cap);
        createTable();
    }

    /**
     * creates a new table
     */
    @Override
    protected void createTable() {
        table = new LinkedList[capacity];
    }

    /**
     * gets the value at the given key using separate chaining
     * @param h a hashed key
     * @param k the stored key
     * @return  the value at the given key
     */
    protected String bucketGet(int h, int k) {
        LinkedList bucket = table[h];
        if(bucket == null) {
            return null;
        }
        return bucket.get(k);
    }

    /**
     * puts a new value into the hash table
     * @param h a hashed key
     * @param k a key
     * @param v a value
     * @return returns the previous value at the given key
     */
    protected String bucketPut(int h, int k, String v) {
        LinkedList bucket = table[h];
        if(bucket == null) {
            bucket = table[h] = new LinkedList();
        }
        int oldSize = bucket.size();
        if(!bucket.isEmpty()) {
            collisions++;
        }
        bucket.add(k, v);
        n +=  (bucket.size() - oldSize);
        return null;
    }

    /**
     * removes the value at the given key
     * @param h a hashed key
     * @param k a key
     * @return removes the value at the given key
     */
    protected String bucketRemove(int h, int k) {
        LinkedList bucket = table[h];
        if(bucket == null) {
            return null;
        }
        int oldSize = bucket.size();
        String answer = bucket.remove(k);
        if(bucket.isEmpty()) {
            table[h] = null;
        }
        n -= (oldSize - bucket.size());
        return answer;
    }

    /**
     * returns a string with the contents of the hash table
     * @return a string
     */
    public String toString() {
        String s = "";
        for(int i = 0; i < table.length; i++) {
            s += i + ") " + table[i] + "\r\n";
        }
        return s;
    }

}

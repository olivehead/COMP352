/**
 * Hash table implemented with linear probing
 */
public class LinearProbeHashMap extends AbstractHashMap {

    private MapEntry[] table;
    private MapEntry DEFUNCT = new MapEntry(-1, null);

    /**
     * constructor for the hash table
     * @param cap the capacity of the table
     */
    public LinearProbeHashMap(int cap) {
        super(cap);
        createTable();
    }

    /**
     * creates a new hash table
     */
    @Override
    protected void createTable() {
        table = new MapEntry[capacity];
    }

    /**
     * returns if the current key is available
     * @param j a key
     * @return whether the key is available
     */
    private boolean isAvailable(int j) {
        return (table[j] == null || table[j] == DEFUNCT);
    }

    /**
     * finds the next available slot using linear probing
     * @param h a hashed key
     * @param k a key
     * @return the next available position in the table
     */
    private int findSlot(int h, int k) {
        int avail = -1;
        int j = h;
        do {
            if(isAvailable(j)) {
                if(avail == -1) avail = j;
                if(table[j] == null) break;
            } else if(table[j].getKey() == k) {
                return j;
            }
            j = (j + 1) % capacity;
            collisions++;
        } while(j != h);
        return -(avail + 1);
    }

    /**
     * gets the value stored at the given key
     * @param h a hashed key
     * @param k the stored key
     * @return the value stored at the key
     */
    protected String bucketGet(int h, int k) {
        int j = findSlot(h, k);
        if(j < 0) {
            return null;
        }
        return table[j].getValue();
    }

    /**
     * puts an element in the hash table
     * @param h a hashed key
     * @param k a key
     * @param v a value
     * @return the previous element at the given key
     */
    protected String bucketPut(int h, int k, String v) {
        int j = findSlot(h, k);
        if(j >= 0) {
            n++;
            return table[j].setValue(v);
        }
        table[-(j + 1)] = new MapEntry(k, v);
        n++;
        return null;
    }

    /**
     * removes the element at the given key
     * @param h a hashed key
     * @param k a key
     * @return the element at the given key
     */
    protected String bucketRemove(int h, int k) {
        int j = findSlot(h, k);
        if(j < 0) {
            return null;
        }
        String answer = table[j].getValue();
        table[j] = DEFUNCT;
        n--;
        return answer;
    }

    /**
     * returns a string with the contents of the hash table
     * @return a string
     */
    public String toString() {
        String s = "";
        for(int i = 0; i < capacity; i++) {
            s += i + ") " + table[i] + "\r\n";
        }
        return s;
    }

}

/**
 * Implementation of a hash map using quadratic probing
 */
public class QuadraticProbeHashMap extends AbstractHashMap {
    private MapEntry[] table;
    private MapEntry DEFUNCT = new MapEntry(-1, null);

    /**
     * parameterized constructor
     * @param cap the capacity of the hash map
     */
    public QuadraticProbeHashMap(int cap) {
        super(cap);
        createTable();
    }

    /**
     * creates a new hash table with the current capacity
     */
    @Override
    protected void createTable() {
        table = new MapEntry[capacity];
    }

    /**
     * checks to see if a given key is available
     * @param j a key
     * @return whether the key is available in the hash table
     */
    private boolean isAvailable(int j) {
        return (table[j] == null || table[j] == DEFUNCT);
    }

    /**
     * finds the next available slot using quadratic probing
     * @param h a hashed key
     * @param k a key
     * @return the next available slot
     */
    private int findSlot(int h, int k) {
        int avail = -1;
        int j = h;
        int i = 1;
        do {
            if(isAvailable(j)) {
                if(avail == -1) avail = j;
                if(table[j] == null) break;
            } else if(table[j].getKey() == k) {
                return j;
            }

            j = (h + i * i++) % capacity;
            collisions++;
        } while(j != h);
        return -(avail + 1);
    }

    /**
     * gets the value stored at the given key
     * @param h a hashed key
     * @param k the stored key
     * @return the value stored at the given key
     */
    protected String bucketGet(int h, int k) {
        int j = findSlot(h, k);
        if(j < 0) {
            return null;
        }
        return table[j].getValue();
    }

    /**
     * puts an element into the hash table
     * @param h a hashed key
     * @param k a key
     * @param v a value
     * @return the previous element stored at the hash table
     */
    protected String bucketPut(int h, int k, String v) {
        int j = findSlot(h, k);
        if(j >= 0) {
            n++;
            return table[j].setValue(v);
        }
        table[-(j + 1)] = new MapEntry(k, v);
        n++;
        if (n >= (capacity/2)) {
            System.out.println("\nRESIZING from " + capacity);
            resize();
        }
        return null;
    }

    /**
     * removes the given value at the given key
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
     * resizes the hash table when the capacity is half full
     */
    private void resize() {
        int prevCapacity = capacity;
        capacity = 2 * table.length;
        MapEntry[] oldTable = table;
        table = new MapEntry[capacity];
        n = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null && oldTable[i] != DEFUNCT)
                put(oldTable[i].getKey(), oldTable[i].getValue());
        }
        //FIXME This never gets printed even though resize is called twice
        System.out.println("\nRESIZING from " + prevCapacity + "to " + capacity);
    }

    /**
     * returns a string with the contents of the table
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

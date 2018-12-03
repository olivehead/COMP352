
public class QuadraticProbeHashMap extends AbstractHashMap {
    private MapEntry[] table;
    private MapEntry DEFUNCT = new MapEntry(-1, null);

    public QuadraticProbeHashMap(int cap) {
        super(cap);
        createTable();
    }

    @Override
    protected void createTable() {
        table = new MapEntry[capacity];
    }

    private boolean isAvailable(int j) {
        return (table[j] == null || table[j] == DEFUNCT);
    }

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

    protected String bucketGet(int h, int k) {
        int j = findSlot(h, k);
        if(j < 0) {
            return null;
        }
        return table[j].getValue();
    }

    protected String bucketPut(int h, int k, String v) throws MapFullException {
//        if(size() == capacity) {
//            throw new MapFullException("Hash Map is full");
//        }
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

    private void resize() throws MapFullException {
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

    public String toString() {
        String s = "";
        for(int i = 0; i < capacity; i++) {
            s += i + ") " + table[i] + "\n";
        }
        return s;
    }
}

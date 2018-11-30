public class LinearProbeHashMap<K, V> extends AbstractHashMap<K, V> {

    private MapEntry[] table;
    private MapEntry DEFUNCT = new MapEntry(-1, -1);

    public LinearProbeHashMap() {
        super();
    }

    public LinearProbeHashMap(int cap) {
        super(cap);
        createTable();
    }

    public LinearProbeHashMap(int cap, int p) {
        super(cap, p);
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
        do {
            if(isAvailable(j)) {
                if(avail == -1) avail = j;
                if(table[j] == null) break;
            } else if(table[j].getKey() == k)
                return j;
            j = (j + 1) % capacity;
        } while(j != h);
        return -(avail + 1);
    }

    protected int bucketGet(int h, int k) {
        int j = findSlot(h, k);
        if(j < 0) {
            return -1;
        }
        return table[j].getValue();
    }

    protected int bucketPut(int h, int k, int v) {
        int j = findSlot(h, k);
        if(j >= 0) {
            collisions++;
            n++;
            return table[j].setValue(v);
        }
        table[-(j + 1)] = new MapEntry(k, v);
        n++;
        return -1;
    }

    protected int bucketRemove(int h, int k) {
        int j = findSlot(h, k);
        if(j < 0) {
            return -1;
        }
        int answer = table[j].getValue();
        table[j] = DEFUNCT;
        n--;
        return answer;
    }

    //TODO implement entrySet()
    @Override
    public Iterable<MapEntry> entrySet() {
        return null;
    }

    public String toString() {
        String s = "";
        for(int i = 0; i < capacity; i++) {
            s += i + ") " + table[i] + "\n";
        }
        return s;
    }

}

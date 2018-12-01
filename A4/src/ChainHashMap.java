
public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {

    private LinkedList[] table;

    public ChainHashMap() {
        super();
    }

    public ChainHashMap(int cap) {
        super(cap);
        createTable();
    }

    public ChainHashMap(int cap, int p) {
        super(cap, p);
    }

    @Override
    protected void createTable() {
        table = new LinkedList[capacity];
    }

    protected String bucketGet(int h, int k) {
        LinkedList bucket = table[h];
        if(bucket == null) {
            return null;
        }
        return bucket.get(k);
    }

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

    protected String bucketRemove(int h, int k) {
        LinkedList bucket = table[h];
        if(bucket == null) {
            return null;
        }
        int oldSize = bucket.size();
        String answer = bucket.remove(k);
        n -= (oldSize - bucket.size());
        return answer;
    }

    public String toString() {
        String s = "";
        for(int i = 0; i < table.length; i++) {
            s += table[i] + "\n";
        }
        return s;
    }

    //TODO implement entrySet()
    @Override
    public Iterable<MapEntry> entrySet() {
        return null;
    }

}

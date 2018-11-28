
public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {

    private UnsortedTableMap<K, V>[] table;

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
        table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
    }

    protected int bucketGet(int h, int k) {
        UnsortedTableMap<K, V> bucket = table[h];
        if(bucket == null) {
            return -1;
        }
        return bucket.get(k);
    }

    protected int bucketPut(int h, int k, int v) {
        UnsortedTableMap<K, V> bucket = table[h];
        if(bucket == null) {
            bucket = new UnsortedTableMap<>();
            table[h] = new UnsortedTableMap<>();
        }
        int oldSize = bucket.size();
        int answer = bucket.put(k, v);
        n +=  (bucket.size() - oldSize);
        return answer;
    }

    protected int bucketRemove(int h, int k) {
        UnsortedTableMap<K, V> bucket = table[h];
        if(bucket == null) {
            return -1;
        }
        int oldSize = bucket.size();
        int answer = bucket.remove(k);
        n -= (oldSize - bucket.size());
        return answer;
    }

    //TODO implement entrySet()
    @Override
    public Iterable<MapEntry> entrySet() {
        return null;
    }

}

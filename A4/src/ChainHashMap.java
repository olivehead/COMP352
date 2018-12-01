
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

    protected String bucketGet(int h, int k) {
        UnsortedTableMap<K, V> bucket = table[h];
        if(bucket == null) {
            return null;
        }
        return bucket.get(k);
    }

    protected String bucketPut(int h, int k, String v) {
        UnsortedTableMap<K, V> bucket = table[h];
        if(bucket == null) {
            bucket = table[h] = new UnsortedTableMap<>();
        }
        int oldSize = bucket.size();
        String answer = bucket.put(k, v);
        if(answer != null) {
            collisions++;
        }
        n +=  (bucket.size() - oldSize);
        return answer;
    }

    protected String bucketRemove(int h, int k) {
        UnsortedTableMap<K, V> bucket = table[h];
        if(bucket == null) {
            return null;
        }
        int oldSize = bucket.size();
        String answer = bucket.remove(k);
        n -= (oldSize - bucket.size());
        return answer;
    }

    //TODO implement entrySet()
    @Override
    public Iterable<MapEntry> entrySet() {
        return null;
    }

}

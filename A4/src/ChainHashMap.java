
public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {

    private UnsortedTableMap<K, V>[] table;

    public ChainHashMap() {
        super();
    }

    public ChainHashMap(int cap) {
        super(cap);
    }

    public ChainHashMap(int cap, int p) {
        super(cap, p);
    }

    @Override
    protected void createTable() {
        table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
    }

    @Override
    protected V bucketGet(int h, K k) {
        UnsortedTableMap<K, V> bucket = table[h];
        if(bucket == null) {
            return null;
        }
        return bucket.get(k);
    }

    @Override
    protected V bucketPut(int h, K k, V v) {
        UnsortedTableMap<K, V> bucket = table[h];
        if(bucket == null) {
            bucket = new UnsortedTableMap<>();
            table[h] = new UnsortedTableMap<>();
        }
        int oldSize = bucket.size();
        V answer = bucket.put(k, v);
        n +=  (bucket.size() - oldSize);
        return answer;
    }

    @Override
    protected V bucketRemove(int h, K k) {
        UnsortedTableMap<K, V> bucket = table[h];
        if(bucket == null) {
            return null;
        }
        int oldSize = bucket.size();
        V answer = bucket.remove(k);
        n -= (oldSize - bucket.size());
        return answer;
    }

    //TODO implement entrySet()
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return null;
    }

}

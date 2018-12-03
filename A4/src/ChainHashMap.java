
public class ChainHashMap extends AbstractHashMap {

    private LinkedList[] table;

    public ChainHashMap(int cap) {
        super(cap);
        createTable();
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
        if(bucket.isEmpty()) {
            table[h] = null;
        }
        n -= (oldSize - bucket.size());
        return answer;
    }

    public String toString() {
        String s = "";
        for(int i = 0; i < table.length; i++) {
            s += i + ") " + table[i] + "\n";
        }
        return s;
    }

}

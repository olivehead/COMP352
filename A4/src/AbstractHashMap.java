
public abstract class AbstractHashMap {

    protected int n=0;
    protected int capacity;
    protected int collisions = 0;

    public AbstractHashMap(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCollisions() {
        return collisions;
    }

    public String get(int key) {
        String s = bucketGet(hashValue(key), key);
        return s;
    }

    public String put(int key, String value) {
        String answer = bucketPut(hashValue(key), key, value);
        return answer;
    }

    public String remove(int key) {
        String s = bucketRemove(hashValue(key),key);
        return s;
    }

    public int size() {
        return n;
    }

    private int hashValue(int key) {
        return key % capacity;
    }

    protected abstract void createTable();
    protected abstract String bucketGet(int h, int k);
    protected abstract String bucketPut(int h, int k, String v);
    protected abstract String bucketRemove(int h, int k);

}

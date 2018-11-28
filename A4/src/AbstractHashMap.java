
import java.util.Random;

public abstract class AbstractHashMap<K,V>  extends AbstractMap<K,V> {
    protected int n=0;
    protected int capacity;
    private int prime;
    private long scale, shift;

    public AbstractHashMap() {
        this(10);
    }

    public AbstractHashMap(int capacity, int prime) {
        this.capacity = capacity;
        this.prime = prime;
        Random rand = new Random();
        scale = rand.nextInt(prime-1)+1;
        shift = rand.nextInt(prime);
        createTable();
    }

    public AbstractHashMap(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        return bucketGet(hashValue(key), key);
    }

    public int put(int key, int value) {
        long startTime = System.currentTimeMillis();
        int answer = bucketPut(hashValue(key), key, value);
        //TODO implement once resize is fixed
//        if(n < capacity/2)
//            resize(2*capacity-1);
        long endTime = System.currentTimeMillis();
        System.out.print("Time to add entry: ");
        System.out.println(endTime - startTime);
        return answer;
    }

    public int remove(int key) {
        return bucketRemove(hashValue(key),key);
    }

    @Override
    public int size() {
        return n;
    }

    private int hashValue(int key) {
        return key % capacity;
    }

    //TODO implement resizing once entrySet() is fixed
//    private void resize(int newCap) {
//        ArrayList<Entry<K,V>> buffer = new ArrayList<>(n);
//        for(MapEntry e: entrySet())
//            buffer.add(e);
//        capacity = newCap;
//        createTable();
//        n=0;
//        for(Entry<K,V> e: buffer)
//            put(e.getKey(),e.getValue());
//    }

    protected abstract void createTable();
    protected abstract int bucketGet(int h, int k);
    protected abstract int bucketPut(int h, int k, int v);
    protected abstract int bucketRemove(int h, int k);
}

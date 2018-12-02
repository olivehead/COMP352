
import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractHashMap<K,V>  extends AbstractMap<K,V> {

    protected int n=0;
    protected int capacity;
    private int prime;
    private long scale, shift;
    protected int collisions = 0;

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

    public String get(int key) {
        long startTime = System.nanoTime();
        String s = bucketGet(hashValue(key), key);
        long endTime = System.nanoTime();
        System.out.print("Time to get entry: ");
        System.out.println(endTime - startTime + " ns");
        return s;
    }

    public String put(int key, String value) throws MapFullException {
        long startTime = System.nanoTime();
        System.out.println("Hashed key: " + hashValue(key));
        String answer = bucketPut(hashValue(key), key, value);
        //TODO implement once resize is fixed
//        if(n < capacity/2)
//            resize(2*capacity-1);
        long endTime = System.nanoTime();
        System.out.print("Time to add entry: ");
        System.out.println((endTime - startTime) + " ns");
        System.out.println("Size of the table: " + capacity);
        System.out.println("Number of elements: " + size());
        System.out.println("Number of collisions: " + collisions);
        System.out.println();
        return answer;
    }

    public String remove(int key) {
        long startTime = System.nanoTime();
        String s = bucketRemove(hashValue(key),key);
        long endTime = System.nanoTime();
        System.out.print("Time to remove entry: ");
        System.out.println(endTime - startTime + " ns");
        return s;
    }

    @Override
    public int size() {
        return n;
    }

    private int hashValue(int key) {
        return key % capacity;
    }

    //TODO implement resizing once entrySet() is fixed
    private void resize(int newCap) throws MapFullException {
        ArrayList<MapEntry> buffer = new ArrayList<>();
        for(MapEntry e: entrySet())
            buffer.add(0, e);
        capacity = newCap;
        createTable();
        n=0;
        for(MapEntry e: buffer)
            put(e.getKey(),e.getValue());
    }

    protected abstract void createTable();
    protected abstract String bucketGet(int h, int k);
    protected abstract String bucketPut(int h, int k, String v) throws MapFullException;
    protected abstract String bucketRemove(int h, int k);

}

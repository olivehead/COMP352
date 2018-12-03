
public abstract class AbstractHashMap {

    protected int n=0;
    protected int capacity;
    protected int collisions = 0;

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

    public int size() {
        return n;
    }

//    public boolean isEmpty() {
//        return size() == 0;
//    }

    private int hashValue(int key) {
        return key % capacity;
    }

    protected abstract void createTable();
    protected abstract String bucketGet(int h, int k);
    protected abstract String bucketPut(int h, int k, String v) throws MapFullException;
    protected abstract String bucketRemove(int h, int k);

}

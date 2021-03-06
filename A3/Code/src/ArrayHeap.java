import java.util.Comparator;

/**
 * This class is an implementation of a PQ using an Array based Heap
 * @param <K> a key
 * @param <V> a value
 */
public class ArrayHeap<K, V> extends AbstractPriorityQueue<K, V> {

    private MyArrayList<Entry<K, V>> heap = new MyArrayList<>();

    /**
     * Constructor for the heap
     * @param comp a comparator for jobs
     */
    public ArrayHeap(Comparator<K> comp) {
        super(comp);
    }

    /**
     * returns the parent of the given node
     * @param i the position of the desired node
     * @return the position of the parent node
     */
    private int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * This method returns the position of the left child of the given node
     * @param i the position of the given node
     * @return the position of the left child of the node
     */
    private int left(int i) {
        return 2 * i + 1;
    }

    /**
     * This method returns the position of the right child of the given node
     * @param i the position of the node
     * @return the position of the right child of the given node
     */
    private int right(int i) {
        return 2 * i + 2;
    }

    /**
     * returns whether or not the given node has a left child
     * @param i the position of the given node
     * @return if the given node has a left child
     */
    private boolean hasLeft(int i) {
        return left(i) < heap.size();
    }

    /**
     * returns whether or not the given node has a right child
     * @param i the position of the given node
     * @return if the given node has a right child
     */
    private boolean hasRight(int i) {
        return right(i) < heap.size();
    }

    /**
     * swaps two nodes in the heap
     * @param i the position of the first node
     * @param j the position of the second node
     */
    private void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * this method takes a node and moves it up if it is smaller than its parent node
     * @param j the position of the given node
     */
    private void upheap(int j) {
        while(j > 0) {
            int p = parent(j);
            if(compare(heap.get(j), heap.get(p)) >= 0) {
                break;
            }
            swap(j, p);
            j = p;
        }
    }

    /**
     * This method takes a node, and pushes it to the bottom of the heap if it is bigger than its children
     * @param j the position of the given node
     */
    private void downheap(int j) {
        while(hasLeft(j)) {
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            if(hasRight(j)) {
                int rightIndex = right(j);
                if(compare(heap.get(leftIndex), heap.get(rightIndex)) > 0) {
                    smallChildIndex = rightIndex;
                }
            }
            if(compare(heap.get(smallChildIndex), heap.get(j)) >= 0) {
                break;
            }
            swap(j, smallChildIndex);
            j = smallChildIndex;
        }
    }

    /**
     * returns the size of the heap
     * @return the size of the heap
     */
    public int size() {
        return heap.size();
    }

    /**
     * returns whether or not the heap is empty
     * @return if the heap is empty
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * inserts a new element in the heap
     * @param j a job
     * @return the job that was just inserted
     * @throws IllegalArgumentException
     */
    public Entry<K, V> insert(Job j) throws IllegalArgumentException {
        Entry<K, V> newest = j;
        heap.add(heap.size(), newest);
        upheap(heap.size() - 1);
        findOldest();
        return newest;
    }

    /**
     * removes the element with the smallest key
     * @return the element with the smallest key
     */
    public Entry<K, V> removeMin() {
        if(heap.isEmpty()) {
            return null;
        }
        Entry<K, V> answer = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downheap(0);
        findOldest();
        return answer;
    }

    /**
     * finds the job with the oldest entry time which has not been run yet
     * @return
     */
    public Entry findOldest() {
        return heap.findMax();
    }

    /**
     * finds the oldest job and changes its priority to the highest priority
     */
    public void starvation() {
        Job oldest = (Job) findOldest();
        if(oldest != null) {
            oldest.setFinalPriority(1);
        }
    }

}

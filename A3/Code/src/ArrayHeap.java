import java.util.Comparator;

public class ArrayHeap<E> extends PriorityQueue {

    private MyArrayList<Entry<E>> heap = new MyArrayList<>();
    private Comparator<E> comp;

    public ArrayHeap(Comparator<E> c) {
        comp = c;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private boolean hasLeft(int i) {
        return left(i) < heap.size();
    }

    private boolean hasRight(int i) {
        return right(i) < heap.size();
    }

    private void swap(int i, int j) {
        Entry<E> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

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

    public int compare(Entry<E> a, Entry<E> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    private boolean checkKey(E key) throws IllegalArgumentException {
        try {
            return (comp.compare(key, key) == 0);
        }
        catch(ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public Entry<E> min() {
        if(heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    public Entry<E> insert(E key) {
        checkKey(key);
        Entry<E> newest = new Job();
        heap.add(heap.size() - 1, newest);
        upheap(heap.size() - 1);
        return newest;
    }

    public Entry<E> removeMin() {
        if(heap.isEmpty()) {
            return null;
        }
        Entry<E> answer = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downheap(0);
        return answer;
    }

}

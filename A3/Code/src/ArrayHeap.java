public class ArrayHeap<E> {

    private MyArrayList<E> heap;

    public ArrayHeap() {
        heap = new MyArrayList<>();
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public boolean hasLeft(int i) {
        return left(i) < heap.size();
    }

    public boolean hasRight(int i) {
        return right(i) < heap.size();
    }

    public void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void upheap(int j) {
        while(j > 0) {
            int p = parent(j);
            if(compare(heap.get(j), heap.get(p)) >= 0) {
                break;
            }
            swap(j, p);
            j = p;
        }
    }

}

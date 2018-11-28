
public class ArrayList<E> {

    public static final int CAPACITY = 16;
    private E[] data;
    private int size;

    public ArrayList() {
        this(CAPACITY);
    }

    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
        checkIndex(i, size);
        if(size == data.length) {
            resize(2 * data.length);
        }
        for(int j = size - 1; j >= i; j--) {
            data[j + 1] = data[j];
        }
        data[i] = e;
        size++;
    }

    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for(int j = i; i < size - 1; i++) {
            data[j] = data[j + 1];
        }
        data[size - 1] = null;
        size--;
        return temp;
    }

    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if(i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

    protected void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for(int j = 0; j < size; j++) {
            temp[j] = data[j];
        }
        data = temp;
    }

}

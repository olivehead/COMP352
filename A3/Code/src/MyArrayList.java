/**
 * This class implements an ArrayList to be used in ArrayHeap
 * @param <E> an element
 */
public class MyArrayList<E> {

    private static final int INITIAL_CAPACITY = 10;
    private int capacity;
    private E[] data;
    private int size;

    /**
     * Constructor for the ArrayList
     */
    public MyArrayList() {
        data = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
        capacity = INITIAL_CAPACITY;
    }

    /**
     * Gets the element at position i
     * @param i the position of the element
     * @return the element at the desired position
     * @throws IndexOutOfBoundsException
     */
    public E get(int i)throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    /**
     * sets the element at position i
     * @param i the position of the element
     * @param e the element to be set
     * @return The previous element at position i
     */
    public E set(int i, E e) {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    /**
     * Adds a new element to the ArrayList at position i
     * @param i the position
     * @param e the element
     */
    public void add(int i, E e) {
        checkIndex(i, size);
        for(int j = size; j > i; j--) {
            data[j] = data[j - 1];
        }
        data[i] = e;
        size++;
        resize();
    }

    /**
     * Removes the element at position index
     * @param index the position of the element
     * @return the element being removed
     * @throws IndexOutOfBoundsException
     * @throws IllegalStateException
     */
    public E remove(int index) throws IndexOutOfBoundsException, IllegalStateException {
        if(this.size == 0) {
            throw new IllegalStateException("List is empty");
        }
        checkIndex(index, size + 1);
        E element = data[index];
        for(int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        resize();
        return element;
    }

    /**
     * prints the contents of the ArrayList
     * @return the contents of the ArrayList as a String
     */
    @Override
    public String toString() {
        String a = "[";
        for (int i = 0; i < size; i++) {
            a += data[i] + ", ";
        }
        a += "]";
        return a;
    }

    /**
     * returns the size of the ArrayList
     * @return the size
     */
    public int size() {
        return this.size;
    }

    /**
     * returns whether or not the ArrayList is empty
     * @return if the ArrayList is empty
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * checks if the index is within the given bounds
     * @param i the index
     * @param n the upper bound
     * @throws IndexOutOfBoundsException
     */
    public void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if(i < 0 || i > n) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }

    /**
     * resizes the array if it is full or half empty
     */
    public void resize() {
        if(size == capacity) {
            E[] newList = (E[]) new Object[2 * capacity];
            for(int i = 0; i < size; i++) {
                newList[i] = data[i];
            }
            capacity = 2 * capacity;
            data = newList;
        }
        if(size <= capacity / 4) {
            E[] newList = (E[]) new Object[capacity / 2];
            for(int i = 0; i < size; i++) {
                newList[i] = data[i];
            }
            capacity = capacity / 2;
            data = newList;
        }
    }

    /**
     * finds the maximum value of the ArrayList based on the job entry time
     * @return the maximum value
     */
    public Job findMax() {
        Job max = null;
        for(int i = 0; i < size; i++) {
            Job current = (Job) data[i];
            if(max == null && current.getLastRun() == 0) {
                max = current;
            }
            if(max != null && current.getEntryTime() > max.getEntryTime() && current.getLastRun() == 0) {
                max = current;
            }
        }
        return max;
    }

}

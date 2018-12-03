/**
 * LinkedList class used to implement separate chaining
 */
public class LinkedList {

    /**
     * Node class to be used in linked list
     */
    private static class Node {

        private MapEntry element;
        private Node previous;
        private Node next;

        public Node(MapEntry element, Node previous, Node next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }

        public MapEntry getElement() {
            return element;
        }

        public Node getPrevious() {
            return previous;
        }

        public Node getNext() {
            return next;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    private Node head;
    private Node tail;
    private int size;

    /**
     * constructor for the linked list
     */
    public LinkedList() {
        head = new Node(null, null, null);
        tail = new Node(null, head, null);
        head.setNext(tail);
    }

    /**
     * returns the size of the list
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * return whether the list is empty
     * @return if the list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * adds a new element at the given position
     * @param k a position
     * @param v a value
     */
    public void add(int k, String v) {
        MapEntry m = new MapEntry(k, v);
        Node newest = new Node(m, tail.getPrevious(), tail);
        tail.getPrevious().setNext(newest);
        tail.setPrevious(newest);
        size++;
    }

    /**
     * removes the element at the given position
     * @param key a position
     * @return the value at the given position
     */
    public String remove(int key) {
        Node position = head.next;
        String value;
        while(position != null) {
            if(position.getElement().getKey() == key) {
                value = position.getElement().getValue();
                position.previous.setNext(position.next);
                position.next.setPrevious(position.previous);
                size--;
                return value;
            }
            position = position.next;
        }
        return null;
    }

    /**
     * returns the value at the given position
     * @param key a position
     * @return the value stored at the position
     */
    public String get(int key) {
        Node position = head.next;
        while(position != null) {
            if(position.getElement() != null) {
                if(position.getElement().getKey() == key) {
                    return position.getElement().getValue();
                }
            }
            position = position.next;
        }
        return null;
    }

    /**
     * returns a string with the contents of the list
     * @return
     */
    public String toString() {
        String s = "";
        Node position = head.next;
        while(position.getNext() != null) {
            s += position.getElement() + " ";
            position = position.next;
        }
        return s;
    }

}

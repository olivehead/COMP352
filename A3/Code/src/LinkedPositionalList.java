
public class LinkedPositionalList<E> implements PositionalList<E> {

    private static class Node<E> implements Position<E> {
        private E element; // reference to the element stored at this node
        private Node<E> prev; // reference to the previous node
        private Node<E> next; // reference to the next node

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        public E getElement() throws IllegalStateException {
//            if (next == null)
//                throw new IllegalStateException("Position no longer VALID");
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    //head, tail and size for linked list
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    /**\
     * Empty constructor
     */
    public LinkedPositionalList() {
        head = new Node<>(null,null,null);
        tail = new Node<>(null,head,null);
        head.setNext(tail);
    }

    /**
     * validate position and returns node, internal helper function.
     * @param p Node at position
     * @return  Node at position
     * @throws IllegalArgumentException
     */
    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
        Node<E> node = (Node<E>) p;
        if (node.getNext() == null)
            throw new IllegalArgumentException("p is no longer in the list");
        return node;
    }

    /**
     * Returns the given node as a Position
     * @param node
     * @return Node as a Position<E>
     */
    private Position<E> position(Node<E> node) {
        if (node == head || node == tail)
            return null; // do not expose user to the sentinels
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Position<E> first() {
        return position(head.getNext());
    }

    @Override
    public Position<E> last() {
        return position(tail.getPrev());
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    /**
     * Adds element e to the lined list between the given nodes.
     * @param e element
     * @param pred previous element to position<E></E>
     * @param succ next element to position<E></E>
     * @return  newly placed element in list
     */
    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<>(e,pred,succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }

    @Override
    public Position<E> addFirst(E e) {
        return addBetween(e,head,head.getNext());
    }

    @Override
    public Position<E> addLast(E e) {
        return addBetween(e,tail.getPrev(),tail);
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    @Override
    /**
     * Replaces element stored at Position p and returns the replaced element.
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }

    @Override
    /**
     * Remove the element stored at Position p and returns it (invalidating p)
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E answer = node.getElement();
        node.setElement(null);
        node.setNext(null);
        node.setPrev(null);
        return answer;
    }


    /**
     * Find starved element in the list by comparing the EntryTime
     * @return Element which has been waiting the longest
     */
    public Job findMax() {
        Node position = head.next;
        Job maxJob = (Job) head.next.getElement();
        while(position != null) {
            Job current = (Job) position.getElement();
            if(current == null) {
                return maxJob;
            }
            if(maxJob == null && current.getLastRun() == 0) {
                maxJob = (Job) position.getElement();
            }
            if(maxJob != null && maxJob.getEntryTime() < current.getEntryTime() && current.getLastRun() == 0) {
                maxJob = (Job) position.getElement();
            }
            position = position.next;
        }
        return maxJob;
    }

}

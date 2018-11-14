import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionalList<E> {

    private static class Node<E> implements Position<E> {
        private E element; // reference to the element stored at this node
        private Node<E> prev; // reference to the previous node in the list
        private Node<E> next; // reference to the subsequent node in the list

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        public E getElement() throws IllegalStateException {
            if (next == null)
                throw new IllegalStateException("Position no longer VALID");
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
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public LinkedPositionalList() {
        head = new Node<>(null,null,null);
        tail = new Node<>(null,head,null);
        head.setNext(tail);
    }

    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
        Node<E> node = (Node<E>) p;
        if (node.getNext() == null)
            throw new IllegalArgumentException("p is no longer in the list");
        return node;
    }

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

    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E answer = node.getElement();
        node.setElement(null); // help with garbage collection
        node.setNext(null); // and convention for defunct node
        node.setPrev(null);
        return answer;
    }
    //---------------- nested PositionIterator class ----------------
    private class PositionIterator implements Iterator<Position<E>> {
        private Position<E> cursor = first(); // position of the next element to report
        private Position<E> recent = null; // position of last reported element
        //∗∗ Tests whether the iterator has a next object. ∗/
        public boolean hasNext() { return (cursor != null); }
        //∗∗ Returns the next position in the iterator. ∗/
        public Position<E> next() throws NoSuchElementException {
            if (cursor == null) throw new NoSuchElementException("nothing left");
            recent = cursor; // element at this position might later be removed
            cursor = after(cursor);
            return recent;
        }
        //∗∗ Removes the element returned by most recent call to next. ∗/
        public void remove() throws IllegalStateException {
            if (recent == null) throw new IllegalStateException("nothing to remove");
            LinkedPositionalList.this.remove(recent); // remove from outer list
            recent = null; // do not allow remove again until next is called
        }
    } //------------ end of nested PositionIterator class ------------

    // ---------------- nested PositionIterable class ----------------
    public class PositionIterable implements Iterable<Position<E>> {
        public Iterator<Position<E>> iterator() { return new PositionIterator(); }
    } //------------ end of nested PositionIterable class ------------

    //∗∗ Returns an iterable representation of the list's positions. ∗/
    public Iterable<Position<E>> positions() {
        return new PositionIterable(); // create a new instance of the inner class
    }

    //---------------- nested ElementIterator class ----------------
    //∗ This class adapts the iteration produced by positions() to return elements. ∗/
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = new PositionIterator();
        public boolean hasNext() { return posIterator.hasNext(); }
        public E next() { return posIterator.next().getElement(); } // return element!
        public void remove() { posIterator.remove(); }
    }

    //∗∗ Returns an iterator of the elements stored in the list. ∗/
    public Iterator<E> iterator() { return new ElementIterator(); }


    //TODO finish to implement starvation for Sorted Priority Queue, currently doesn't work
    @Override
    public Position<E> findMax() {
        Node position = head;
        Node max = null;
        while(position != null) {
            Job maxJob = (Job) max.getElement();
            Job current = (Job) position.getElement();
            if(max == null) {
                max = position;
            }
            else if(maxJob.getEntryTime() < current.getEntryTime()) {
                max = position;
            }
            position.setNext(position.next);
        }
        return max;
    }

}

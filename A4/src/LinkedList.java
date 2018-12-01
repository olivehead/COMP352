public class LinkedList {

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

    public LinkedList() {
        head = new Node(null, null, null);
        tail = new Node(null, head, null);
        head.setNext(tail);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public MapEntry first() {
        if(isEmpty()) {
            return null;
        }
        return head.getNext().getElement();
    }

    public MapEntry last() {
        if(isEmpty()) {
            return null;
        }
        return tail.getPrevious().getElement();
    }

    public void add(int k, String v) {
        MapEntry m = new MapEntry(k, v);
        Node newest = new Node(m, tail.getPrevious(), tail);
        tail.getPrevious().setNext(newest);
        tail.setPrevious(newest);
        size++;
    }

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

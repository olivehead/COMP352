import java.util.Comparator;

public class SortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    /**
     * Doubly Linked List implemented using AbstractPriorityQueue
     */
    private PositionalList<Entry<K,V>> list = new LinkedPositionalList<>();

    public SortedPriorityQueue(Comparator<K> comp) { super(comp); }

    /**
     * Inserts a job and returns the entry created.
     * @param j Job
     * @return key-value pair created within the linked list
     * @throws IllegalArgumentException
     */
    public Entry<K,V> insert(Job j) throws IllegalArgumentException {
        Entry<K,V> newest = j;
        Position<Entry<K,V>> walk = list.last();
        while (walk != null && compare(newest, walk.getElement()) < 0)
            walk = list.before(walk);
        if (walk == null)
            list.addFirst(newest); // new key is smallest
        else
        list.addAfter(walk, newest); // newest goes after walk
        return newest;
    }

    public Entry<K,V> removeMin() {
        if (list.isEmpty()) return null;
        return list.remove(list.first());
    }

    public Job findOldest() {
        return list.findMax();
    }

    @Override
    /**
     * Finds oldest job in the PQ and changes the priority to 1
     */
    public void starvation() {
        Job oldest = findOldest();
        if(oldest != null) {
            oldest.setFinalPriority(1);
        }
    }

    public int size() { return list.size(); }
}

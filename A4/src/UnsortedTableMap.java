import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {

    private ArrayList<MapEntry> table = new ArrayList<>();

    public UnsortedTableMap() {}

    public int findIndex(int key) {
        int n = table.size();
        for(int i = 0; i < n; i++) {
            if(table.get(i).getKey() == key) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return table.size();
    }

    public int get(int key) {
        int j = findIndex(key);
        if(j == -1) {
            return -1;
        }
        return table.get(j).getValue();
    }

    public int put(MapEntry m) {
        int j = findIndex(m.getKey());
        if(j == -1) {
            table.add(j, new MapEntry());
            return -1;
        }
        else {
            return table.get(j).setValue(m.getValue());
        }
    }

    public int remove(int key) {
        int j = findIndex(key);
        int n = size();
        if(j == -1) {
            return -1;
        }
        int answer = table.get(j).getValue();
        if(j != n - 1) {
            table.set(j, table.get(n - 1));
        }
        table.remove(n - 1);
        return answer;
    }

    private class EntryIterator implements Iterator<MapEntry> {
        private int j = 0;
        public boolean hasNext() {
            return j < table.size();
        }
        public MapEntry next() {
            if(j == table.size()) {
                throw new NoSuchElementException();
            }
            return table.get(j++);
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class EntryIterable implements Iterable<MapEntry> {
        public Iterator<MapEntry> iterator() {
            return new EntryIterator();
        }
    }

    @Override
    public Iterable<MapEntry> entrySet() {
        return new EntryIterable();
    }

}

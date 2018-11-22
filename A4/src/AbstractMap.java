import java.util.Iterator;
import java.util.function.Consumer;

public abstract class AbstractMap<K,V> implements Map<K,V> {

    protected static class MapEntry<K,V> implements Entry<K,V> {
        private K k;
        private V v;

        public MapEntry(K k, V v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }

        protected void setKey(K k) {
            this.k = k;
        }

        protected V setValue(V v) {
            V old = this.v;
            this.v = v;
            return old;
        }
    }
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    private class KeyIterator implements Iterator<K> {
        private Iterator<Entry<K,V>> entries = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public K next() {
            return entries.next().getKey();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void forEachRemaining(Consumer<? super K> action) {
            throw new UnsupportedOperationException();
        }
    }

    private class KeyIterable implements Iterable<K> {
        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }

    public Iterable<K> keySet() {
        return new KeyIterable();
    }

    // Support for public values method...
    private class ValueIterator implements Iterator<V> {
        private Iterator<Entry<K,V>> entries = entrySet().iterator(); // reuse entrySet
        public boolean hasNext() { return entries.hasNext(); }
        public V next() { return entries.next().getValue(); } // return value!
        public void remove() { throw new UnsupportedOperationException(); }
    }
    private class ValueIterable implements Iterable<V> {
        public Iterator<V> iterator() { return new ValueIterator(); }
    }
    public Iterable<V> values() { return new ValueIterable(); }
}

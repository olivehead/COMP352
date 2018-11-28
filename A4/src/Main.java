public class Main {
    public static void main(String[] args) {
        MapEntry[] entries = new MapEntry[50];
        for(int i = 0; i < 50; i++) {
            entries[i] = new MapEntry();
            entries[i].setKey(entries[i].hashCode());
        }
        ChainHashMap map = new ChainHashMap(100);
        for(int i = 0; i < 50; i++) {
            map.put(entries[i].getKey(), entries[i].getValue());
        }
    }
}

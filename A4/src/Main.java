public class Main {
    public static void main(String[] args) {
        MapEntry[] entries = new MapEntry[50];
        for(int i = 0; i < 50; i++) {
            entries[i] = new MapEntry();
        }

        ChainHashMap map = new ChainHashMap(100);
        for(int i = 0; i < 50; i++) {
            map.put(entries[i].getHashedKey(), entries[i].getValue());
        }
        System.out.println(map);
        for(int i = 0; i < 50; i++) {
            System.out.println(map.get(entries[i].getHashedKey()));
        }
        for(int i = 0; i < 25; i++) {
            map.remove(entries[i].getHashedKey());
        }
        System.out.println(map);
        for(int i = 0; i < 50; i++) {
            System.out.println(map.get(entries[i].getHashedKey()));
        }


        LinearProbeHashMap map1 = new LinearProbeHashMap(100);
        for(int i = 0; i < 50; i++) {
            map1.put(entries[i].getHashedKey(), entries[i].getValue());
        }
        System.out.println(map1);
        for(int i = 0; i < 50; i++) {
            System.out.println(map1.get(entries[i].getHashedKey()));
        }
        for(int i = 0; i < 25; i++) {
            map1.remove(entries[i].getHashedKey());
        }
        System.out.println(map1);
        for(int i = 0; i < 50; i++) {
            System.out.println(map1.get(entries[i].getHashedKey()));
        }
    }
}

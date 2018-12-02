public class Main {
    public static void main(String[] args) {
        try {
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


            MapEntry[] entries1 = new MapEntry[150];
            for(int i = 0; i < 150; i++) {
                entries1[i] = new MapEntry();
            }

            ChainHashMap map2 = new ChainHashMap(100);
            for(int i = 0; i < 150; i++) {
                map2.put(entries1[i].getHashedKey(), entries1[i].getValue());
            }
            System.out.println(map2);
            for(int i = 0; i < 150; i++) {
                System.out.println(map2.get(entries1[i].getHashedKey()));
            }
            for(int i = 0; i < 25; i++) {
                map2.remove(entries1[i].getHashedKey());
            }
            System.out.println(map2);
            for(int i = 0; i < 150; i++) {
                System.out.println(map2.get(entries1[i].getHashedKey()));
            }


            LinearProbeHashMap map3 = new LinearProbeHashMap(100);
            for(int i = 0; i < 150; i++) {
                map3.put(entries1[i].getHashedKey(), entries1[i].getValue());
            }
            System.out.println(map3);
            for(int i = 0; i < 50; i++) {
                System.out.println(map3.get(entries1[i].getHashedKey()));
            }
            for(int i = 0; i < 25; i++) {
                map3.remove(entries1[i].getHashedKey());
            }
            System.out.println(map3);
            for(int i = 0; i < 50; i++) {
                System.out.println(map3.get(entries1[i].getHashedKey()));
            }
        }
        catch(MapFullException e) {
            System.out.println();
            System.out.println("Hash Map is full");
        }
    }
}

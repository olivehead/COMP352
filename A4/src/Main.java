public class Main {
    public static void main(String[] args) {
        MapEntry[] entries = new MapEntry[50];
        for(int i = 0; i < 50; i++) {
            entries[i] = new MapEntry();
            entries[i].setKey(entries[i].hashCode());
        }
        ChainHashMap map = new ChainHashMap(100);
        LinearProbeHashMap map1 = new LinearProbeHashMap(100);
        for(int i = 0; i < 50; i++) {
            map.put(entries[i].getKey(), entries[i].getValue());
        }
        System.out.println();
        System.out.println();
        System.out.println(map);
//        for(int i = 0; i < 50; i++) {
//            System.out.println(map1.get(entries[i].getKey()));
//        }
//        for(int i = 0; i < 25; i++) {
//            System.out.println(map1.remove(entries[i].getKey()));
//        }
//        for(int i = 0; i < 50; i++) {
//            System.out.println(map1.get(entries[i].getKey()));
//        }
//        System.out.println();
//        System.out.println();
//        for(int i = 0; i < 50; i++) {
//            map1.put(entries[i].getKey(), entries[i].getValue());
//        }
//        System.out.println(map1);
//        for(int i = 0; i < 50; i++) {
//            System.out.println(map1.get(entries[i].getKey()));
//        }
//        for(int i = 0; i < 25; i++) {
//            System.out.println(map1.remove(entries[i].getKey()));
//        }
//        System.out.println(map1);
//        for(int i = 0; i < 50; i++) {
//            System.out.println(map1.get(entries[i].getKey()));
//        }
    }
}

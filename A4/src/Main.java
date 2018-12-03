public class Main {
    public static void main(String[] args) {
        try {
            MapEntry[] entries = new MapEntry[50];
            for(int i = 0; i < 50; i++) {
                entries[i] = new MapEntry();
            }
            MapEntry[] entries1 = new MapEntry[150];
            for(int i = 0; i < 150; i++) {
                entries1[i] = new MapEntry();
            }
            //***************************STEP 4*****************
            System.out.println();
            System.out.println("SEPARATE CHAINING HASH MAP");
            System.out.println();

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

            System.out.println();
            System.out.println("LINEAR PROBING HASH MAP");
            System.out.println();

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

            System.out.println();
            System.out.println("QUADRATIC PROBING HASH MAP");
            System.out.println();

            QuadraticProbeHashMap mapq = new QuadraticProbeHashMap(101);
            for(int i = 0; i < 50; i++) {
                mapq.put(entries[i].getHashedKey(), entries[i].getValue());
            }
            System.out.println(mapq);
            for(int i = 0; i < 50; i++) {
                System.out.println(mapq.get(entries[i].getHashedKey()));
            }
            for(int i = 0; i < 25; i++) {
                mapq.remove(entries[i].getHashedKey());
            }
            System.out.println(mapq);
            for(int i = 0; i < 50; i++) {
                System.out.println(mapq.get(entries[i].getHashedKey()));
            }
            
            //*******************STEP 5**********************************

            System.out.println("\n\nSTEP 5\n\n");

            System.out.println("Separate Chaining\n");

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

            System.out.println("\nLinear Probing\n");

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

            System.out.println("\nQuadratic Probing\n");

            QuadraticProbeHashMap map3q = new QuadraticProbeHashMap(100);
            for(int i = 0; i < 150; i++) {
                map3q.put(entries1[i].getHashedKey(), entries1[i].getValue());
            }
            System.out.println(map3q);
            for(int i = 0; i < 50; i++) {
                System.out.println(map3q.get(entries1[i].getHashedKey()));
            }
            for(int i = 0; i < 25; i++) {
                map3q.remove(entries1[i].getHashedKey());
            }
            System.out.println(map3q);
            for(int i = 0; i < 50; i++) {
                System.out.println(map3q.get(entries1[i].getHashedKey()));
            }

            //************STEP 6: Dynamic Resizing*********************
            MapEntry[] entries2 = new MapEntry[10000];
            for(int i = 0; i < 10000; i++) {
                entries2[i] = new MapEntry();
            }
            System.out.println("\nDynamic Resizing for Quadratic Probe Hash Table:\n\n");
            QuadraticProbeHashMap mapq3 = new QuadraticProbeHashMap(128);
            long startTime = System.currentTimeMillis();
            for(int i = 0; i < 10000; i++) {
                mapq3.put(entries2[i].getHashedKey(), entries2[i].getValue());
            }
            long endTime = System.currentTimeMillis();
            System.out.println(mapq3);
            System.out.println();
            System.out.print("Time to add 10000 elements: ");
            System.out.println(endTime - startTime + " ms");
//            for(int i = 0; i < 50; i++) {
//                System.out.println(mapq3.get(entries1[i].getHashedKey()));
//            }
        }
        catch(MapFullException e) {
            System.out.println();
            System.out.println("Hash Map is full");
        }
    }
}

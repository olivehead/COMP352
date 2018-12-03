import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        PrintWriter fout1 = null;
        PrintWriter fout2 = null;
        PrintWriter fout3 = null;
        try {
            fout1 = new PrintWriter("ChainHashMap.txt");
            fout2 = new PrintWriter("LinearHashMap.txt");
            fout3 = new PrintWriter("QuadraticHashMap.txt");
            MapEntry[] entries = new MapEntry[50];
            for(int i = 0; i < 50; i++) {
                entries[i] = new MapEntry();
            }
            MapEntry[] entries1 = new MapEntry[150];
            for(int i = 0; i < 150; i++) {
                entries1[i] = new MapEntry();
            }
            //***************************STEP 4*****************
            fout1.println();
            fout1.println("SEPARATE CHAINING HASH MAP");
            fout1.println();

            ChainHashMap map = new ChainHashMap(100);
            for(int i = 0; i < 50; i++) {
                long startTime = System.nanoTime();
                map.put(entries[i].getHashedKey(), entries[i].getValue());
                long endTime = System.nanoTime();
                fout1.print("Time to add entry: ");
                fout1.println((endTime - startTime) + " ns");
                fout1.println("Size of the table: " + map.getCapacity());
                fout1.println("Number of elements: " + map.size());
                fout1.println("Number of collisions: " + map.getCollisions());
                fout1.println();
            }
            fout1.println(map);
            for(int i = 0; i < 50; i++) {
                long startTime = System.nanoTime();
                fout1.println(map.get(entries[i].getHashedKey()));
                long endTime = System.nanoTime();
                fout1.print("Time to get entry: ");
                fout1.println(endTime - startTime + " ns");
            }
            for(int i = 0; i < 25; i++) {
                long startTime = System.nanoTime();
                map.remove(entries[i].getHashedKey());
                long endTime = System.nanoTime();
                fout1.print("Time to remove entry: ");
                fout1.println(endTime - startTime + " ns");
            }
            fout1.println();
            fout1.println(map);
            for(int i = 0; i < 50; i++) {
                long startTime = System.nanoTime();
                fout1.println(map.get(entries[i].getHashedKey()));
                long endTime = System.nanoTime();
                fout1.print("Time to get entry: ");
                fout1.println(endTime - startTime + " ns");
            }

            fout2.println();
            fout2.println("LINEAR PROBING HASH MAP");
            fout2.println();

            LinearProbeHashMap map1 = new LinearProbeHashMap(100);
            for(int i = 0; i < 50; i++) {
                long startTime = System.nanoTime();
                map1.put(entries[i].getHashedKey(), entries[i].getValue());
                long endTime = System.nanoTime();
                fout2.print("Time to add entry: ");
                fout2.println((endTime - startTime) + " ns");
                fout2.println("Size of the table: " + map1.getCapacity());
                fout2.println("Number of elements: " + map1.size());
                fout2.println("Number of collisions: " + map1.getCollisions());
                fout2.println();
            }
            fout2.println(map1);
            for(int i = 0; i < 50; i++) {
                long startTime = System.nanoTime();
                fout2.println(map1.get(entries[i].getHashedKey()));
                long endTime = System.nanoTime();
                fout2.print("Time to get entry: ");
                fout2.println(endTime - startTime + " ns");
            }
            for(int i = 0; i < 25; i++) {
                long startTime = System.nanoTime();
                map1.remove(entries[i].getHashedKey());
                long endTime = System.nanoTime();
                fout2.print("Time to remove entry: ");
                fout2.println(endTime - startTime + " ns");
            }
            fout2.println(map1);
            for(int i = 0; i < 50; i++) {
                long startTime = System.nanoTime();
                fout2.println(map1.get(entries[i].getHashedKey()));
                long endTime = System.nanoTime();
                fout2.print("Time to get entry: ");
                fout2.println(endTime - startTime + " ns");
            }

            fout3.println();
            fout3.println("QUADRATIC PROBING HASH MAP");
            fout3.println();

            QuadraticProbeHashMap mapq = new QuadraticProbeHashMap(100);
            for(int i = 0; i < 50; i++) {
                long startTime = System.nanoTime();
                mapq.put(entries[i].getHashedKey(), entries[i].getValue());
                long endTime = System.nanoTime();
                fout3.print("Time to add entry: ");
                fout3.println((endTime - startTime) + " ns");
                fout3.println("Size of the table: " + mapq.getCapacity());
                fout3.println("Number of elements: " + mapq.size());
                fout3.println("Number of collisions: " + mapq.getCollisions());
                fout3.println();
            }
            fout3.println(mapq);
            for(int i = 0; i < 50; i++) {
                long startTime = System.nanoTime();
                fout3.println(mapq.get(entries[i].getHashedKey()));
                long endTime = System.nanoTime();
                fout3.print("Time to get entry: ");
                fout3.println(endTime - startTime + " ns");
            }
            for(int i = 0; i < 25; i++) {
                long startTime = System.nanoTime();
                mapq.remove(entries[i].getHashedKey());
                long endTime = System.nanoTime();
                fout3.print("Time to remove entry: ");
                fout3.println(endTime - startTime + " ns");
            }
            fout3.println(mapq);
            for(int i = 0; i < 50; i++) {
                long startTime = System.nanoTime();
                fout3.println(mapq.get(entries[i].getHashedKey()));
                long endTime = System.nanoTime();
                fout3.print("Time to get entry: ");
                fout3.println(endTime - startTime + " ns");
            }
            
            //*******************STEP 5**********************************

            fout1.println("\r\n\r\nSTEP 5\r\n\r\n");

            fout1.println("Separate Chaining\r\n");

            ChainHashMap map2 = new ChainHashMap(100);
            for(int i = 0; i < 150; i++) {
                long startTime = System.nanoTime();
                map2.put(entries1[i].getHashedKey(), entries1[i].getValue());
                long endTime = System.nanoTime();
                fout1.print("Time to add entry: ");
                fout1.println((endTime - startTime) + " ns");
                fout1.println("Size of the table: " + map2.getCapacity());
                fout1.println("Number of elements: " + map2.size());
                fout1.println("Number of collisions: " + map2.getCollisions());
                fout1.println();
            }
            fout1.println(map2);
            for(int i = 0; i < 150; i++) {
                long startTime = System.nanoTime();
                fout1.println(map2.get(entries1[i].getHashedKey()));
                long endTime = System.nanoTime();
                fout1.print("Time to get entry: ");
                fout1.println(endTime - startTime + " ns");
            }
            for(int i = 0; i < 25; i++) {
                long startTime = System.nanoTime();
                map2.remove(entries1[i].getHashedKey());
                long endTime = System.nanoTime();
                fout1.print("Time to remove entry: ");
                fout1.println(endTime - startTime + " ns");
            }
            fout1.println(map2);
            for(int i = 0; i < 150; i++) {
                long startTime = System.nanoTime();
                fout1.println(map2.get(entries1[i].getHashedKey()));
                long endTime = System.nanoTime();
                fout1.print("Time to get entry: ");
                fout1.println(endTime - startTime + " ns");
            }

            fout2.println("\r\n\r\nSTEP 5\r\n\r\n");

            fout2.println("\r\nLinear Probing\r\n");

            LinearProbeHashMap map3 = new LinearProbeHashMap(100);
            for(int i = 0; i < 150; i++) {
                long startTime = System.nanoTime();
                map3.put(entries1[i].getHashedKey(), entries1[i].getValue());
                long endTime = System.nanoTime();
                fout2.print("Time to add entry: ");
                fout2.println((endTime - startTime) + " ns");
                fout2.println("Size of the table: " + map3.getCapacity());
                fout2.println("Number of elements: " + map3.size());
                fout2.println("Number of collisions: " + map3.getCollisions());
                fout2.println();
            }
            fout2.println(map3);
            for(int i = 0; i < 50; i++) {
                long startTime = System.nanoTime();
                fout2.println(map3.get(entries1[i].getHashedKey()));
                long endTime = System.nanoTime();
                fout2.print("Time to get entry: ");
                fout2.println(endTime - startTime + " ns");
            }
            for(int i = 0; i < 25; i++) {
                long startTime = System.nanoTime();
                map3.remove(entries1[i].getHashedKey());
                long endTime = System.nanoTime();
                fout2.print("Time to remove entry: ");
                fout2.println(endTime - startTime + " ns");
            }
            fout2.println(map3);
            for(int i = 0; i < 50; i++) {
                long startTime = System.nanoTime();
                fout2.println(map3.get(entries1[i].getHashedKey()));
                long endTime = System.nanoTime();
                fout2.print("Time to get entry: ");
                fout2.println(endTime - startTime + " ns");
            }

            fout3.println("\r\n\r\nSTEP 5\r\n\r\n");

            fout3.println("\r\nQuadratic Probing\r\n");

            fout3.println("\r\nCapacity 100\r\n");

            QuadraticProbeHashMap map3q = new QuadraticProbeHashMap(100);
            for(int i = 0; i < 150; i++) {
                long startTime = System.nanoTime();
                map3q.put(entries1[i].getHashedKey(), entries1[i].getValue());
                long endTime = System.nanoTime();
                fout3.print("Time to add entry: ");
                fout3.println((endTime - startTime) + " ns");
                fout3.println("Size of the table: " + map3q.getCapacity());
                fout3.println("Number of elements: " + map3q.size());
                fout3.println("Number of collisions: " + map3q.getCollisions());
                fout3.println();
            }
            fout3.println(map3q);
            for(int i = 0; i < 50; i++) {
                long startTime = System.nanoTime();
                fout3.println(map3q.get(entries1[i].getHashedKey()));
                long endTime = System.nanoTime();
                fout3.print("Time to get entry: ");
                fout3.println(endTime - startTime + " ns");
            }
            for(int i = 0; i < 25; i++) {
                long startTime = System.nanoTime();
                map3q.remove(entries1[i].getHashedKey());
                long endTime = System.nanoTime();
                fout3.print("Time to remove entry: ");
                fout3.println(endTime - startTime + " ns");
            }
            fout3.println(map3q);
            for(int i = 0; i < 50; i++) {
                long startTime = System.nanoTime();
                fout3.println(map3q.get(entries1[i].getHashedKey()));
                long endTime = System.nanoTime();
                fout3.print("Time to get entry: ");
                fout3.println(endTime - startTime + " ns");
            }

            fout3.println("\r\nCapacity 101\r\n");

            QuadraticProbeHashMap map3q1 = new QuadraticProbeHashMap(101);
            for(int i = 0; i < 150; i++) {
                long startTime = System.nanoTime();
                map3q1.put(entries1[i].getHashedKey(), entries1[i].getValue());
                long endTime = System.nanoTime();
                fout3.print("Time to add entry: ");
                fout3.println((endTime - startTime) + " ns");
                fout3.println("Size of the table: " + map3q1.getCapacity());
                fout3.println("Number of elements: " + map3q1.size());
                fout3.println("Number of collisions: " + map3q1.getCollisions());
                fout3.println();
            }
            fout3.println(map3q1);
            for(int i = 0; i < 50; i++) {
                long startTime = System.nanoTime();
                fout3.println(map3q1.get(entries1[i].getHashedKey()));
                long endTime = System.nanoTime();
                fout3.print("Time to get entry: ");
                fout3.println(endTime - startTime + " ns");
            }
            for(int i = 0; i < 25; i++) {
                long startTime = System.nanoTime();
                map3q1.remove(entries1[i].getHashedKey());
                long endTime = System.nanoTime();
                fout3.print("Time to remove entry: ");
                fout3.println(endTime - startTime + " ns");
            }
            fout3.println(map3q1);
            for(int i = 0; i < 50; i++) {
                long startTime = System.nanoTime();
                fout3.println(map3q1.get(entries1[i].getHashedKey()));
                long endTime = System.nanoTime();
                fout3.print("Time to get entry: ");
                fout3.println(endTime - startTime + " ns");
            }

            //************STEP 6: Dynamic Resizing*********************
            MapEntry[] entries2 = new MapEntry[10000];
            for(int i = 0; i < 10000; i++) {
                entries2[i] = new MapEntry();
            }
            fout3.println("\r\nDynamic Resizing for Quadratic Probe Hash Table:\r\n\r\n");
            QuadraticProbeHashMap mapq3 = new QuadraticProbeHashMap(128);
            long totalStartTime = System.currentTimeMillis();
            for(int i = 0; i < 10000; i++) {
                long startTime = System.nanoTime();
                mapq3.put(entries2[i].getHashedKey(), entries2[i].getValue());
                long endTime = System.nanoTime();
                fout3.print("Time to add entry: ");
                fout3.println((endTime - startTime) + " ns");
                fout3.println("Size of the table: " + mapq3.getCapacity());
                fout3.println("Number of elements: " + mapq3.size());
                fout3.println("Number of collisions: " + mapq3.getCollisions());
                fout3.println();
            }
            long totalEndTime = System.currentTimeMillis();
            fout3.println(mapq3);
            fout3.println();
            fout3.print("Time to add 10000 elements: ");
            fout3.println(totalEndTime - totalStartTime + " ms");
            for(int i = 0; i < 10000; i++) {
                long startTime = System.nanoTime();
                fout3.println(mapq3.get(entries2[i].getHashedKey()));
                long endTime = System.nanoTime();
                fout3.print("Time to get entry: ");
                fout3.println(endTime - startTime + " ns");
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if(fout1 != null || fout2 != null || fout3 != null) {
                fout1.close();
                fout2.close();
                fout3.close();
            }
        }
    }
}

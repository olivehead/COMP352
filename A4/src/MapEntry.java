import java.util.Random;

public class MapEntry {

    Integer key;
    int value;

    public MapEntry() {
        Random rand = new Random();
        key = rand.nextInt();
        value = rand.nextInt();
    }

    public int hashCode() {
        String temp = Integer.toBinaryString(key);
        int total = 0;
        int z = 33;
        for(int i = 0; i < temp.length(); i++) {
            total += temp.charAt(i) * z ^ i;
        }
        return total;
    }

}

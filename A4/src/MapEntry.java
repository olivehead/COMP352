import java.util.Random;

public class MapEntry {

    Integer key;
    int value;

    public MapEntry() {
        Random rand = new Random();
        key = rand.nextInt();
        value = rand.nextInt();
    }

    public MapEntry(int k, int v) {
        key = k;
        value = v;
    }

    public int hashCode() {
        String temp = Integer.toBinaryString(key);
        int total = 0;
        int z = 33;
        for(int i = 0; i < temp.length(); i++) {
            total += temp.charAt(i) * z ^ i;
        }
        return Math.abs(total);
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public int setValue(int value) {
        int old = this.value;
        this.value = value;
        return old;
    }

    public void setKey(int k) {
        key = k;
    }
}

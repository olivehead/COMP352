import java.util.Random;

public class MapEntry {

    private Integer key;
    private String value;
    private int hashedKey;
    private static int count = 0;

    public MapEntry() {
        Random rand = new Random();
        key = rand.nextInt();
        value = "Entry " + (count + 1);
        hashedKey = hashCode();
        count++;
    }

    public MapEntry(int k, String v) {
        key = k;
        value = v;
        hashedKey = hashCode();
    }

//    public int hashCode() {
//        String temp = Integer.toBinaryString(key);
//        int total = 0;
//        int z = 33;
//        for(int i = 0; i < temp.length(); i++) {
//            total += temp.charAt(i) * z ^ i;
//        }
//        return Math.abs(total);
//    }

    public int hashCode() {
        int h = ((key << 5) | (key >>> 27));
        return Math.abs(h);
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String setValue(String value) {
        String old = this.value;
        this.value = value;
        return old;
    }

    public int getHashedKey() {
        return hashedKey;
    }

    public void setKey(int k) {
        key = k;
    }

    public String toString() {
        return "Key: " + key + " Hashed Key: " + hashedKey + " value: " + value;
    }

}

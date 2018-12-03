import java.util.Random;

/**
 * MapEntry class to be used as the element put inside the hash tables
 */
public class MapEntry {

    private Integer key;
    private String value;
    private int hashedKey;
    private static int count = 0;

    /**
     * Constructor for a MapEntry
     */
    public MapEntry() {
        Random rand = new Random();
        key = rand.nextInt();
        value = "Entry " + (count + 1);
        hashedKey = hashCode();
        count++;
    }

    /**
     * Parameterized constructor for a MapEntry
     * @param k a key
     * @param v a value
     */
    public MapEntry(int k, String v) {
        key = k;
        value = v;
        hashedKey = hashCode();
    }

    /**
     * method which hashes a given key
     * @return a hashed key
     */
    public int hashCode() {
        int h = ((key << 5) | (key >>> 27));
        return Math.abs(h);
    }

    /**
     * getter for the key
     * @return a key
     */
    public int getKey() {
        return key;
    }

    /**
     * getter for the value
     * @return a value
     */
    public String getValue() {
        return value;
    }

    /**
     * setter for the value
     * @param value a value to be set
     * @return the previous value
     */
    public String setValue(String value) {
        String old = this.value;
        this.value = value;
        return old;
    }

    /**
     * getter for the hashed key
     * @return a hashed key
     */
    public int getHashedKey() {
        return hashedKey;
    }

    /**
     * Returns the MapEntry as a string
     * @return a string
     */
    public String toString() {
        return "Key: " + key + " value: " + value;
    }

}

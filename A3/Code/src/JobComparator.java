import java.util.Comparator;

/**
 * Compares jobs using Integers, return -1,0,1
 */
public class JobComparator implements Comparator<Integer> {

    public int compare(Integer a, Integer b) {

        if(a > b) {
            return 1;
        }
        else if(a == b) {
            return 0;
        }
        else {
            return -1;
        }

    }

}

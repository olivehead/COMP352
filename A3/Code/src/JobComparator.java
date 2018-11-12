import java.util.Comparator;

public class JobComparator implements Comparator<Integer> {

    public int compare(Integer a, Integer b) {

        if(a > b) {
            return 1;
        }
        else if(a == b) {
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
        else {
            return -1;
        }

    }

}

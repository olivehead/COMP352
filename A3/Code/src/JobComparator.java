import java.util.Comparator;

public class JobComparator<E> implements Comparator<Job<E>> {

    //TODO finish compare once job is finished
    public int compare(Job a, Job b) {
        if (a.getJobPriority() < b.getJobPriority()) return 1;
        if (a.getJobPriority() == b.getJobPriority()) return 0;
        return -1;
    }

}

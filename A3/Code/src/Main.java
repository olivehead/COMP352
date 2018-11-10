
public class Main {

    public static void main(String[] args) {
	    Job[][] jobs = null;
	    ArrayHeap pq = new ArrayHeap(new JobComparator());
	    for(int i = 0; i < 5; i++) {
	        for(int j = 0; j < 100; j *= 10) {
	            jobs[i][j] = new Job();
            }
        }
        for(Job job : jobs[0]) {
            pq.insert(job.getKey());
        }
        while(!pq.isEmpty()) {
            pq.removeMin();
        }
    }

}


public class Main {

    public static void main(String[] args) {
        int[] maxNumberOfJobs = new int[] {100,1000,10000};
	    Job<Integer,String>[][] jobs = new Job[maxNumberOfJobs.length][maxNumberOfJobs[maxNumberOfJobs.length-1]];
	    PriorityQueue<Integer,String> pq = new ArrayHeap<>(new JobComparator());
	    for(int i = 0; i < maxNumberOfJobs.length; i++) {
	        for(int j = 0; j < maxNumberOfJobs[i]; j++) {
	            jobs[i][j] = new Job<>();
	            jobs[i][j].setKey(jobs[i][j].getJobPriority());
                jobs[i][j].setValue(jobs[i][j].getJobName());
            }
            Job.resetCounter();
        }
        for(Job job : jobs[0]) {
        }
        while(!pq.isEmpty()) {
            pq.removeMin();
        }
    }

}

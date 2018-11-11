
public class Main {

    public static void main(String[] args) {
	    Job[] jobs = new Job[10];
	    for(int i = 0; i < jobs.length; i++) {
	        jobs[i] = new Job();
        }
        ArrayHeap pq = new ArrayHeap<>(new JobComparator<>());
        long startTime = System.currentTimeMillis();
        for(Job job : jobs) {
            pq.insert(job.getKey());
        }
        while(!pq.isEmpty()) {
            Entry currentJob = pq.removeMin();
            int key = (int) currentJob.getKey();
            System.out.println(currentJob);
            currentJob.setKey(--key);
            pq.insert(currentJob);
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }

}

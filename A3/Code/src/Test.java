public class Test {
    //Testing the implementation of ArrayHeap
    public static void main(String[] args) {
        long startTime;
        long endTime;
        long totalTime;
        long priorityChanges = 0;
        long averageWaitTime = 0;
        long cycleCount = 0;
        int n = 10;
        ArrayHeap<Integer, Job> pq = new ArrayHeap<>(new JobComparator());
        Job[] jobs = new Job[n];
        for(int i = 0; i < n; i++) {
            jobs[i] = new Job();
        }
        startTime = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            pq.insert(jobs[i]);
            jobs[i].setEntryTime((long) i + 1);
        }
        while(!pq.isEmpty()) {
            Job j = (Job) pq.removeMin();
            j.setCurrentLength(j.getCurrentLength() - 1);
            cycleCount = cycleCount + 1;
            System.out.println(j);
            System.out.println();
            if(j.getCurrentLength() != 0) {
                pq.insert(j);
            }
        }
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;

        System.out.println("Current system time (cycles): " + cycleCount);
        System.out.println("Total number of jobs executed: " + n + " jobs");
        System.out.println("Average process waiting time: " + averageWaitTime + " cycles");
        System.out.println("Total number of priority changes: " + priorityChanges);
        System.out.println("Actual system time needed to execute all jobs: " + totalTime + " ms");
    }

}

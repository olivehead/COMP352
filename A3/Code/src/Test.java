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

        SortedPriorityQueue<Integer, Job> pq = new SortedPriorityQueue<>(new JobComparator());
        Job[] jobs = new Job[n];
        for(int i = 0; i < n; i++) {
            jobs[i] = new Job();
        }
        startTime = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            pq.insert(jobs[i]);
            jobs[i].setEntryTime(i + 1);
        }
        while(!pq.isEmpty()) {
            Job j = (Job) pq.removeMin();
            j.setCurrentLength(j.getCurrentLength() - 1);
            cycleCount += 1;
            System.out.println(j);
            //System.out.println(pq.findOldest());
            System.out.println(cycleCount);
            System.out.println();
            if(j.getCurrentLength() != 0) {
                j.setLastRun(cycleCount);
                pq.insert(j);
//                if(cycleCount % 30 == 0) {
//                    pq.starvation();
//                    priorityChanges++;
//                }
            }
            else {
                j.setEndTime(cycleCount);
                j.setWaitTime(j.getEndTime() - j.getJobLength() - j.getEntryTime());
                averageWaitTime += j.getWaitTime();
//                if(cycleCount % 30 == 0) {
//                    pq.starvation();
//                    priorityChanges++;
//                }
            }
        }
        averageWaitTime /= n;
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;

        System.out.println("Current system time (cycles): " + cycleCount);
        System.out.println("Total number of jobs executed: " + n + " jobs");
        System.out.println("Average process waiting time: " + averageWaitTime + " cycles");
        System.out.println("Total number of priority changes: " + priorityChanges);
        System.out.println("Actual system time needed to execute all jobs: " + totalTime + " ms");

    }

}

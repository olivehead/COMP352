import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {

        long startTime;
        long endTime;
        long totalTime;
        long priorityChanges = 0;
        long averageWaitTime = 0;
        long cycleCount = 0;
        int n = 10000;

        try (PrintWriter fout = new PrintWriter("out.txt")) {
            for (int i = 100; i <= n; i *= 10) {
                fout.println();
                fout.println("ArrayHeap Simulation");
                fout.println();
                Job[] jobs = new Job[i];
                ArrayHeap<Integer, Job> pq = new ArrayHeap<>(new JobComparator());
                for (int j = 0; j < jobs.length; j++) {
                    jobs[j] = new Job();
                }
                Job.resetCounter();
                startTime = System.currentTimeMillis();
                for (int j = 0; j < i; j++) {
                    pq.insert(jobs[j]);
                    jobs[j].setEntryTime(j + 1);
                }
                while (!pq.isEmpty()) {
                    Job j = (Job) pq.removeMin();
                    j.setCurrentLength(j.getCurrentLength() - 1);
                    cycleCount += 1;
                    System.out.println(j);
                    System.out.println();
                    if (j.getCurrentLength() != 0) {
                        j.setLastRun(cycleCount);
                        pq.insert(j);
                        if (cycleCount % 30 == 0) {
                            pq.starvation();
                            priorityChanges++;
                        }
                    } else {
                        j.setEndTime(cycleCount);
                        j.setWaitTime(j.getEndTime() - j.getJobLength() - j.getEntryTime());
                        averageWaitTime += j.getWaitTime();
                        if (cycleCount % 30 == 0) {
                            pq.starvation();
                            priorityChanges++;
                        }
                    }
                }
                averageWaitTime /= i;
                endTime = System.currentTimeMillis();
                totalTime = endTime - startTime;

                fout.println("Current system time (cycles): " + cycleCount);
                fout.println("Total number of jobs executed: " + i + " jobs");
                fout.println("Average process waiting time: " + averageWaitTime + " cycles");
                fout.println("Total number of priority changes: " + priorityChanges);
                fout.println("Actual system time needed to execute all jobs: " + totalTime + " ms");
                fout.println();

                priorityChanges = 0;
                averageWaitTime = 0;
                cycleCount = 0;

                fout.println();
                fout.println("Sorted Priority Queue Simulation:");
                fout.println();

                SortedPriorityQueue<Integer, Job> pqSorted = new SortedPriorityQueue<>(new JobComparator());
                for (int j = 0; j < jobs.length; j++) {
                    jobs[j] = new Job();
                }
                Job.resetCounter();
                startTime = System.currentTimeMillis();
                for (int j = 0; j < i; j++) {
                    pqSorted.insert(jobs[j]);
                    jobs[j].setEntryTime(j + 1);
                }
                while (!pqSorted.isEmpty()) {
                    Job j = (Job) pqSorted.removeMin();
                    j.setCurrentLength(j.getCurrentLength() - 1);
                    cycleCount += 1;
                    System.out.println(j);
                    System.out.println();
                    if (j.getCurrentLength() != 0) {
                        j.setLastRun(cycleCount);
                        pqSorted.insert(j);
                        if (cycleCount % 30 == 0) {
                            //TODO implement findOldest
                            pqSorted.starvation();
                            priorityChanges++;
                        }
                    } else {
                        j.setEndTime(cycleCount);
                        j.setWaitTime(j.getEndTime() - j.getJobLength() - j.getEntryTime());
                        averageWaitTime += j.getWaitTime();
                        if (cycleCount % 30 == 0) {
                            //TODO implement findOldest
                            pqSorted.starvation();
                            priorityChanges++;
                        }
                    }
                }
                averageWaitTime /= i;
                endTime = System.currentTimeMillis();
                totalTime = endTime - startTime;

                fout.println("Current system time (cycles): " + cycleCount);
                fout.println("Total number of jobs executed: " + i + " jobs");
                fout.println("Average process waiting time: " + averageWaitTime + " cycles");
                fout.println("Total number of priority changes: " + priorityChanges);
                fout.println("Actual system time needed to execute all jobs: " + totalTime + " ms");
                fout.println();

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

import java.util.Random;

/**
 * Defines CPU job, and is sorted in the {@link PriorityQueue} using the CurrentPriority as the Key,
 * and the JobName as the Value.
 * @param <K> jobPriority
 * @param <V> jobName
 */
public class Job<K,V> implements Entry<Integer, String> {
    private String jobName;
    private int jobLength;
    private int currentLength;
    private int jobPriority;
    private int finalPriority;
    private long entryTime;
    private long endTime;
    private long waitTime;
    //Second Key to compare when 2 jobs have the same priority
    private long lastRun;
    //Keep track of the number of jobs created to name the jobs accordingly
    private static int jobCount;

    private static final int MAXJOBLENGTH = 70;
    private static final int MAXJOBPRIORITY = 40;

    public Job() {
        Random random = new Random();
        jobName = "Job_" + (jobCount++ + 1);
        jobLength = random.nextInt(MAXJOBLENGTH) + 1;
        currentLength = jobLength;
        jobPriority = random.nextInt(MAXJOBPRIORITY) + 1;
        finalPriority = jobPriority;
        entryTime = 0;
        endTime = 0;
        waitTime = 0;
        lastRun = 0;
    }

    /**
     * Resets the jobCounter to aid in the
     * creation of another array of jobs
     */
    public static void resetCounter() {
        jobCount = 0;
    }

    @Override
    public String toString() {
        return "Now executing " + jobName + ". " + "Job Length: " + jobLength + " cycles, " +
                "Current remaining length: " + currentLength + ", cycles," + "\nInitial Priority: " +
                jobPriority + ", Current Priority: " + finalPriority;
    }

    public int getJobLength() {
        return jobLength;
    }

    public int getCurrentLength() {
        return currentLength;
    }

    public void setCurrentLength(int currentLength) {
        this.currentLength = currentLength;
    }

    public void setFinalPriority(int finalPriority) {
        this.finalPriority = finalPriority;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getWaitTime() {
        waitTime = endTime - entryTime - jobLength;
        return waitTime;
    }

    public void setWaitTime(long waitTime) {
        this.waitTime = waitTime;
    }

    public long getLastRun() {
        return lastRun;
    }

    public void setLastRun(long lastRun) {
        this.lastRun = lastRun;
    }

    @Override
    public Integer getKey() {
        return finalPriority;
    }

}

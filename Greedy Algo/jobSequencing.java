import java.util.*;

public class jobSequencing {

    static class Job {
        int deadline;
        int profit;
        int id;
        
        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        int jobInfo[][] = { { 4, 20 }, { 1, 20 }, { 1, 40 }, { 1, 30 } };
        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }
        // jobs will be in decending order of profit
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);
        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < jobInfo.length; i++) {
            Job currJob = jobs.get(i);
            if (currJob.deadline > time) {
                seq.add(currJob.id);
                time++;
            }
        }
        System.out.println("max job = " + seq.size());
        System.out.println("jobs seq = " + seq);
    }
}

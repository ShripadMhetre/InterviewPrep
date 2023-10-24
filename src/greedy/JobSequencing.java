package greedy;

import java.util.Arrays;

/*
    Q. You are given a set of N jobs where each job comes with a deadline and profit.
        The profit can only be earned upon completing the job within its deadline. Find the
        number of jobs done and the maximum profit that can be obtained. Each job takes a single
        unit of time and only one job can be performed at a time.

        Example 1:
        Input: N = 4, Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
        Output: 2 60

        Explanation: The 3rd job with a deadline 1 is performed during the first unit of time .The 1st job is performed during the second unit of time as its deadline is 4.
        Profit = 40 + 20 = 60

        Example 2:
        Input: N = 5, Jobs = {(1,2,100),(2,1,19),(3,2,27),(4,1,25),(5,1,15)}
        Output: 2 127

        Explanation: The  first and third job both having a deadline 2 give the highest profit.
        Profit = 100 + 27 = 127
 */
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
public class JobSequencing {
    // T.C. - O(N log N) + O(N*M)  (i.e. sorting + looping)
    public static int[] solution(Job[] jobs, int N) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i].deadline);
        }

        int[] sequencing = new int[maxDeadline+1];
        Arrays.fill(sequencing, -1);

        int jobCount = 0, maxProfit = 0;
        for (int i = 0; i < N; i++) {
            for (int j = jobs[i].deadline; j > 0; j--) {
                if (sequencing[j] == -1) {
                    sequencing[j] = i;
                    jobCount++;
                    maxProfit += jobs[i].profit;
                    break;
                }
            }
        }

        return new int[]{jobCount, maxProfit};

    }
    public static void main(String[] args) {
        int N = 4;
        Job[] jobs = new Job[N];

        jobs[0] = new Job(1, 4, 20);
        jobs[1] = new Job(2, 1, 10);
        jobs[2] = new Job(3, 1, 40);
        jobs[3] = new Job(4, 1, 30);

        int[] ans = solution(jobs, N);
        System.out.println("Job Performed: " + ans[0] + " & Max Profit: " + ans[1]);
    }
}

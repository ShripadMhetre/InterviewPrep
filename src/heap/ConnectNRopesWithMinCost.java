package heap;

import java.util.PriorityQueue;

/*
    Q. Connect n ropes with minimum cost.
        e.g. arr = [2, 5, 4, 8, 6, 9]
            Ans: 85
            Explanation: always take minimum length rope to add to the cost variable
                1st: connect 2 and 4, cost = 2+4 = 6
                now array becomes [6, 5, 8, 6, 9]

                2nd: connect 6 and 5, cost = 6+5=11
                now array = [11, 8, 6, 9]

                3rd: connect 6 and 8, cost = 6+8=14
                now array = [11, 14, 9]

                4th: connect 9 and 11, cost = 11+9=20
                now array = [14, 20]

                5th: connect remaining 2 ropes, cost = 14+20=34


                totalCost = addition of all costs from 5 steps
                totalCost = 6+11+14+20+34 = 85


             Solution idea - idea is to always get 2 minimum cost ropes to connect
                        hence we use minHeap (i.e. PriorityQueue)
 */
public class ConnectNRopesWithMinCost {
    // Time Complexity: O(NlogN)
    private static int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        int ans = 0;

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            int sum = first + second;

            ans += sum;
            pq.add(sum);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 8, 6, 9};

        int ans = minCost(arr);

        System.out.println("min cost to connect the ropes is: " + ans);
    }
}

package dp;

import java.util.Arrays;

public class ZeroOneKnapsack {

    public static int solution(int[] val, int[] wt, int w) {
        if (val.length == 0 || wt.length == 0) return 0;

        int n = val.length;

        int[][] dp = new int[n+1][w+1];

        // if no items present to choose from
        for (int col = 0; col <= w; col++) {
            dp[0][col] = 0;
        }

        // if weight of the knapsack is 0 then we can't choose any item
        for (int row = 0; row <= n; row++) {
            dp[row][0] = 0;
        }

        // main logic
        for (int item = 1; item <= n; item++) {
            for (int capacity = 1; capacity <= w; capacity++) {
                int maxWithoutCurr = dp[item-1][capacity];  // maxValue without taking current item
                int maxWithCurr = 0;    // initialized to 0

                // if current items weight fits into capacity
                if (capacity >= wt[item-1]) {
                    maxWithCurr += val[item-1]; // adding value of current item

                    // if some weight is remaining from capacity after including current item
                    // then add dp value calculated for the remaining weight from previous item
                    if (capacity - wt[item-1] > 0) {
                        maxWithCurr += dp[item-1][capacity - wt[item-1]];
                    }
                }

                // max Value for current capacity and no. of items will be max of 2 values (i.e. including or excluding)
                dp[item][capacity] = Math.max(maxWithCurr, maxWithoutCurr);
            }
        }

//        System.out.println(Arrays.deepToString(dp));

        // returning the answer for total items and weight of knapsack given
        return dp[n][w];
    }

    public static int recursive(int[] val, int[] wt, int cap, int idx) {
        if (idx == 0 || cap == 0) return 0;

        if (wt[idx] > cap) {
            return recursive(val, wt, cap, idx-1);
        }
        return Math.max(recursive(val, wt, cap, idx-1), val[idx] + recursive(val, wt, cap-wt[idx], idx-1));
    }

    public static void main(String[] args) {
        int w = 10;
        int n = 4;
        int[] val = {10, 40, 30, 50};
        int[] wt = {5, 4, 6, 3};

        int res = solution(val, wt, w);
//        int res = recursive(val, wt, w, n-1);

        System.out.println("Max Value: " + res);
    }
}

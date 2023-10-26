package dp;

import java.util.Arrays;

public class ClimbingStairs {
    public static int recursive(int i, int n) {
        if (i > n) return 0;
        if (i == n) return 1;

        return recursive(i+1, n) + recursive(i+2, n);
    }

    // Top Down
    public static int topDown(int i, int n, int[] dp) {
        if (i > n) return 0;
        if (i == n) return 1;

        if (dp[i] != -1) return dp[i];

        dp[i+1] = topDown(i+1, n, dp);
        dp[i+2] = topDown(i+2, n, dp);

        return dp[i+1] + dp[i+2];
    }

    // Bottom Up
    public static int bottomUp(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;
//        int ans = recursive(0, n);

//        int[] dp = new int[n+1];
//        Arrays.fill(dp, -1);
//        dp[0] = 0;
//        dp[1] = 1;
//        int ans = topDown(0, n, dp);

        int ans = bottomUp(n);
        System.out.println("unique ways: " + ans);
    }
}

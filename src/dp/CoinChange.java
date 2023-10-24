package dp;

import java.util.Arrays;

/*
    Q. You are given an integer array coins representing coins of different denominations and an integer amount
        representing a total amount of money. Return the fewest number of coins that you need to make up that amount.
        If that amount of money cannot be made up by any combination of the coins, return -1.

        You may assume that you have an infinite number of each kind of coin.

        Example 1:
        Input: coins = [1,2,5], amount = 11
        Output: 3
        Explanation: 11 = 5 + 5 + 1

        Example 2:
        Input: coins = [2], amount = 3
        Output: -1

        Example 3:
        Input: coins = [1], amount = 0
        Output: 0
 */
public class CoinChange {
    // same recursive solution can be turned into memoization by adding dp check before looping
    public static int coinChangeRecursive(int[] coins, int amount) {
        if (amount == 0) return 0;

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if (amount-coins[i] >= 0) {
                int subAns = coinChangeRecursive(coins, amount-coins[i]);

                if (subAns != Integer.MAX_VALUE && subAns+1 < answer) {
                    answer = subAns+1;
                }
            }
        }

        return answer;
    }


    public static int coinChangeBottomUp(int[] coins, int amount) {
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return (dp[amount] == Integer.MAX_VALUE) ?  -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println(coinChangeRecursive(coins, amount));

        // DP solution
        System.out.println(coinChangeBottomUp(coins, amount));
    }
}

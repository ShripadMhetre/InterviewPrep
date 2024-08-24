package bits;

import java.util.Arrays;

/*
    Q. Given an integer n, count the number of 1's in the binary representation of every number in the range [0, n].
    Return an array output where output[i] is the number of 1's in the binary representation of i.
    Example 1:
        Input: n = 4
        Output: [0,1,1,2,1]

    Note: brute force approach solves in NlogN.
    i.e. loop over 1 to n and for each number calculate no. of 1 bits by mod approach or ANDing with 1 approach
 */
public class CountingBits {
    // T.C. -> O(N)
    public static int[] solution(int n) {
        int[] dp = new int[n+1];    // stores 0 to n numbers

        int offset = 1;
        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) offset = i;
            dp[i] = 1 + dp[i-offset];
        }

        return dp;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(Arrays.toString(solution(n)));
    }
}

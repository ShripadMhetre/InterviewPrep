package dp;

import java.util.Arrays;

/*
    Q. Given an integer array nums, return the length of the longest strictly increasing subsequence.
        A subsequence is a sequence that can be derived from an array by deleting some or no elements without
        changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

        Example 1:
        Input: nums = [10,9,2,5,3,7,101,18]
        Output: 4
        Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

        Example 2:
        Input: nums = [0,1,0,3,2,3]
        Output: 4

        Example 3:
        Input: nums = [7,7,7,7,7,7,7]
        Output: 1
 */
public class LongestIncreasingSubsequence {
    public static int recursive(int[] arr, int currIndex, int currLen, int maxLen) {
        if (currIndex == arr.length-1) {
            maxLen = Math.max(maxLen, currLen);
            return maxLen;
        }

        int incl = 0;
        if (arr[currIndex] < arr[currIndex+1]) incl = recursive(arr, currIndex+1, currLen+1, maxLen);
        int excl = recursive(arr, currIndex+1, currLen, maxLen);

        return Math.max(incl, excl);
    }

    public static int bottomUP(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;

        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 0, 2, 2, 3};
//        int ans = recursive(arr, 0, 1, 1);
        int ans = bottomUP(arr);
        System.out.println("LIS Length: " + ans);
    }
}

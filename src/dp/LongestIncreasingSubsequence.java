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
    // T.C. -> O(N2), S.C. -> O(N)
    public static int recursive(int[] arr, int currIdx, int prevIdx) {
        if (currIdx == arr.length) return 0;

        int notTake = recursive(arr, currIdx+1, prevIdx);

        int take = 0;
        if (prevIdx == -1 || arr[currIdx] > arr[prevIdx]) {
            take += 1 + recursive(arr, currIdx+1, currIdx);
        }

        return Math.max(take, notTake);
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

//        // alternative to above loop
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i-1; j >= 0; j--) {
//                if (arr[i] > arr[j]) {
//                    dp[i] = Math.max(dp[i], 1+dp[j]);
//                    maxLen = Math.max(maxLen, dp[i]);
//                }
//            }
//        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 0, 2, 2, 3};
//        int ans = recursive(arr, 0, -1);
        int ans = bottomUP(arr);
        System.out.println("LIS Length: " + ans);
    }
}

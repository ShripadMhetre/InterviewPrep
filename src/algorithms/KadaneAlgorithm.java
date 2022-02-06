package algorithms;

import java.util.Arrays;

/**
 * Kadane's Algorithm:
 *      To find Maximum Sum Contiguous Subarray
 */
public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = {10, -4, -6, -5, 15, 1};
        System.out.println("Max possible sum: " + solve(arr));
    }

    private static int solve(int[] arr) {
        // find the maximum element present in a given array
        int max = Arrays.stream(arr).max().getAsInt();

        // if the array contains all negative values, return the maximum element i.e. the smallest negative number.
        if (max < 0) {
            return max;
        }

        int currMax = 0, maxSum = 0;
        int startIndex = 0, endIndex = 0;   // To store start and end indices of max sum subarray

        for (int i = 0; i < arr.length; i++) {
            currMax += arr[i];

            if (currMax < 0) {
                currMax = 0;
                startIndex = i+1;
            } else if (maxSum < currMax) {
                maxSum = currMax;
                endIndex = i;
            }
//            System.out.println("currSum= " + currMax + ", " + "maxSum= " + maxSum);
        }
        System.out.println("startIndex: " + startIndex + ", " + "endIndex: " + endIndex);
        return maxSum;
    }
}

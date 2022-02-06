package hashmap;

import java.util.HashMap;

/*
    Q. Given an array A, find the length of the longest subarray which has a sum equal to 0.
 */
public class LongestSubarrayWithZeroSum {
    public static int longestSubarrayWithZeroSum(int[] A) {
        // Hashmap to store prefix sum
        HashMap<Integer, Integer> hm = new HashMap<>();

        int max = 0, sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];    // prefix sum till current element

            if (sum == 0) {
                max = i + 1;    // updating max length
            } else {
                // If current sum has been found previously then the sum of between elements has to be zero
                if (hm.get(sum) != null) {
                    max = Math.max(max, i - hm.get(sum));
                } else {    // if current sum doesn't exist previously in hashmap, add it.
                    hm.put(sum, i);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, -1, -2, 3, 0, -2};

        int max = longestSubarrayWithZeroSum(arr);
        System.out.println("Longest Subarray Length: " + max);
    }
}

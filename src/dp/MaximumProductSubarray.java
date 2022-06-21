package dp;

/*
    Q. Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
        The test cases are generated so that the answer will fit in a 32-bit integer.
        A subarray is a contiguous subsequence of the array.

        Example 1:
            Input: nums = [2,3,-2,4]
            Output: 6
            Explanation: [2,3] has the largest product 6.

        Example 2:
            Input: nums = [-2,0,-1]
            Output: 0
            Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubarray {
    // Time :- O(N), Space :- O(1)
    public static int solve(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        // maintain maximum and minimum value of product till the index
        int curMax = arr[0], curMin = arr[0];
        int maxProd = arr[0];

        // if curr number negetive then max product will be number * min product till last index
        // similarly for current min product.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                curMax = Math.max(arr[i], curMin * arr[i]);
                curMin = Math.min(arr[i], curMax * arr[i]);
            } else {
                curMax = Math.max(arr[i], curMax * arr[i]);
                curMin = Math.min(arr[i], curMin * arr[i]);
            }

            maxProd = Math.max(maxProd, curMax);
        }

        return maxProd;
    }
    public static void main(String[] args) {
        int[] arr = {-2, 0, -1};
        int maxProd = solve(arr);
        System.out.println("Max Product Subarray: " + maxProd);
    }
}

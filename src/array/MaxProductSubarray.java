package array;

/*
    Q. Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product,
        and return the product. The test cases are generated so that the answer will fit in a 32-bit integer.
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
public class MaxProductSubarray {
    public static int solve(int[] arr) {
        int currMin = 1, currMax = 1;
        int maxProduct = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int tempMax = currMax;  // currMax value gets updated hence storing the value for currMin calculation
            currMax = Math.max(arr[i]*currMax, Math.max(arr[i]*currMin, arr[i]));
            currMin = Math.min(arr[i]*currMin, Math.min(arr[i]*tempMax, arr[i]));

            if (currMax > maxProduct) maxProduct = currMax;
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 0, -1};
        System.out.println("Max Product Subarray: " + solve(arr));
    }
}

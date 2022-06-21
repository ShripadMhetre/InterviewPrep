package array;

import java.util.Arrays;

/*
    Q. Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of
        nums except nums[i]. The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

        Note: You must write an algorithm that runs in O(n) time and without using the division operation.

        Example 1:
        Input: nums = [1,2,3,4]
        Output: [24,12,8,6]

        Example 2:
        Input: nums = [-1,1,0,-3,3]
        Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {
    public static int[] solve(int[] arr) {
        int[] prefixProduct = new int[arr.length];
        int[] suffixProduct = new int[arr.length];

        prefixProduct[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixProduct[i] = prefixProduct[i-1] * arr[i];
        }

        suffixProduct[arr.length-1] = arr[arr.length-1];
        for (int i = arr.length-2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i+1] * arr[i];
        }

        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                output[i] = 1 * suffixProduct[i+1];
            } else if (i == arr.length-1) {
                output[i] = prefixProduct[i-1] * 1;
            } else {
                output[i] = prefixProduct[i-1] * suffixProduct[i+1];
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] prod = solve(arr);
        for (int ele: prod) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
}

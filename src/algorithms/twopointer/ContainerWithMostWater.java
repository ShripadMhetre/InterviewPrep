package algorithms.twopointer;

/*
    Q. You are given an integer array height of length n. There are n vertical lines drawn such that
        the two endpoints of the ith line are (i, 0) and (i, height[i]).
        Find two lines that together with the x-axis form a container, such that the container contains the most water.
        Return the maximum amount of water a container can store.

        Note: You may not slant the container.

        area = (difference of x coordinates) * (Minimum height among to walls)

        Example 1:
        Input: height = [1,8,6,2,5,4,8,3,7]
        Output: 49 (i.e. area from 8 to 7)

        Example 2:
        Input: height = [1,1]
        Output: 1
 */
public class ContainerWithMostWater {
    public static int solve(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int l = 0, r = arr.length-1;
        int maxArea = 0;

        while (l < r) {
            int currArea = (r-l) * Math.min(arr[l], arr[r]);
            maxArea = Math.max(maxArea, currArea);

            if (arr[l] <= arr[r]) l++;
            else r--;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Area of most water: " + solve(arr));
    }
}

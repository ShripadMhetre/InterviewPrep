package algorithms.twopointer;

/*
    Q. You are given an array non-negative integers heights which represent an elevation map.
    Each value heights[i] represents the height of a bar, which has a width of 1.
    Return the maximum area of water that can be trapped between the bars.

    Example 1:
        Input: height = [0,2,0,3,1,0,1,3,2,1]
        Output: 9

    Note -
        Brute force approach takes O(N2) - i.e. calculating left & right max heights for every bar by looping away in both dirs
        Better approach is O(N) with O(2N) space - i.e. calculate prefix and suffix arrays for max heights
        optimal is this 2 pointer one - O(N) time and constant space
 */
public class TrappingRainWater {
    public static int solution(int[] height) {
        int N = height.length;
        int l = 0, r = N-1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                if (height[l] >= leftMax) leftMax = height[l];
                else res += leftMax - height[l];
                l++;
            } else {
                if (height[r] >= rightMax) rightMax = height[r];
                else res += rightMax - height[r];
                r--;
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 0, 3, 1, 0, 1, 3, 2, 1};
        System.out.println(solution(arr));
    }
}

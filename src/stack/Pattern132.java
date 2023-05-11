package stack;


import java.util.Stack;

/*
    Q. Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k]
        such that i < j < k and nums[i] < nums[k] < nums[j].
        Return true if there is a 132 pattern in nums, otherwise, return false.

        Example 1:
        Input: nums = [1,2,3,4]
        Output: false
        Explanation: There is no 132 pattern in the sequence.

        Example 2:
        Input: nums = [3,1,4,2]
        Output: true
        Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

        Example 3:
        Input: nums = [-1,3,2,0]
        Output: true
        Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

 */
public class Pattern132 {
    // Time: O(N)     uses "Monotonically Decreasing Stack"
    public static boolean solve(int[] arr) {
        Stack<int[]> stack = new Stack<>();
        int min = Integer.MAX_VALUE;

        for (int num: arr) {
            while (!stack.isEmpty() && stack.peek()[0] < num) stack.pop();

            if (!stack.isEmpty()) {
                int[] lastPair = stack.peek();
                if (lastPair[0] > num && lastPair[1] < num) return true;
            }

            min = Math.min(min, num);
            stack.push(new int[]{num, min});
        }

        return false;
    }

    public static void main(String[] args) {
        int [] arr = {-1, 3, 2, 0};
        System.out.println("is 132 patter present: " + solve(arr));
    }
}

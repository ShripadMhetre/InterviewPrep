package greedy;

/*
    Q. You are given an array of integers nums, where nums[i] represents the maximum length of a jump towards the right
    from index i. For example, if you are at nums[i], you can jump to any index i + j where:

    j <= nums[i]
    i + j < nums.length
    You are initially positioned at nums[0].

    Return the minimum number of jumps to reach the last position in the array (index nums.length - 1).
    You may assume there is always a valid answer.

    Example 1:
    Input: nums = [2,4,1,1,1,1]
    Output: 2
    Explanation: Jump from index 0 to index 1, then jump from index 1 to the last index.

    Example 2:
    Input: nums = [2,1,2,1,0]
    Output: 2
 */
public class JumpGameII {
    // T.C. -> O(N), S.C. -> O(1)
    public static int solution(int[] nums) {
        int N = nums.length;

        // Base case
        if (nums.length == 1) return 0;

        // destination is last index
        int dest = N-1;
        int maxCoverage = 0, jumpIdx = 0;
        int totalJumps = 0;

        // Greedy strategy: extend coverage as long as possible
        for (int i = 0; i < N; i++) {
            maxCoverage = Math.max(maxCoverage, i+nums[i]);

            if (i == jumpIdx) {
                jumpIdx = maxCoverage;
                totalJumps++;

                // check if we reached destination already
                if (maxCoverage >= dest) {
                    return totalJumps;
                }
            }
        }

        return totalJumps;
    }

    public static void main(String[] args) {
        int[] arr = {};

        System.out.println(solution(arr));
    }
}

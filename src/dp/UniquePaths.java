package dp;

/*
    Q. There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
        The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
        The robot can only move either down or right at any point in time.
        Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

        Example :-
            Input: m = 3, n = 2
            Output: 3
            Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
            1. Right -> Down -> Down
            2. Down -> Down -> Right
            3. Down -> Right -> Down
 */
public class UniquePaths {
    public static int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                // if only single row or single column in grid then only one path to follow
                if (row == 0 || col == 0) dp[row][col] = 1;
                // else unique path for current position will be sum of unique paths for previous row, same column and previous column, same row
                else dp[row][col] = dp[row-1][col] + dp[row][col-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static int uniquePathsRecursive(int m, int n) {
        if (m == 0 || n == 0) return 1;

        return uniquePathsRecursive(m-1, n) + uniquePathsRecursive(m, n-1);
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 2;
//        int res = uniquePathsRecursive(m-1, n-1);
        int res = uniquePathsDP(m, n);
        System.out.println("Unique Paths: " + res);
    }
}

package dp;

public class MinPathSum {
    // Brute Force - DFS approach
    public static int recursive(int i, int j, int[][] grid){
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }

        if(i<grid.length-1 && j<grid[0].length-1){
            int r1 = grid[i][j] + recursive(i+1, j, grid);
            int r2 = grid[i][j] + recursive(i, j+1, grid);
            return Math.min(r1,r2);
        }

        if(i<grid.length-1){
            return grid[i][j] + recursive(i+1, j, grid);
        }

        if(j<grid[0].length-1){
            return grid[i][j] + recursive(i, j+1, grid);
        }

        return 0;
    }

    // Optimal Approach: Dynamic Programming - Bottom Up
    public static int minPathSumDP(int[][] grid) {
        if(grid == null || grid.length==0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // initialize top row
        for(int i=1; i<n; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        // initialize left column
        for(int j=1; j<m; j++){
            dp[j][0] = dp[j-1][0] + grid[j][0];
        }

        // fill up the dp table
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(dp[i-1][j] > dp[i][j-1]){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }else{
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
//        int minSum = recursive(0,0, grid);
        int minSum = minPathSumDP(grid);

        System.out.println("Min Path Sum: " + minSum);
    }
}

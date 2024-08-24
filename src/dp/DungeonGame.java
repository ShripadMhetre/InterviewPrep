package dp;

/*
    Q. Find the minimum health level of the prince to start with to save the princess, where the negative numbers denote
        a dragon and positive numbers denote red bull. Redbull will increase the health whereas
        the dragons will decrease the health. The prince can move either in horizontal right direction or
        vertical down direction. If health level <= 0, it means prince is dead.
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] d) {
        int m = d.length;
        int n = d[0].length;

        // dp array to store min healths required to reach the last cell from [i, j]th cell
        int[][] dp = new int[m][n];

        // last cell min health calculation
        dp[m-1][n-1] = Math.max(1-d[m-1][n-1],1);

        // last column calculations
        for(int i = n - 2; i >= 0; i--){
            int val = d[m-1][i];
            dp[m-1][i] = Math.max(dp[m-1][i+1] - val,1);
        }

        // last row calculations
        for(int i = m - 2; i >= 0; i--){
            int val = d[i][n-1];
            dp[i][n-1] = Math.max(dp[i+1][n-1] - val,1);
        }

        // remaining matrix calculation
        for(int i = m-2; i >= 0; i--){
            for(int j = n-2; j >= 0; j--){
                int val = d[i][j];
                int min = Math.min(dp[i][j+1], dp[i+1][j]);
                dp[i][j] = Math.max(min-val, 1);
            }
        }

        // ans from top left cell
        return dp[0][0];
    }

    public static void main(String[] args) {

    }
}

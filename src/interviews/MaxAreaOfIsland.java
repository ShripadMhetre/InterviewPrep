package interviews;

public class MaxAreaOfIsland {
    public static int  maxAreaOfIsland(int[][] grid) {
        if (grid == null) return 0;

        int max = 0, m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int area = getArea(grid, i, j, m, n);
                    max = Math.max(max, area);
                }
            }
        }

        return max;
    }

    public static int getArea(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return 0;

        grid[i][j] = 0;

        int left = getArea(grid, i-1, j, m, n);
        int right = getArea(grid, i, j-1, m, n);
        int up = getArea(grid, i+1, j, m, n);
        int down = getArea(grid, i, j+1, m, n);

        return left + right + up + down + 1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1, 1, 0},
                {1, 0, 0},
                {0, 1, 0}
        };
        int area = maxAreaOfIsland(grid);
        System.out.println("Max area of Island: " + area);
    }
}

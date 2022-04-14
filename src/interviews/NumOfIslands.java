package interviews;

import java.util.HashSet;
import java.util.Set;

public class NumOfIslands {
    public static int  numIslands(char[][] grid) {
        if (grid == null) return 0;

        int islandCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    changeAdjacentLandToWater(grid, i, j);
                }
            }
        }

        return islandCount;
    }

    public static void changeAdjacentLandToWater(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;

        grid[i][j] = '0';

        changeAdjacentLandToWater(grid, i-1, j);
        changeAdjacentLandToWater(grid, i, j-1);
        changeAdjacentLandToWater(grid, i+1, j);
        changeAdjacentLandToWater(grid, i, j+1);
    }


    /*
        Q. Calculate no. of distinct islands
            i.e. islands having different shapes only

        X -> start
        O -> Out of bound
        U -> Up
        D -> Down
        R -> Right
        L -> Left
     */
    public static int numDistictIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        Set<String> set = new HashSet<>();
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    String path = computePath(grid, i, j, m, n, "X");
                    set.add(path);
                }
            }
        }

        return set.size();
    }

    public static String computePath(char[][] grid, int i, int j, int m, int n, String direction) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return "O";

        grid[i][j] = '0';

        String left = computePath(grid, i, j-1, m, n, "L");
        String right = computePath(grid, i, j+1, m, n, "R");
        String up = computePath(grid, i-1, j, m, n, "U");
        String down = computePath(grid, i+1, j, m, n, "D");

        return direction + left + right + up + down;
    }


    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1', '1', '0'},
                {'0', '0', '0'},
                {'0', '1', '1'}
        };
//        int islands = numIslands(grid);
//        System.out.println("Num of Islands: " + islands);

        int distinctIslands = numDistictIslands(grid);
        System.out.println("Num of distinct Islands: " + distinctIslands);
    }
}

package graph.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0, answer = 0;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    freshCount++;
                } else if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty() && freshCount > 0) {
            int queueLength = queue.size();
            for(int i = 0; i < queueLength; i++) {
                int[] polled = queue.poll();
                for(int[] direction: directions) {
                    int x = polled[0] + direction[0], y = polled[1] + direction[1];
                    if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) {
                        continue;
                    }
                    queue.offer(new int[]{x, y});
                    grid[x][y] = 2;
                    freshCount--;
                }
            }
            answer++;
        }
        return freshCount == 0 ? answer : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};

        int answer = orangesRotting(grid);

        System.out.println(answer);
    }
}

package interviews;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
    Q. Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
       The distance between two adjacent cells is 1.

       Example 1 :-
            Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
            Output: [[0,0,0],[0,1,0],[0,0,0]]

       Example 2 :-
            Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
            Output: [[0,0,0],[0,1,0],[1,2,1]]
 */
public class ZeroOneMatrix {
    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else {
                    ans[i][j] = -1;
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int level = 0;
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                int[] polled = queue.poll();
                for (int[] direction : directions) {
                    int x = polled[0] + direction[0];
                    int y = polled[1] + direction[1];

                    if (x < 0 || x >= n || y < 0 || y >= m) continue;

                    if (ans[x][y] == -1) {
                        ans[x][y] = level + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            level++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};

        int[][] answer = updateMatrix(grid);

        System.out.println(Arrays.deepToString(answer));
    }
}

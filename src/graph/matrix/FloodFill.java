package graph.matrix;

import java.util.Arrays;

/*
    Q. An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
    You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
    To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color
    as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on.
    Replace the color of all the aforementioned pixels with color.

    Return the modified image after performing the flood fill.

    Example 1:
    Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
    Output: [[2,2,2],[2,2,0],[2,0,1]]
    Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
    Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

    Example 2:

    Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
    Output: [[0,0,0],[0,0,0]]
    Explanation: The starting pixel is already colored 0, so no changes are made to the image.
 */
public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ROWS = image.length, COLS = image[0].length;

        if (image[sr][sc] == color) return image;

        util(image, sr, sc, color, image[sr][sc]);

        return image;
    }

    private static void util(int[][] image, int sr, int sc, int color, int initColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != initColor) return;

        image[sr][sc] = color;

        util(image, sr-1, sc, color, initColor);
        util(image, sr+1, sc, color, initColor);
        util(image, sr, sc-1, color, initColor);
        util(image, sr, sc+1, color, initColor);
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1;
        int color = 2;

        int[][] res = floodFill(image, sr, sc, color);

        System.out.println(Arrays.deepToString(res));
    }
}

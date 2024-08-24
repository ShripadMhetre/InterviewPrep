package interviews;

import java.util.Arrays;

/*
    Q. Given an m x n matrix of integers matrix, if an element is 0, set its entire row and column to 0's.
    You must update the matrix in-place.
    Follow up: Could you solve it using O(1) space?


 */
public class SetMatrixZero {
    // T.C. - O(N2), S.C. - O(1)
    public static void setZeroes(int[][] matrix) {
        // we use 1st row and col to mark zeroes initially
        int ROWS = matrix.length, COLS = matrix[0].length;

        // since matrix[0][0] would be used for column0
        // And we need a place to mark row0 as well
        boolean rowZero = false;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    if (r > 0) {
                        matrix[r][0] = 0;
                    } else {
                        rowZero = true;
                    }
                }
            }
        }

        for (int r = 1; r < ROWS; r++) {
            for (int c = 1; c < COLS; c++) {
                if (matrix[0][c] == 0 || matrix[r][0] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        // if cell0,0 is zero then mark entire col0 as zero
        if (matrix[0][0] == 0) {
            for (int r = 0; r < ROWS; r++) {
                matrix[r][0] = 0;
            }
        }

        if (rowZero) {
            for (int c = 0; c < COLS; c++) {
                matrix[0][c] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {4, 0, 5},
                {6, 7, 8},
        };

        setZeroes(mat);
        System.out.println(Arrays.deepToString(mat));
    }
}

package backtracking;

import java.util.Arrays;

public class NQueens {
    public static boolean isSafe(char[][] mat, int r, int c) {
        // return false if two queens share the same column
        for (int i = 0; i < r; i++) {
            if (mat[i][c] == 'Q') return false;
        }

        // return false if two queens share the same `\` diagonal
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)  {
            if (mat[i][j] == 'Q') return false;
        }

        // return false if two queens share the same `/` diagonal
        for (int i = r, j = c; i >= 0 && j < mat.length; i--, j++) {
            if (mat[i][j] == 'Q') return false;
        }

        return true;
    }

    public static void nQueen(char[][] mat, int r) {
        // if `N` queens are placed successfully, print the solution
        if (r == mat.length) {
            printSolution(mat);
            return;
        }

        for (int i = 0; i < mat.length; i++) {
            if (isSafe(mat, r, i)) {
                // place queen on the current square
                mat[r][i] = 'Q';

                // recur for the next row
                nQueen(mat, r+1);

                // backtrack and remove the queen from the current square
                mat[r][i] = '-';
            }
        }
    }

    public static void main(String[] args) {
        // `N × N` chessboard
        int N = 4;

        // `mat[][]` keeps track of the position of queens in
        // the current configuration
        char[][] mat = new char[N][N];

        // initialize `mat[][]` by `-`
        for (int i = 0; i < N; i++) {
            Arrays.fill(mat[i], '–');
        }

        nQueen(mat, 0);
    }

    private static void printSolution(char[][] mat)
    {
        for (char[] chars: mat) {
            System.out.println(Arrays.toString(chars).replaceAll(",", ""));
        }
        System.out.println();
    }
}

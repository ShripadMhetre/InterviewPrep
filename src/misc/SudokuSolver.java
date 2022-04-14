package misc;

public class SudokuSolver {

    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {
        SudokuGenerator sudoku = new SudokuGenerator(GRID_SIZE, 20);
        int[][] board = sudoku.generate();

//        int[][] board = {
//                {2, 3, 0, 4, 1, 5, 0, 6, 8},
//                {0, 8, 0, 2, 3, 6, 5, 1, 9},
//                {1, 6, 0, 9, 8, 7, 2, 3, 4},
//                {3, 1, 7, 0, 9, 4, 0, 2, 5},
//                {4, 5, 8, 1, 2, 0, 6, 9, 7},
//                {9, 2, 6, 0, 5, 8, 3, 0, 1},
//                {0, 0, 0, 5, 0, 0, 1, 0, 2},
//                {0, 0, 0, 8, 4, 2, 9, 0, 3},
//                {5, 9, 2, 3, 7, 1, 4, 8, 6}
//        };
        printSudoku(board);
        if(solveBoard(board)) {
            System.out.println("Solved!!!");
            printSudoku(board);
        }
        else {
            System.out.println("Sudoku could not be solved!!!");
            printSudoku(board);
        }
    }

    public static boolean numInRow(int[][] board, int num, int row) {
        for (int col = 0; col < GRID_SIZE; col++) {
            if (board[row][col] == num) return true;
        }
        return false;
    }

    public static boolean numInColumn(int[][] board, int num, int col) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (board[row][col] == num) return true;
        }
        return false;
    }

    public static boolean isNumInBox(int[][] board, int num, int row, int col) {
        // Calculating start row and column of the box based on parameters row & col of the board item provided.
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) return true;
            }
        }
        return false;
    }

    public static boolean solveBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int numToTry = 1; numToTry <= GRID_SIZE; numToTry++) {
                        if (isValid(board, row, col, numToTry)) {
                            board[row][col] = numToTry;

                            if(solveBoard(board)) return true;  // recursively check for remaining places and if everything fits then return true (i.e. board solved)
                            else {
                                board[row][col] = 0;    // if current placement not solving remaining places, then reset to zero (i.e. backtracking)
                            }
                        }
                    }
                    return false;   // no valid placement value found hence not solvable
                }
            }
        }
        return true;    // Coming out of loop means the board is solved
    }

    private static boolean isValid(int[][] board, int row, int col, int num) {
        return !numInRow(board, num, row)
                && !numInColumn(board, num, col)
                && !isNumInBox(board, num, row, col);
    }

    public static void printSudoku(int[][] board) {
        for(int row = 0; row < GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("--------------------");
            }
            for(int col = 0; col < GRID_SIZE; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print("|");
                }
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}

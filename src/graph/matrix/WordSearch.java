package graph.matrix;

/*
    Q. Given an m x n grid of characters board and a string word, return true if word exists in the grid.
    The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
    or vertically neighboring. The same letter cell may not be used more than once.

    Example 1:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    Output: true

    Example 2:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
    Output: true

    Example 3:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
    Output: false
 */
public class WordSearch {
    public boolean wordSearch(char[][] board, String word) {
        int ROWS = board.length, COLS = board[0].length;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;

        if (board[i][j] != word.charAt(k)) return false;

        // if we already reached at last character of word and also the board[i][j] is equal to last char then word found.
        if (k == word.length()-1) return true;

        // changing the character so as not to revisit it.
        char tmp = board[i][j];
        board[i][j] = '#';

        // dfs in four directions with k (index of word character) incremented.
        boolean up = dfs(board, word, i-1, j, k+1);
        boolean down = dfs(board, word, i+1, j, k+1);
        boolean left = dfs(board, word, i, j-1, k+1);
        boolean right = dfs(board, word, i, j+1, k+1);

        // backtracking - setting the original character back for further iterations.
        board[i][j] = tmp;

        // if any of dfs recursions found the word then true.
        return up || down || left || right;
    }
}

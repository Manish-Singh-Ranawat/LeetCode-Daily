// Sudoku Solver - https://leetcode.com/problems/sudoku-solver/description/?envType=daily-question&envId=2025-08-31

// Write a program to solve a Sudoku puzzle by filling the empty cells.

// A sudoku solution must satisfy all of the following rules:
// - Each of the digits 1-9 must occur exactly once in each row.
// - Each of the digits 1-9 must occur exactly once in each column.
// - Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.

// The '.' character indicates empty cells.

// Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
// Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]

import java.util.Arrays;

public class Aug31__SudokuSolver {
    public static void solveSudoku(char[][] board) {
        solve(board.length, board[0].length, board);
    }

    private static boolean solve(int m, int n, char[][] board) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(i, j, c, board)) {
                            board[i][j] = c;
                            if (solve(m, n, board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int row, int col, char c, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c)
                return false;
            if (board[i][col] == c)
                return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        solveSudoku(board);
        for (char[] row : board)
            System.out.println(Arrays.toString(row));
        // [5, 3, 4, 6, 7, 8, 9, 1, 2]
        // [6, 7, 2, 1, 9, 5, 3, 4, 8]
        // [1, 9, 8, 3, 4, 2, 5, 6, 7]
        // [8, 5, 9, 7, 6, 1, 4, 2, 3]
        // [4, 2, 6, 8, 5, 3, 7, 9, 1]
        // [7, 1, 3, 9, 2, 4, 8, 5, 6]
        // [9, 6, 1, 5, 3, 7, 2, 8, 4]
        // [2, 8, 7, 4, 1, 9, 6, 3, 5]
        // [3, 4, 5, 2, 8, 6, 1, 7, 9]
    }
}

// Valid Sudoku - https://leetcode.com/problems/valid-sudoku/?envType=daily-question&envId=2025-08-30

// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
// - Each row must contain the digits 1-9 without repetition.
// - Each column must contain the digits 1-9 without repetition.
// - Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

// Note:
// - A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// - Only the filled cells need to be validated according to the mentioned rules.

// Input: board = 
// [["5","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: true

public class Aug30__ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    if (!isValid(i, j, board[i][j], board))
                        return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int row, int col, char ch, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i] == ch)
                return false;
            if (i != row && board[i][col] == ch)
                return false;
            int r = 3 * (row / 3) + i / 3;
            int c = 3 * (col / 3) + i % 3;
            if ((r != row || c != col) && board[r][c] == ch)
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
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println(isValidSudoku(board));
        // true
    }
}

// Snakes and Ladders - https://leetcode.com/problems/snakes-and-ladders/description/?envType=daily-question&envId=2025-05-31

// You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.

// You start on square 1 of the board. In each move, starting from square curr, do the following:
// - Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)]. This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
// - If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
//- The game ends when you reach the square n2.

// A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n2 are not the starting points of any snake or ladder.

// Note that you only take a snake or ladder at most once per dice roll. If the destination to a snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.
// - For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the ladder to square 3, but do not follow the subsequent ladder to 4.

// Return the least number of dice rolls required to reach the square n2. If it is not possible to reach the square, return -1.

// Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
// Output: 4
// Explanation: 
// In the beginning, you start at square 1 (at row 5, column 0).
// You decide to move to square 2 and must take the ladder to square 15.
// You then decide to move to square 17 and must take the snake to square 13.
// You then decide to move to square 14 and must take the ladder to square 35.
// You then decide to move to square 36, ending the game.
// This is the lowest possible number of moves to reach the last square, so return 4.

import java.util.ArrayDeque;
import java.util.Queue;

public class May31__SnakesAndLadders {
    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        visited[n - 1][0] = true;
        q.offer(1);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == n * n)
                    return steps;
                for (int k = 1; k <= 6; k++) {
                    int next = cur + k;
                    if (next > n * n)
                        break;
                    int[] coordinates = getCoordinates(next, n);
                    int r = coordinates[0];
                    int c = coordinates[1];
                    if (visited[r][c])
                        continue;
                    visited[r][c] = true;
                    q.offer(board[r][c] == -1 ? next : board[r][c]);
                }
            }
            steps++;
        }
        return -1;
    }

    private static int[] getCoordinates(int val, int n) {
        int RT = (val - 1) / n;
        int RB = n - 1 - RT;
        int col = (val - 1) % n;
        if (n % 2 == RB % 2) {
            col = n - 1 - col;
        }
        return new int[] { RB, col };
    }

    public static void main(String[] args) {
        int[][] board = { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
                { -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } };
        System.out.println(snakesAndLadders(board));
        // 4
    }
}

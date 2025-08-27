// Length of Longest V-Shaped Diagonal Segment - https://leetcode.com/problems/length-of-longest-v-shaped-diagonal-segment/description/?envType=daily-question&envId=2025-08-27

// You are given a 2D integer matrix grid of size n x m, where each element is either 0, 1, or 2.

// A V-shaped diagonal segment is defined as:
// - The segment starts with 1.
// - The subsequent elements follow this infinite sequence: 2, 0, 2, 0, ....
// - The segment:
//   - Starts along a diagonal direction (top-left to bottom-right, bottom-right to top-left, top-right to bottom-left, or bottom-left to top-right).
//   - Continues the sequence in the same diagonal direction.
//   - Makes at most one clockwise 90-degree turn to another diagonal direction while maintaining the sequence.

// Return the length of the longest V-shaped diagonal segment. If no valid segment exists, return 0.

// Input: grid = [[2,2,1,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]]
// Output: 5
// Explanation: The longest V-shaped diagonal segment has a length of 5 and follows these coordinates: (0,2) → (1,3) → (2,4), takes a 90-degree clockwise turn at (2,4), and continues as (3,3) → (4,2).

import java.util.Arrays;

public class Aug27__LengthOfLongestVShapedDiagonalSegment {
    public static int lenOfVDiagonal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };
        int[][][][] dp = new int[m][n][4][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        ans = Math.max(ans, 1 + helper(i, j, d, 2, 1, grid, directions, dp));
                    }
                }
            }
        }
        return ans;
    }

    private static int helper(int i, int j, int d, int val, int turn, int[][] grid, int[][] directions,
            int[][][][] dp) {
        int ni = i + directions[d][0];
        int nj = j + directions[d][1];
        if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length || grid[ni][nj] != val) {
            return 0;
        }
        if (dp[ni][nj][d][turn] != -1)
            return dp[ni][nj][d][turn];
        int same = 1 + helper(ni, nj, d, val == 2 ? 0 : 2, turn, grid, directions, dp);
        int change = 0;
        if (turn == 1) {
            change = 1 + helper(ni, nj, (d + 1) % 4, val == 2 ? 0 : 2, 0, grid, directions, dp);
        }
        return dp[ni][nj][d][turn] = Math.max(same, change);
    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 2, 1, 2, 2 }, { 2, 0, 2, 2, 0 }, { 2, 0, 1, 1, 0 }, { 1, 0, 2, 2, 2 },
                { 2, 0, 0, 2, 2 } };
        System.out.println(lenOfVDiagonal(grid));
        // 5
    }
}

// Maximum Number of Fish in a Grid - https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/description/?envType=daily-question&envId=2025-01-28

// You are given a 0-indexed 2D matrix grid of size m x n, where (r, c) represents:
// A land cell if grid[r][c] = 0, or
// A water cell containing grid[r][c] fish, if grid[r][c] > 0.

// A fisher can start at any water cell (r, c) and can do the following operations any number of times:
// Catch all the fish at cell (r, c), or
// Move to any adjacent water cell.

// Return the maximum number of fish the fisher can catch if he chooses his starting cell optimally, or 0 if no water cell exists.
// An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) or (r - 1, c) if it exists.

// Input: grid = [[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]
// Output: 7
// Explanation: The fisher can start at cell (1,3) and collect 3 fish, then move to cell (2,3) and collect 4 fish.

public class Jan28__MaximumNumberOfFishInGrid {
    public static int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    int[] max = { 0 };
                    dfs(i, j, grid, visited, directions, max);
                    ans = Math.max(ans, max[0]);
                }
            }
        }
        return ans;
    }

    public static void dfs(int row, int col, int[][] grid, boolean[][] visited, int[][] directions, int[] max) {
        int m = grid.length;
        int n = grid[0].length;
        visited[row][col] = true;
        max[0] += grid[row][col];
        for (int i = 0; i < 4; i++) {
            int nr = row + directions[i][0];
            int nc = col + directions[i][1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] != 0 && !visited[nr][nc]) {
                dfs(nr, nc, grid, visited, directions, max);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 2, 1, 0 }, { 4, 0, 0, 3 }, { 1, 0, 0, 4 }, { 0, 3, 2, 0 } };
        System.out.println(findMaxFish(grid));
        // 7
    }
}

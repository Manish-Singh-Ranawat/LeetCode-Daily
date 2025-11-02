// Count Unguarded Cells in the Grid - https://leetcode.com/problems/count-unguarded-cells-in-the-grid/description/?envType=daily-question&envId=2025-11-02

// You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions of the ith guard and jth wall respectively.

// A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.

// Return the number of unoccupied cells that are not guarded.

// Input: m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
// Output: 7

public class Nov2__CountUnguardedCellsInTheGrid {

    private static final int UNGUARDED = 0;
    private static final int GUARDED = 1;
    private static final int GUARD = 2;
    private static final int WALL = 3;

    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] g : guards)
            grid[g[0]][g[1]] = GUARD;
        for (int[] w : walls)
            grid[w[0]][w[1]] = WALL;
        for (int[] g : guards)
            mark(g[0], g[1], m, n, grid);
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == UNGUARDED)
                    ans++;
            }
        }
        return ans;
    }

    private static void mark(int row, int col, int m, int n, int[][] grid) {
        for (int j = col + 1; j < n; j++) {
            if (grid[row][j] == WALL || grid[row][j] == GUARD)
                break;
            grid[row][j] = GUARDED;
        }
        for (int j = col - 1; j >= 0; j--) {
            if (grid[row][j] == WALL || grid[row][j] == GUARD)
                break;
            grid[row][j] = GUARDED;
        }
        for (int i = row + 1; i < m; i++) {
            if (grid[i][col] == WALL || grid[i][col] == GUARD)
                break;
            grid[i][col] = GUARDED;
        }
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][col] == WALL || grid[i][col] == GUARD)
                break;
            grid[i][col] = GUARDED;
        }
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 6;
        int[][] guards = { { 0, 0 }, { 1, 1 }, { 2, 3 } };
        int[][] walls = { { 0, 1 }, { 2, 2 }, { 1, 4 } };
        System.out.println(countUnguarded(m, n, guards, walls));
        // 7
    }
}

// Minimum Cost to Make at Least One Valid Path in a Grid - https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description/?envType=daily-question&envId=2025-01-18

// Given an m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are currently in this cell. The sign of grid[i][j] can be:

// 1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
// 2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
// 3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
// 4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
// Notice that there could be some signs on the cells of the grid that point outside the grid.

// You will initially start at the upper left cell (0, 0). A valid path in the grid is a path that starts from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid path does not have to be the shortest.

// You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.

// Return the minimum cost to make the grid have at least one valid path.

// Input: grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
// Output: 3
// Explanation: You will start at point (0, 0).
// The path to (3, 3) is as follows. (0, 0) --> (0, 1) --> (0, 2) --> (0, 3) change the arrow to down with cost = 1 --> (1, 3) --> (1, 2) --> (1, 1) --> (1, 0) change the arrow to down with cost = 1 --> (2, 0) --> (2, 1) --> (2, 2) --> (2, 3) change the arrow to down with cost = 1 --> (3, 3)
// The total cost = 3.

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Jan18__MinimumCostToMakeAtLeastOneValidPathInGrid {
    public static int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] minCost = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }
        Deque<Pair> dq = new ArrayDeque<>();
        dq.offer(new Pair(0, 0));
        minCost[0][0] = 0;
        int[][] direction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!dq.isEmpty()) {
            Pair cur = dq.pollFirst();
            int row = cur.row;
            int col = cur.col;
            int cost = minCost[row][col];
            if (row == m - 1 && col == n - 1)
                return cost;
            for (int i = 0; i < 4; i++) {
                int nRow = row + direction[i][0];
                int nCol = col + direction[i][1];
                int nCost = grid[row][col] == (i + 1) ? cost : cost + 1;
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && nCost < minCost[nRow][nCol]) {
                    minCost[nRow][nCol] = nCost;
                    if (grid[row][col] == (i + 1)) {
                        dq.offerFirst(new Pair(nRow, nCol));
                    } else {
                        dq.offerLast(new Pair(nRow, nCol));
                    }
                }
            }
        }
        return minCost[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 1, 1, 1, 1 }, { 2, 2, 2, 2 } };
        System.out.println(minCost(grid));
        // 3
    }
}

// Find the Minimum Area to Cover All Ones II - https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-ii/description/?envType=daily-question&envId=2025-08-23

// You are given a 2D binary array grid. You need to find 3 non-overlapping rectangles having non-zero areas with horizontal and vertical sides such that all the 1's in grid lie inside these rectangles.

// Return the minimum possible sum of the area of these rectangles.

// Note that the rectangles are allowed to touch.

// Input: grid = [[1,0,1],[1,1,1]]
// Output: 5
// Explanation:
// The 1's at (0, 0) and (1, 0) are covered by a rectangle of area 2.
// The 1's at (0, 2) and (1, 2) are covered by a rectangle of area 2.
// The 1 at (1, 1) is covered by a rectangle of area 1.

public class Aug23__FindTheMinimumAreaToCoverAllOnesII {

    public static int minimumSum(int[][] grid) {
        int[][] rgrid = rotate(grid);
        return Math.min(solve(grid), solve(rgrid));
    }

    private static int[][] rotate(int[][] vec) {
        int n = vec.length;
        int m = vec[0].length;
        int[][] ret = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ret[m - j - 1][i] = vec[i][j];
            }
        }
        return ret;
    }

    private static int solve(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = n * m;
        for (int i = 0; i + 1 < n; i++) {
            for (int j = 0; j + 1 < m; j++) {
                res = Math.min(
                        res,
                        minimumSum2(grid, 0, i, 0, m - 1) +
                                minimumSum2(grid, i + 1, n - 1, 0, j) +
                                minimumSum2(grid, i + 1, n - 1, j + 1, m - 1));
                res = Math.min(
                        res,
                        minimumSum2(grid, 0, i, 0, j) +
                                minimumSum2(grid, 0, i, j + 1, m - 1) +
                                minimumSum2(grid, i + 1, n - 1, 0, m - 1));
            }
        }
        for (int i = 0; i + 2 < n; i++) {
            for (int j = i + 1; j + 1 < n; j++) {
                res = Math.min(
                        res,
                        minimumSum2(grid, 0, i, 0, m - 1) +
                                minimumSum2(grid, i + 1, j, 0, m - 1) +
                                minimumSum2(grid, j + 1, n - 1, 0, m - 1));
            }
        }
        return res;
    }

    private static int minimumSum2(int[][] grid, int u, int d, int l, int r) {
        int min_i = grid.length;
        int max_i = 0;
        int min_j = grid[0].length;
        int max_j = 0;
        for (int i = u; i <= d; i++) {
            for (int j = l; j <= r; j++) {
                if (grid[i][j] == 1) {
                    min_i = Math.min(min_i, i);
                    min_j = Math.min(min_j, j);
                    max_i = Math.max(max_i, i);
                    max_j = Math.max(max_j, j);
                }
            }
        }
        return min_i <= max_i
                ? (max_i - min_i + 1) * (max_j - min_j + 1)
                : Integer.MAX_VALUE / 3;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 0, 1 }, { 1, 1, 1 } };
        System.out.println(minimumSum(grid));
    }
}

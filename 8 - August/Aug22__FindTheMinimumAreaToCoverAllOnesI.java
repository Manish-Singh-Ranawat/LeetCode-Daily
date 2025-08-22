// Find the Minimum Area to Cover All Ones I - https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i/description/?envType=daily-question&envId=2025-08-22

// You are given a 2D binary array grid. Find a rectangle with horizontal and vertical sides with the smallest area, such that all the 1's in grid lie inside this rectangle.

// Return the minimum possible area of the rectangle.

// Input: grid = [[0,1,0],[1,0,1]]
// Output: 6
// Explanation: The smallest rectangle has a height of 2 and a width of 3, so it has an area of 2 * 3 = 6.

public class Aug22__FindTheMinimumAreaToCoverAllOnesI {
    public static int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int top = m;
        int bottom = 0;
        int left = n;
        int right = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }
        return (right - left + 1) * (bottom - top + 1);
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 0 }, { 1, 0, 1 } };
        System.out.println(minimumArea(grid));
        // 6
    }
}

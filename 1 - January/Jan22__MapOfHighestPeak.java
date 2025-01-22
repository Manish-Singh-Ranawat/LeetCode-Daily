// Map of Highest Peak - https://leetcode.com/problems/map-of-highest-peak/description/?envType=daily-question&envId=2025-01-22

// You are given an integer matrix isWater of size m x n that represents a map of land and water cells.

// If isWater[i][j] == 0, cell (i, j) is a land cell.
// If isWater[i][j] == 1, cell (i, j) is a water cell.
// You must assign each cell a height in a way that follows these rules:

// The height of each cell must be non-negative.
// If the cell is a water cell, its height must be 0.
// Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
// Find an assignment of heights such that the maximum height in the matrix is maximized.

// Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.

// Input: isWater = [[0,1],[0,0]]
// Output: [[1,0],[2,1]]
// Explanation: The image shows the assigned heights of each cell.
// The blue cell is the water cell, and the green cells are the land cells.

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Jan22__MapOfHighestPeak {
    public static int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    q.offer(new int[] { i, j });
                    visited[i][j] = true;
                    height[i][j] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + directions[i][0];
                int nc = c + directions[i][1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && isWater[nr][nc] != 1) {
                    visited[nr][nc] = true;
                    q.offer(new int[] { nr, nc });
                    height[nr][nc] = height[r][c] + 1;
                }
            }
        }
        return height;
    }

    public static void main(String[] args) {
        int[][] isWater = { { 0, 1 }, { 0, 0 } };
        int[][] res = highestPeak(isWater);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
        // [1, 0]
        // [2, 1]
    }
}

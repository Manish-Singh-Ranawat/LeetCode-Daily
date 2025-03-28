// Maximum Number of Points From Grid Queries - https://leetcode.com/problems/maximum-number-of-points-from-grid-queries/description/?envType=daily-question&envId=2025-03-28

// You are given an m x n integer matrix grid and an array queries of size k.

// Find an array answer of size k such that for each integer queries[i] you start in the top left cell of the matrix and repeat the following process:
// -  If queries[i] is strictly greater than the value of the current cell that you are in, then you get one point if it is your first time visiting this cell, and you can move to any adjacent cell in all 4 directions: up, down, left, and right.
// - Otherwise, you do not get any points, and you end this process.

// After the process, answer[i] is the maximum number of points you can get. Note that for each query you are allowed to visit the same cell multiple times.

// Return the resulting array answer.

// Input: grid = [[1,2,3],[2,5,7],[3,5,1]], queries = [5,6,2]
// Output: [5,8,1]
// Explanation: The diagrams above show which cells we visit to get points for each query.

import java.util.Arrays;
import java.util.PriorityQueue;

public class March28__MaximumNumberOfPointsFromGridQueries {
    public static int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        int k = queries.length;
        int[][] sortedQueries = new int[k][2];
        for (int i = 0; i < k; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);
        int[] ans = new int[k];
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[m][n];
        pq.offer(new int[] { grid[0][0], 0, 0 });
        visited[0][0] = true;
        int count = 0;
        for (int[] q : sortedQueries) {
            int qVal = q[0];
            int qIdx = q[1];
            while (!pq.isEmpty() && pq.peek()[0] < qVal) {
                int[] top = pq.poll();
                int r = top[1];
                int c = top[2];
                count++;
                for (int i = 0; i < 4; i++) {
                    int nr = r + directions[i][0];
                    int nc = c + directions[i][1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                        pq.offer(new int[] { grid[nr][nc], nr, nc });
                        visited[nr][nc] = true;
                    }
                }
            }
            ans[qIdx] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 2, 3 }, { 2, 5, 7 }, { 3, 5, 1 } };
        int[] queries = { 5, 6, 2 };
        System.out.println(Arrays.toString(maxPoints(grid, queries)));
        // [5, 8, 1]
    }
}

// Making A Large Island - https://leetcode.com/problems/making-a-large-island/description/?envType=daily-question&envId=2025-01-31

// You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

// Return the size of the largest island in grid after applying this operation.

// An island is a 4-directionally connected group of 1s.

// Input: grid = [[1,0],[0,1]]
// Output: 3
// Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.

import java.util.HashMap;
import java.util.HashSet;

public class Jan31__MakingLargeIsland {
    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        HashMap<Integer, Integer> map = new HashMap<>();
        int id = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(i, j, id, grid, directions);
                    map.put(id, size);
                    id++;
                }
            }
        }
        if (map.isEmpty())
            return 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> set = new HashSet<>();
                    int sum = 1;
                    for (int[] it : directions) {
                        int nr = i + it[0];
                        int nc = j + it[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] > 1) {
                            int curId = grid[nr][nc];
                            if (!set.contains(curId)) {
                                sum += map.get(curId);
                                set.add(curId);
                            }
                        }
                    }
                    ans = Math.max(ans, sum);
                }
            }
        }
        return ans == 0 ? n * n : ans;
    }

    public static int dfs(int r, int c, int id, int[][] grid, int[][] directions) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid.length || grid[r][c] != 1) {
            return 0;
        }
        int size = 1;
        grid[r][c] = id;
        for (int[] it : directions) {
            int nr = r + it[0];
            int nc = c + it[1];
            size += dfs(nr, nc, id, grid, directions);
        }
        return size;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 0 }, { 0, 1 } };
        System.out.println(largestIsland(grid));
        // 3
    }
}

// Swim in Rising Water - https://leetcode.com/problems/swim-in-rising-water/description/?envType=daily-question&envId=2025-10-06

// You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).

// It starts raining, and water gradually rises over time. At time t, the water level is t, meaning any cell with elevation less than equal to t is submerged or reachable.

// You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.

// Return the minimum time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).

// Input: grid = [[0,2],[1,3]]
// Output: 3
// Explanation:
// At time 0, you are in grid location (0, 0).
// You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
// You cannot reach point (1, 1) until time 3.
// When the depth of water is 3, we can swim anywhere inside the grid.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Oct6__SwimInRisingWater {
    public static int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0)
                    edges.add(new int[] { Math.max(grid[i][j], grid[i - 1][j]), i * n + j, (i - 1) * n + j });
                if (j > 0)
                    edges.add(new int[] { Math.max(grid[i][j], grid[i][j - 1]), i * n + j, i * n + j - 1 });
            }
        }
        Collections.sort(edges, (a, b) -> a[0] - b[0]);
        int[] parent = new int[m * n];
        for (int i = 0; i < m * n; i++)
            parent[i] = i;
        for (int[] edge : edges) {
            union(parent, edge[1], edge[2]);
            if (find(parent, 0) == find(parent, m * n - 1))
                return edge[0];
        }
        return grid[0][0];
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private static void union(int[] parent, int x, int y) {
        parent[find(parent, x)] = find(parent, y);
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 2 }, { 1, 3 } };
        System.out.println(swimInWater(grid));
        // 3
    }
}

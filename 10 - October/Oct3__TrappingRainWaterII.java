// Trapping Rain Water II - https://leetcode.com/problems/trapping-rain-water-ii/description/?envType=daily-question&envId=2025-10-03

// Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.

// Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
// Output: 4
// Explanation: After the rain, water is trapped between the blocks.
// We have two small ponds 1 and 3 units trapped.
// The total volume of water trapped is 4.

import java.util.PriorityQueue;

public class Oct3__TrappingRainWaterII {
    public static int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.height, b.height));
        boolean[][] visited = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            pq.offer(new Pair(0, j, heightMap[0][j]));
            pq.offer(new Pair(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        for (int i = 0; i < m; i++) {
            pq.offer(new Pair(i, 0, heightMap[i][0]));
            pq.offer(new Pair(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        int maxHeight = Integer.MIN_VALUE;
        int res = 0;
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int row = cur.row;
            int col = cur.col;
            int height = cur.height;
            maxHeight = Math.max(maxHeight, height);
            res += (maxHeight - height);
            for (int i = 0; i < 4; i++) {
                int nRow = row + directions[i][0];
                int nCol = col + directions[i][1];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && !visited[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                    pq.offer(new Pair(nRow, nCol, heightMap[nRow][nCol]));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] heightMap = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
        System.out.println(trapRainWater(heightMap));
        // 4
    }
}

class Pair {
    int row;
    int col;
    int height;

    Pair(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
}

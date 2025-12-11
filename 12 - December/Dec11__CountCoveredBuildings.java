// Count Covered Buildings - https://leetcode.com/problems/count-covered-buildings/description/?envType=daily-question&envId=2025-12-11

// You are given a positive integer n, representing an n x n city. You are also given a 2D grid buildings, where buildings[i] = [x, y] denotes a unique building located at coordinates [x, y].

// A building is covered if there is at least one building in all four directions: left, right, above, and below.

// Return the number of covered buildings.

// Input: n = 3, buildings = [[1,2],[2,2],[3,2],[2,1],[2,3]]
// Output: 1
// Explanation: Only building [2,2] is covered as it has at least one building:
// above ([1,2])
// below ([3,2])
// left ([2,1])
// right ([2,3])
// Thus, the count of covered buildings is 1.

import java.util.Arrays;

public class Dec11__CountCoveredBuildings {
    public static int countCoveredBuildings(int n, int[][] buildings) {
        int[] maxRow = new int[n + 1];
        int[] minRow = new int[n + 1];
        int[] maxCol = new int[n + 1];
        int[] minCol = new int[n + 1];
        Arrays.fill(minRow, n + 1);
        Arrays.fill(minCol, n + 1);
        for (int[] p : buildings) {
            int x = p[0];
            int y = p[1];
            maxRow[y] = Math.max(maxRow[y], x);
            minRow[y] = Math.min(minRow[y], x);
            maxCol[x] = Math.max(maxCol[x], y);
            minCol[x] = Math.min(minCol[x], y);
        }
        int res = 0;
        for (int[] p : buildings) {
            int x = p[0];
            int y = p[1];
            if (x > minRow[y] && x < maxRow[y] && y > minCol[x] && y < maxCol[x]) 
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] buildings = { { 1, 2 }, { 2, 2 }, { 3, 2 }, { 2, 1 }, { 2, 3 } };
        System.out.println(countCoveredBuildings(n, buildings));
        // 1
    }
}

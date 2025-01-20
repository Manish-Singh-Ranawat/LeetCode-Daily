// First Completely Painted Row or Column - https://leetcode.com/problems/first-completely-painted-row-or-column/description/?envType=daily-question&envId=2025-01-20

// You are given a 0-indexed integer array arr, and an m x n integer matrix mat. arr and mat both contain all the integers in the range [1, m * n].

// Go through each index i in arr starting from index 0 and paint the cell in mat containing the integer arr[i].

// Return the smallest index i at which either a row or a column will be completely painted in mat.

// Input: arr = [1,3,4,2], mat = [[1,4],[2,3]]
// Output: 2
// Explanation: The moves are shown in order, and both the first row and second column of the matrix become fully painted at arr[2].

import java.util.HashMap;

public class Jan20__FirstCompletelyPaintedRowOrColumn {
    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[] { i, j });
            }
        }
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for (int i = 0; i < m * n; i++) {
            int[] pos = map.get(arr[i]);
            int r = pos[0];
            int c = pos[1];
            rowCount[r]++;
            if (rowCount[r] == n)
                return i;
            colCount[c]++;
            if (colCount[c] == m)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 2 };
        int[][] mat = { { 1, 4 }, { 2, 3 } };
        System.out.println(firstCompleteIndex(arr, mat));
        // 2
    }

}

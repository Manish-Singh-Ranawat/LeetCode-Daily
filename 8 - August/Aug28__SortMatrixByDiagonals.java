// Sort Matrix by Diagonals - https://leetcode.com/problems/sort-matrix-by-diagonals/?envType=daily-question&envId=2025-08-28

// You are given an n x n square matrix of integers grid. Return the matrix such that:
// - The diagonals in the bottom-left triangle (including the middle diagonal) are sorted in non-increasing order.
// - The diagonals in the top-right triangle are sorted in non-decreasing order.

// Input: grid = [[1,7,3],[9,8,2],[4,5,6]]
// Output: [[8,2,3],[9,6,7],[4,5,1]]
// Explanation:
// The diagonals in bottom-left triangle should be sorted in non-increasing order:
// [1, 8, 6] becomes [8, 6, 1].
// [9, 5] and [4] remain unchanged.
// The diagonals in top-right triangle should be sorted in non-decreasing order:
// [7, 2] becomes [2, 7].
// [3] remains unchanged.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Aug28__SortMatrixByDiagonals {
    public static int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; i + j < n; j++)
                list.add(grid[i + j][j]);
            Collections.sort(list, (a, b) -> b - a);
            for (int j = 0; i + j < n; j++)
                grid[i + j][j] = list.get(j);
        }
        for (int j = 1; j < n; j++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i + j < n; i++)
                list.add(grid[i][i + j]);
            Collections.sort(list);
            for (int i = 0; i + j < n; i++)
                grid[i][i + j] = list.get(i);
        }
        return grid;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 7, 3 }, { 9, 8, 2 }, { 4, 5, 6 } };
        int[][] ans = sortMatrix(grid);
        for (int[] it : ans)
            System.out.println(Arrays.toString(it));
        // [[8,2,3],[9,6,7],[4,5,1]]
    }
}

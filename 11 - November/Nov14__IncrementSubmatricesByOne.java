// Increment Submatrices by One - https://leetcode.com/problems/increment-submatrices-by-one/description/?envType=daily-question&envId=2025-11-14

// You are given a positive integer n, indicating that we initially have an n x n 0-indexed integer matrix mat filled with zeroes.

// You are also given a 2D integer array query. For each query[i] = [row1i, col1i, row2i, col2i], you should do the following operation:
// - Add 1 to every element in the submatrix with the top left corner (row1i, col1i) and the bottom right corner (row2i, col2i). That is, add 1 to mat[x][y] for all row1i <= x <= row2i and col1i <= y <= col2i.

// Return the matrix mat after performing every query.

// Input: n = 3, queries = [[1,1,2,2],[0,0,1,1]]
// Output: [[1,1,0],[1,2,1],[0,1,1]]
// Explanation: The diagram above shows the initial matrix, the matrix after the first query, and the matrix after the second query.
// - In the first query, we add 1 to every element in the submatrix with the top left corner (1, 1) and bottom right corner (2, 2).
// - In the second query, we add 1 to every element in the submatrix with the top left corner (0, 0) and bottom right corner (1, 1).

import java.util.Arrays;

public class Nov14__IncrementSubmatricesByOne {
    public static int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n][n];
        for (int[] q : queries) {
            int r1 = q[0];
            int c1 = q[1];
            int r2 = q[2];
            int c2 = q[3];
            for (int i = r1; i <= r2; i++) {
                diff[i][c1] += 1;
                if (c2 + 1 < n)
                    diff[i][c2 + 1] -= 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] queries = { { 1, 1, 2, 2 }, { 0, 0, 1, 1 } };
        int[][] res = rangeAddQueries(n, queries);
        for (int i = 0; i < n; i++) 
            System.out.println(Arrays.toString(res[i]));
        // [1, 1, 0]
        // [1, 2, 1]
        // [0, 1, 1]
    }
}

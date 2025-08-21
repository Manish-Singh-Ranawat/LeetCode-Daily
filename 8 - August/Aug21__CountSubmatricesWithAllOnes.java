// Count Submatrices With All Ones - https://leetcode.com/problems/count-submatrices-with-all-ones/description/?envType=daily-question&envId=2025-08-21

// Given an m x n binary matrix mat, return the number of submatrices that have all ones.

// Input: mat = [[1,0,1],[1,1,0],[1,1,0]]
// Output: 13
// Explanation: 
// There are 6 rectangles of side 1x1.
// There are 2 rectangles of side 1x2.
// There are 3 rectangles of side 2x1.
// There is 1 rectangle of side 2x2. 
// There is 1 rectangle of side 3x1.
// Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.

import java.util.Stack;

public class Aug21__CountSubmatricesWithAllOnes {
    public static int numSubmat(int[][] mat) {
        int n = mat[0].length;
        int[] heights = new int[n];
        int res = 0;
        for (int[] row : mat) {
            for (int i = 0; i < n; i++) {
                heights[i] = row[i] == 0 ? 0 : heights[i] + 1;
            }
            Stack<int[]> stack = new Stack<>();
            stack.push(new int[] { -1, 0, -1 });
            for (int i = 0; i < n; i++) {
                int h = heights[i];
                while (stack.peek()[2] >= h) {
                    stack.pop();
                }
                int[] top = stack.peek();
                int j = top[0];
                int prev = top[1];
                int cur = prev + (i - j) * h;
                stack.push(new int[] { i, cur, h });
                res += cur;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 0, 1 },
                { 1, 1, 0 },
                { 1, 1, 0 }
        };
        System.out.println(numSubmat(mat));
        // 13
    }
}

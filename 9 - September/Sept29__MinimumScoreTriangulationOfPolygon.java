// Minimum Score Triangulation of Polygon - https://leetcode.com/problems/minimum-score-triangulation-of-polygon/description/?envType=daily-question&envId=2025-09-29

// You have a convex n-sided polygon where each vertex has an integer value. You are given an integer array values where values[i] is the value of the ith vertex in clockwise order.

// Polygon triangulation is a process where you divide a polygon into a set of triangles and the vertices of each triangle must also be vertices of the original polygon. Note that no other shapes other than triangles are allowed in the division. This process will result in n - 2 triangles.

// You will triangulate the polygon. For each triangle, the weight of that triangle is the product of the values at its vertices. The total score of the triangulation is the sum of these weights over all n - 2 triangles.

// Return the minimum possible score that you can achieve with some triangulation of the polygon.

// Input: values = [3,7,4,5]
// Output: 144
// Explanation: There are two triangulations, with possible scores: 3*7*5 + 4*5*7 = 245, or 3*4*5 + 3*4*7 = 144. The minimum score is 144.

import java.util.Arrays;

public class Sept29__MinimumScoreTriangulationOfPolygon {
    // -- Tabulation --
    public static int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 2; j < n; ++j) {
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j] == 0 ? Integer.MAX_VALUE : dp[i][j],
                            dp[i][k] + values[i] * values[k] * values[j] + dp[k][j]);
                }
            }
        }
        return dp[0][n - 1];
    }

    // -- Memoization --
    // public static int minScoreTriangulation(int[] values) {
    //     int n = values.length;
    //     int[][] dp = new int[n][n];
    //     for (int i = 0; i < n; i++)
    //         Arrays.fill(dp[i], -1);
    //     return helper(0, n - 1, values, dp);
    // }

    // private static int helper(int i, int j, int[] values, int[][] dp) {
    //     if (j - i + 1 < 3)
    //         return 0;
    //     if (dp[i][j] != -1)
    //         return dp[i][j];
    //     int ans = Integer.MAX_VALUE;
    //     for (int k = i + 1; k < j; k++) {
    //         int wt = values[i] * values[j] * values[k] + helper(i, k, values, dp) + helper(k, j, values, dp);
    //         ans = Math.min(ans, wt);
    //     }
    //     return dp[i][j] = ans;
    // }

    public static void main(String[] args) {
        int[] values = { 3, 7, 4, 5 };
        System.out.println(minScoreTriangulation(values));
        // 144
    }
}

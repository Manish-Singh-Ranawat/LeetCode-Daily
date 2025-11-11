// Ones and Zeroes - https://leetcode.com/problems/ones-and-zeroes/description/?envType=daily-question&envId=2025-11-11

// You are given an array of binary strings strs and two integers m and n.

// Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.

// A set x is a subset of a set y if all elements of x are also elements of y.

// Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
// Output: 4
// Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
// Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
// {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.

import java.util.HashMap;
import java.util.Map;

public class Nov11__OnesAndZeroes {
    // -- Tabulation --
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        Map<Integer, int[]> map = new HashMap<>();
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            int zeroes = 0;
            int ones = 0;
            for (char ch : strs[i].toCharArray()) {
                if (ch == '0')
                    zeroes++;
                if (ch == '1')
                    ones++;
            }
            map.put(i, new int[] { zeroes, ones });
        }
        for (int i = 0; i < len; i++) {
            int zeros = map.get(i)[0];
            int ones = map.get(i)[1];
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    // -- Memoization --
    // public static int findMaxForm(String[] strs, int m, int n) {
    //     Map<Integer, int[]> map = new HashMap<>();
    //     int len = strs.length;
    //     for (int i = 0; i < len; i++) {
    //         int zeroes = 0;
    //         int ones = 0;
    //         for (char ch : strs[i].toCharArray()) {
    //             if (ch == '0')
    //                 zeroes++;
    //             if (ch == '1')
    //                 ones++;
    //         }
    //         map.put(i, new int[] { zeroes, ones });
    //     }
    //     int[][][] dp = new int[len][m + 1][n + 1];
    //     for (int i = 0; i < len; i++) {
    //         for (int j = 0; j <= m; j++) {
    //             for (int k = 0; k <= n; k++)
    //                 dp[i][j][k] = -1;
    //         }
    //     }
    //     return helper(0, strs, m, n, map, dp);
    // }

    // private static int helper(int i, String[] strs, int m, int n, Map<Integer, int[]> map, int[][][] dp) {
    //     if (i >= strs.length)
    //         return 0;
    //     if (dp[i][m][n] != -1)
    //         return dp[i][m][n];
    //     int zeroes = map.get(i)[0];
    //     int ones = map.get(i)[1];
    //     int pick = (zeroes <= m && ones <= n) ? 1 + helper(i + 1, strs, m - zeroes, n
    //             - ones, map, dp) : 0;
    //     int notPick = helper(i + 1, strs, m, n, map, dp);
    //     return dp[i][m][n] = Math.max(pick, notPick);
    // }

    public static void main(String[] args) {
        String[] strs = { "10", "0001", "111001", "1", "0" };
        int m = 5;
        int n = 3;
        System.out.println(findMaxForm(strs, m, n));
        // 4
    }
}

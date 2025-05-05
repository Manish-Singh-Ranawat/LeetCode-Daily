// Domino and Tromino Tiling - https://leetcode.com/problems/domino-and-tromino-tiling/description/?envType=daily-question&envId=2025-05-05

// You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.

// Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.

// In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.

// Input: n = 3
// Output: 5

public class May5__DominoAndTrominoTiling {
    public static int numTilings(int n) {
        if (n == 1 || n == 2)
            return n;
        if (n == 3)
            return 5;
        int MOD = (int) 1e9 + 7;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] % MOD + dp[i - 3] % MOD) % MOD;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(numTilings(n));
        // 5
    }
}

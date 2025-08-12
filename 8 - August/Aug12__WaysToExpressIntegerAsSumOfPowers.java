// Ways to Express an Integer as Sum of Powers - https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers/description/?envType=daily-question&envId=2025-08-12

// Given two positive integers n and x.

// Return the number of ways n can be expressed as the sum of the xth power of unique positive integers, in other words, the number of sets of unique integers [n1, n2, ..., nk] where n = n1x + n2x + ... + nkx.

// Since the result can be very large, return it modulo 109 + 7.

// For example, if n = 160 and x = 3, one way to express n is n = 23 + 33 + 53.

// Input: n = 4, x = 1
// Output: 2
// Explanation: We can express n in the following ways:
// - n = 41 = 4.
// - n = 31 + 11 = 4.

public class Aug12__WaysToExpressIntegerAsSumOfPowers {

    final static int MOD = 1_000_000_007;

    public static int numberOfWays(int n, int x) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int val = (int) Math.pow(i, x);
            if (val > n) {
                break;
            }
            for (int j = n; j >= val; j--) {
                dp[j] = (dp[j] + dp[j - val]) % MOD;
            }
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        int x = 1;
        System.out.println(numberOfWays(n, x));
        // 2
    }
}

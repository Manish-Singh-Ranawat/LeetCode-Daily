// Find Sum of Array Product of Magical Sequences - https://leetcode.com/problems/find-sum-of-array-product-of-magical-sequences/description/?envType=daily-question&envId=2025-10-12

// You are given two integers, m and k, and an integer array nums.

// A sequence of integers seq is called magical if:
// - seq has a size of m.
// - 0 <= seq[i] < nums.length
// - The binary representation of 2seq[0] + 2seq[1] + ... + 2seq[m - 1] has k set bits.

// The array product of this sequence is defined as prod(seq) = (nums[seq[0]] * nums[seq[1]] * ... * nums[seq[m - 1]]).

// Return the sum of the array products for all valid magical sequences.

// Since the answer may be large, return it modulo 109 + 7.

// A set bit refers to a bit in the binary representation of a number that has a value of 1.

// Input: m = 5, k = 5, nums = [1,10,100,10000,1000000]
// Output: 991600007
// Explanation: All permutations of [0, 1, 2, 3, 4] are magical sequences, each with an array product of 1013.

public class Oct12__FindSumOfArrayProductOfMagicalSequences {
    public static int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;
        long mod = 1000000007;
        long[] fac = new long[m + 1];
        fac[0] = 1;
        for (int i = 1; i <= m; i++) {
            fac[i] = (fac[i - 1] * i) % mod;
        }
        long[] ifac = new long[m + 1];
        ifac[0] = 1;
        ifac[1] = 1;
        for (int i = 2; i <= m; i++) {
            ifac[i] = quickmul(i, mod - 2, mod);
        }
        for (int i = 2; i <= m; i++) {
            ifac[i] = (ifac[i - 1] * ifac[i]) % mod;
        }
        long[][] numsPower = new long[n][m + 1];
        for (int i = 0; i < n; i++) {
            numsPower[i][0] = 1;
            for (int j = 1; j <= m; j++) {
                numsPower[i][j] = (numsPower[i][j - 1] * nums[i]) % mod;
            }
        }
        long[][][][] f = new long[n][m + 1][m * 2 + 1][k + 1];
        for (int j = 0; j <= m; j++) {
            f[0][j][j][0] = (numsPower[0][j] * ifac[j]) % mod;
        }
        for (int i = 0; i + 1 < n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int p = 0; p <= m * 2; p++) {
                    for (int q = 0; q <= k; q++) {
                        int q2 = (p % 2) + q;
                        if (q2 > k) {
                            break;
                        }
                        for (int r = 0; r + j <= m; r++) {
                            int p2 = p / 2 + r;
                            f[i + 1][j + r][p2][q2] +=
                                (((f[i][j][p][q] * numsPower[i + 1][r]) % mod) *
                                    ifac[r]) %
                                mod;
                            f[i + 1][j + r][p2][q2] %= mod;
                        }
                    }
                }
            }
        }
        long res = 0;
        for (int p = 0; p <= m * 2; p++) {
            for (int q = 0; q <= k; q++) {
                if (Integer.bitCount(p) + q == k) {
                    res = (res + ((f[n - 1][m][p][q] * fac[m]) % mod)) % mod;
                }
            }
        }
        return (int) res;
    }

    public static long quickmul(long x, long y, long mod) {
        long res = 1;
        long cur = x % mod;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * cur) % mod;
            }
            y >>= 1;
            cur = (cur * cur) % mod;
        }
        return res;
    }

    public static void main(String[] args) {
       int m = 5;
       int k = 5;
       int[] nums = {1, 10, 100, 10000, 1000000}; 
       System.out.println(magicalSum(m, k, nums));
       // 991600007   
    }
}
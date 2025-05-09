// Count Number of Balanced Permutations - https://leetcode.com/problems/count-number-of-balanced-permutations/?envType=daily-question&envId=2025-05-09

// You are given a string num. A string of digits is called balanced if the sum of the digits at even indices is equal to the sum of the digits at odd indices.

// Return the number of distinct permutations of num that are balanced.

// Since the answer may be very large, return it modulo 109 + 7.
// A permutation is a rearrangement of all the characters of a string.

// Input: num = "123"
// Output: 2
// Explanation: The distinct permutations of num are "123", "132", "213", "231", "312" and "321".
// Among them, "132" and "231" are balanced. Thus, the answer is 2.

public class May9__CountNumberOfBalancedPermutations {
    public static int countBalancedPermutations(String num) {
        long MOD = 1_000_000_007;
        int tot = 0, n = num.length();
        int[] cnt = new int[10];
        for (char ch : num.toCharArray()) {
            int d = ch - '0';
            cnt[d]++;
            tot += d;
        }
        if (tot % 2 != 0) {
            return 0;
        }
        int target = tot / 2;
        int maxOdd = (n + 1) / 2;
        long[][] comb = new long[maxOdd + 1][maxOdd + 1];
        long[][] f = new long[target + 1][maxOdd + 1];
        for (int i = 0; i <= maxOdd; i++) {
            comb[i][i] = comb[i][0] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
            }
        }
        f[0][0] = 1;
        int psum = 0, totSum = 0;
        for (int i = 0; i <= 9; i++) {
            psum += cnt[i];
            totSum += i * cnt[i];
            for (int oddCnt = Math.min(psum, maxOdd); oddCnt >= Math.max(0, psum - (n - maxOdd)); oddCnt--) {
                int evenCnt = psum - oddCnt;
                for (int curr = Math.min(totSum, target); curr >= Math.max(0, totSum - target); curr--) {
                    long res = 0;
                    for (int j = Math.max(0, cnt[i] - evenCnt); j <= Math.min(cnt[i], oddCnt) && i * j <= curr; j++) {
                        long ways = (comb[oddCnt][j] * comb[evenCnt][cnt[i] - j]) % MOD;
                        res = (res +
                                ((ways * f[curr - i * j][oddCnt - j]) % MOD)) %
                                MOD;
                    }
                    f[curr][oddCnt] = res % MOD;
                }
            }
        }
        return (int) f[target][maxOdd];
    }

    public static void main(String[] args) {
        String num = "123";
        System.out.println(countBalancedPermutations(num));
        // 2
    }
}

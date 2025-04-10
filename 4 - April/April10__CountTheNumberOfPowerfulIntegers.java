// Count the Number of Powerful Integers - https://leetcode.com/problems/count-the-number-of-powerful-integers/description/?envType=daily-question&envId=2025-04-10

// You are given three integers start, finish, and limit. You are also given a 0-indexed string s representing a positive integer.

// A positive integer x is called powerful if it ends with s (in other words, s is a suffix of x) and each digit in x is at most limit.

// Return the total number of powerful integers in the range [start..finish].

// A string x is a suffix of a string y if and only if x is a substring of y that starts from some index (including 0) in y and extends to the index y.length - 1. For example, 25 is a suffix of 5125 whereas 512 is not.

// Input: start = 1, finish = 6000, limit = 4, s = "124"
// Output: 5
// Explanation: The powerful integers in the range [1..6000] are 124, 1124, 2124, 3124, and, 4124. All these integers have each digit <= 4, and "124" as a suffix. Note that 5124 is not a powerful integer because the first digit is 5 which is greater than 4.
// It can be shown that there are only 5 powerful integers in this range.

import java.util.Arrays;

public class April10__CountTheNumberOfPowerfulIntegers {
    public static long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String low = Long.toString(start);
        String high = Long.toString(finish);
        int n = high.length();
        low = "0".repeat(n - low.length()) + low;
        int pre_len = n - s.length();
        long[] memo = new long[n];
        Arrays.fill(memo, -1);
        return dfs(0, true, true, low, high, limit, s, pre_len, memo);
    }

    private static long dfs(int i, boolean limit_low, boolean limit_high, String low, String high, int limit, String s,
            int pre_len, long[] memo) {
        if (i == low.length()) {
            return 1;
        }
        if (!limit_low && !limit_high && memo[i] != -1) {
            return memo[i];
        }
        int lo = limit_low ? low.charAt(i) - '0' : 0;
        int hi = limit_high ? high.charAt(i) - '0' : 9;
        long res = 0;
        if (i < pre_len) {
            for (int digit = lo; digit <= Math.min(hi, limit); digit++) {
                res += dfs(i + 1, limit_low && digit == lo, limit_high && digit == hi, low, high, limit, s, pre_len,
                        memo);
            }
        } else {
            int x = s.charAt(i - pre_len) - '0';
            if (lo <= x && x <= Math.min(hi, limit)) {
                res = dfs(i + 1, limit_low && x == lo, limit_high && x == hi, low, high, limit, s, pre_len, memo);
            }
        }
        if (!limit_low && !limit_high) {
            memo[i] = res;
        }
        return res;
    }

    public static void main(String[] args) {
        int start = 1;
        int finish = 6000;
        int limit = 4;
        String s = "124";
        System.out.println(numberOfPowerfulInt(start, finish, limit, s));
        // 5
    }
}
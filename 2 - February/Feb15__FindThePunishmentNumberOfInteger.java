// Find the Punishment Number of an Integer - https://leetcode.com/problems/find-the-punishment-number-of-an-integer/description/?envType=daily-question&envId=2025-02-15

// Given a positive integer n, return the punishment number of n.

// The punishment number of n is defined as the sum of the squares of all integers i such that:

// 1 <= i <= n
// The decimal representation of i * i can be partitioned into contiguous substrings such that the sum of the integer values of these substrings equals i.

// Input: n = 10
// Output: 182
// Explanation: There are exactly 3 integers i in the range [1, 10] that satisfy the conditions in the statement:
// - 1 since 1 * 1 = 1
// - 9 since 9 * 9 = 81 and 81 can be partitioned into 8 and 1 with a sum equal to 8 + 1 == 9.
// - 10 since 10 * 10 = 100 and 100 can be partitioned into 10 and 0 with a sum equal to 10 + 0 == 10.
// Hence, the punishment number of 10 is 1 + 81 + 100 = 182

public class Feb15__FindThePunishmentNumberOfInteger {
    public static int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            String squareStr = String.valueOf(square);
            if (helper(i, 0, squareStr.length(), squareStr, 0))
                ans += square;
        }
        return ans;
    }

    private static boolean helper(int num, int idx, int len, String square, int sum) {
        if (idx == len) {
            return sum == num;
        }
        for (int i = idx; i < len; i++) {
            int part = Integer.parseInt(square.substring(idx, i + 1));
            if (helper(num, i + 1, len, square, sum + part))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(punishmentNumber(n));
        // 182
    }
}

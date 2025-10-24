// Next Greater Numerically Balanced Number - https://leetcode.com/problems/next-greater-numerically-balanced-number/description/?envType=daily-question&envId=2025-10-24

// An integer x is numerically balanced if for every digit d in the number x, there are exactly d occurrences of that digit in x.

// Given an integer n, return the smallest numerically balanced number strictly greater than n.

// Input: n = 1000
// Output: 1333
// Explanation: 
// 1333 is numerically balanced since:
// - The digit 1 occurs 1 time.
// - The digit 3 occurs 3 times. 
// It is also the smallest numerically balanced number strictly greater than 1000.
// Note that 1022 cannot be the answer because 0 appeared more than 0 times.

public class Oct24__NextGreaterNumericallyBalancedNumber {
    public static int nextBeautifulNumber(int n) {
        for (int i = n + 1; i <= 1224444; i++) {
            if (isBalance(i))
                return i;
        }
        return -1;
    }

    private static boolean isBalance(int x) {
        int[] count = new int[10];
        while (x > 0) {
            count[x % 10]++;
            x /= 10;
        }
        for (int d = 0; d < 10; d++) {
            if (count[d] > 0 && count[d] != d)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 1000;
        System.out.println(nextBeautifulNumber(n));
        // 1333
    }
}

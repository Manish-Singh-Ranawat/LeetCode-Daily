// Power of Four - https://leetcode.com/problems/power-of-four/?envType=daily-question&envId=2025-08-15

// Given an integer n, return true if it is a power of four. Otherwise, return false.

// An integer n is a power of four, if there exists an integer x such that n == 4x.

// Input: n = 16
// Output: true

public class Aug15__PowerOfFour {
    public static boolean isPowerOfFour(int n) {
        return (n & (n - 1)) == 0 && n % 3 == 1;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfFour(n));
        // true
    }
}
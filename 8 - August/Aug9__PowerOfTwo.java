// Power of Two - https://leetcode.com/problems/power-of-two/description/?envType=daily-question&envId=2025-08-09

// Given an integer n, return true if it is a power of two. Otherwise, return false.

// An integer n is a power of two, if there exists an integer x such that n == 2x.

// Input: n = 16
// Output: true
// Explanation: 24 = 16

public class Aug9__PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
    public static void main(String[] args) {
        int n = 16; 
        System.out.println(isPowerOfTwo(n));
        // true
    }
}


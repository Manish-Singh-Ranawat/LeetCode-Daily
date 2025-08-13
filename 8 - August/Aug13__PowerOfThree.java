// Power of Three - https://leetcode.com/problems/power-of-three/description/?envType=daily-question&envId=2025-08-13

// Given an integer n, return true if it is a power of three. Otherwise, return false.

// An integer n is a power of three, if there exists an integer x such that n == 3^x.

// Input: n = 27
// Output: true
// Explanation: 27 = 3^3

public class Aug13__PowerOfThree {
    public static boolean isPowerOfThree(int n) {
        return n > 0 && Math.pow(3, 19) % n == 0;
    }

    // public static boolean isPowerOfThree(int n) {
    //     if (n <= 0)
    //         return false;
    //     double x = Math.log10(n) / Math.log10(3);
    //     return x == (int) x;
    // }

    public static void main(String[] args) {
        int n = 27;
        System.out.println(isPowerOfThree(n));
        // true
    }
}

// Reordered Power of 2 - https://leetcode.com/problems/reordered-power-of-2/description/?envType=daily-question&envId=2025-08-10

// You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.

// Return true if and only if we can do this so that the resulting number is a power of two.

// Input: n = 1
// Output: true

public class Aug10__ReorderedPowerOfTwo {
    public static boolean reorderedPowerOf2(int n) {
        int num = helper(n);
        for (int i = 0; i <= 29; i++) {
            if (num == helper(1 << i))
                return true;
        }
        return false;
    }

    private static int helper(int n) {
        int num = 0;
        while (n != 0) {
            num += Math.pow(10, n % 10);
            n /= 10;
        }
        return num;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(reorderedPowerOf2(n));
        // true
    }
}

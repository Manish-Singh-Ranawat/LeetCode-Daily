// Check if Number is a Sum of Powers of Three - https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/?envType=daily-question&envId=2025-03-04

// Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.

// An integer y is a power of three if there exists an integer x such that y == 3x.

// Input: n = 12
// Output: true
// Explanation: 12 = 31 + 32

public class March4__CheckIfNumberIsSumOfPowersOfThree {
    public static boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 == 2)
                return false;
            n /= 3;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(checkPowersOfThree(n));
        // true
    }
}

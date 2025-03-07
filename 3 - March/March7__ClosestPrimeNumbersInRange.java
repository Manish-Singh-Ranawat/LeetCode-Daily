// Closest Prime Numbers in Range - https://leetcode.com/problems/closest-prime-numbers-in-range/?envType=daily-question&envId=2025-03-07

// Given two positive integers left and right, find the two integers num1 and num2 such that:
// - left <= num1 < num2 <= right .
// - Both num1 and num2 are prime numbers.
// - num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.

// Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].

// Input: left = 10, right = 19
// Output: [11,13]
// Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
// The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
// Since 11 is smaller than 17, we return the first pair.

import java.util.Arrays;

public class March7__ClosestPrimeNumbersInRange {
    public static int[] closestPrimes(int left, int right) {
        int prevPrime = -1;
        int[] ans = { -1, -1 };
        int minDifference = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                if (prevPrime != -1) {
                    int difference = i - prevPrime;
                    if (difference < minDifference) {
                        ans[0] = prevPrime;
                        ans[1] = i;
                        minDifference = difference;
                    }
                    // Twin prime optimization
                    if (difference == 2 || difference == 1)
                        return ans;
                }
                prevPrime = i;
            }
        }
        return ans;
    }

    private static boolean isPrime(int number) {
        if (number < 2)
            return false;
        if (number == 2 || number == 3)
            return true;
        if (number % 2 == 0)
            return false;
        for (int divisor = 3; divisor * divisor <= number; divisor += 2) {
            if (number % divisor == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int left = 10, right = 19;
        System.out.println(Arrays.toString(closestPrimes(left, right)));
        // [11, 13]
    }
}

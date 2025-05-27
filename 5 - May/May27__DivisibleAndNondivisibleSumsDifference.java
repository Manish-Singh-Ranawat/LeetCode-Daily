// Divisible and Non-divisible Sums Difference - https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/description/?envType=daily-question&envId=2025-05-27

// You are given positive integers n and m.

// Define two integers as follows:
// - num1: The sum of all integers in the range [1, n] (both inclusive) that are not divisible by m.
// - num2: The sum of all integers in the range [1, n] (both inclusive) that are divisible by m.

// Return the integer num1 - num2.

// Input: n = 10, m = 3
// Output: 19
// Explanation: In the given example:
// - Integers in the range [1, 10] that are not divisible by 3 are [1,2,4,5,7,8,10], num1 is the sum of those integers = 37.
// - Integers in the range [1, 10] that are divisible by 3 are [3,6,9], num2 is the sum of those integers = 18.
// We return 37 - 18 = 19 as the answer.

public class May27__DivisibleAndNondivisibleSumsDifference {
    public static int differenceOfSums(int n, int m) {
        int total = (n * (n + 1)) / 2;
        int k = n / m;
        int div = (k * (k + 1)) / 2 * m;
        int nonDiv = total - div;
        return nonDiv - div;
    }

    public static void main(String[] args) {
        int n = 10;
        int m = 3;
        System.out.println(differenceOfSums(n, m));
        // 19
    }
}

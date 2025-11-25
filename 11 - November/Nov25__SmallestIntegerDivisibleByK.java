// Smallest Integer Divisible by K - https://leetcode.com/problems/smallest-integer-divisible-by-k/description/?envType=daily-question&envId=2025-11-25

// Given a positive integer k, you need to find the length of the smallest positive integer n such that n is divisible by k, and n only contains the digit 1.

// Return the length of n. If there is no such n, return -1.

// Note: n may not fit in a 64-bit signed integer.

// Input: k = 3
// Output: 3
// Explanation: The smallest answer is n = 111, which has length 3.

public class Nov25__SmallestIntegerDivisibleByK {
    public static int smallestRepunitDivByK(int K) {
        int rem = 0;
        for (int len = 1; len <= K; len++) {
            rem = (rem * 10 + 1) % K;
            if (rem == 0) 
                return len;
        }
        return -1;
    }

    public static void main(String[] args) {
        int k = 3;
        System.out.println(smallestRepunitDivByK(k));
        // 3
    }
}

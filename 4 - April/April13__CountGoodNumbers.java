// Count Good Numbers - https://leetcode.com/problems/count-good-numbers/description/?envType=daily-question&envId=2025-04-13

// A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

// For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
// Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.

// A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.

// Input: n = 1
// Output: 5
// Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".

// Input: n = 4
// Output: 400

public class April13__CountGoodNumbers {
    static int mod = (int) 1e9 + 7;

    public static int countGoodNumbers(long n) {
        long primes = calcPow(4, n / 2) % mod;
        long evens = calcPow(5, (n + 1) / 2) % mod;
        return (int) ((primes * evens) % mod);
    }

    private static long calcPow(long x, long n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            n = n / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countGoodNumbers(n));
        // 400
    }
}

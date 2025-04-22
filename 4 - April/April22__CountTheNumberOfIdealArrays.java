// Count the Number of Ideal Arrays - https://leetcode.com/problems/count-the-number-of-ideal-arrays/description/?envType=daily-question&envId=2025-04-22

// You are given two integers n and maxValue, which are used to describe an ideal array.

// A 0-indexed integer array arr of length n is considered ideal if the following conditions hold:
// - Every arr[i] is a value from 1 to maxValue, for 0 <= i < n.
// - Every arr[i] is divisible by arr[i - 1], for 0 < i < n.

// Return the number of distinct ideal arrays of length n. Since the answer may be very large, return it modulo 109 + 7.

// Input: n = 2, maxValue = 5
// Output: 10
// Explanation: The following are the possible ideal arrays:
// - Arrays starting with the value 1 (5 arrays): [1,1], [1,2], [1,3], [1,4], [1,5]
// - Arrays starting with the value 2 (2 arrays): [2,2], [2,4]
// - Arrays starting with the value 3 (1 array): [3,3]
// - Arrays starting with the value 4 (1 array): [4,4]
// - Arrays starting with the value 5 (1 array): [5,5]
// There are a total of 5 + 2 + 1 + 1 + 1 = 10 distinct ideal arrays.

import java.util.ArrayList;
import java.util.List;

public class April22__CountTheNumberOfIdealArrays {
    static int MOD = 1_000_000_007;
    static int MAX_N = 10010;
    static int MAX_P = 15;
    static int[][] c = new int[MAX_N + MAX_P][MAX_P + 1];
    static int[] sieve = new int[MAX_N];
    static List<Integer>[] ps = createPsArray(MAX_N);
    static boolean initialized = false;

    @SuppressWarnings("unchecked")
    private static List<Integer>[] createPsArray(int size) {
        return (List<Integer>[]) new ArrayList[size];
    }

    private static void init() {
        if (initialized)
            return;
        initialized = true;
        for (int i = 0; i < MAX_N; i++) {
            ps[i] = new ArrayList<>();
        }
        for (int i = 2; i < MAX_N; i++) {
            if (sieve[i] == 0) {
                for (int j = i; j < MAX_N; j += i) {
                    if (sieve[j] == 0) {
                        sieve[j] = i;
                    }
                }
            }
        }
        for (int i = 2; i < MAX_N; i++) {
            int x = i;
            while (x > 1) {
                int p = sieve[x], cnt = 0;
                while (x % p == 0) {
                    x /= p;
                    cnt++;
                }
                ps[i].add(cnt);
            }
        }
        c[0][0] = 1;
        for (int i = 1; i < MAX_N + MAX_P; i++) {
            c[i][0] = 1;
            for (int j = 1; j <= Math.min(i, MAX_P); j++) {
                c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD;
            }
        }
    }

    public static int idealArrays(int n, int maxValue) {
        init();
        long ans = 0;
        for (int x = 1; x <= maxValue; x++) {
            long mul = 1;
            for (int p : ps[x]) {
                mul = (mul * c[n + p - 1][p]) % MOD;
            }
            ans = (ans + mul) % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int n = 2;
        int maxValue = 5;
        System.out.println(idealArrays(n, maxValue));
        // 10
    }
}
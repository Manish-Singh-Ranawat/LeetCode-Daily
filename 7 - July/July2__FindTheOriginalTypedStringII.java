// Find the Original Typed String II - https://leetcode.com/problems/find-the-original-typed-string-ii/description/?envType=daily-question&envId=2025-07-02

// Alice is attempting to type a specific string on her computer. However, she tends to be clumsy and may press a key for too long, resulting in a character being typed multiple times.

// You are given a string word, which represents the final output displayed on Alice's screen. You are also given a positive integer k.

// Return the total number of possible original strings that Alice might have intended to type, if she was trying to type a string of size at least k.

// Since the answer may be very large, return it modulo 109 + 7.

// Input: word = "aabbccdd", k = 7
// Output: 5
// Explanation: The possible strings are: "aabbccdd", "aabbccd", "aabbcdd", "aabccdd", and "abbccdd".

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class July2__FindTheOriginalTypedStringII {
    public static int possibleStringCount(String word, int k) {
        int mod = 1000000007;
        int n = word.length();
        int cnt = 1;
        List<Integer> freq = new ArrayList<>();
        for (int i = 1; i < n; ++i) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                ++cnt;
            } else {
                freq.add(cnt);
                cnt = 1;
            }
        }
        freq.add(cnt);

        long ans = 1;
        for (int o : freq) {
            ans = (ans * o) % mod;
        }
        if (freq.size() >= k) {
            return (int) ans;
        }

        int[] f = new int[k];
        int[] g = new int[k];
        f[0] = 1;
        Arrays.fill(g, 1);
        for (int i = 0; i < freq.size(); ++i) {
            int[] f_new = new int[k];
            for (int j = 1; j < k; ++j) {
                f_new[j] = g[j - 1];
                if (j - freq.get(i) - 1 >= 0) {
                    f_new[j] = (f_new[j] - g[j - freq.get(i) - 1] + mod) % mod;
                }
            }
            int[] g_new = new int[k];
            g_new[0] = f_new[0];
            for (int j = 1; j < k; ++j) {
                g_new[j] = (g_new[j - 1] + f_new[j]) % mod;
            }
            f = f_new;
            g = g_new;
        }
        return (int) ((ans - g[k - 1] + mod) % mod);
    }

    public static void main(String[] args) {
        String word = "aabbccdd";
        int k = 7;
        System.out.println(possibleStringCount(word, k));
        // 5
    }
}
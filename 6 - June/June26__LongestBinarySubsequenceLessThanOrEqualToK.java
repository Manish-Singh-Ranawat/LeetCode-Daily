// Longest Binary Subsequence Less Than or Equal to K - https://leetcode.com/problems/longest-binary-subsequence-less-than-or-equal-to-k/?envType=daily-question&envId=2025-06-26

// You are given a binary string s and a positive integer k.

// Return the length of the longest subsequence of s that makes up a binary number less than or equal to k.

// Note:
// - The subsequence can contain leading zeroes.
// - The empty string is considered to be equal to 0.
// - A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.

// Input: s = "1001010", k = 5
// Output: 5
// Explanation: The longest subsequence of s that makes up a binary number less than or equal to 5 is "00010", as this number is equal to 2 in decimal.
// Note that "00100" and "00101" are also possible, which are equal to 4 and 5 in decimal, respectively.
// The length of this subsequence is 5, so 5 is returned.

public class June26__LongestBinarySubsequenceLessThanOrEqualToK {
    public static int longestSubsequence(String s, int k) {
        int n = s.length();
        long pow = 1;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                ans++;
            } else if (pow <= k) {
                k -= pow;
                ans++;
            }
            if (pow <= k)
                pow = pow * 2;

        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "1001010";
        int k = 5;
        System.out.println(longestSubsequence(s, k));
        // 5
    }
}

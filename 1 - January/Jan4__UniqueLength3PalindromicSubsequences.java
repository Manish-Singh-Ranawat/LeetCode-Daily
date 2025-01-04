// Unique Length-3 Palindromic Subsequences - https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description/?envType=daily-question&envId=2025-01-04

// Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
// Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.

// A palindrome is a string that reads the same forwards and backwards.
// A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

// For example, "ace" is a subsequence of "abcde".

// Input: s = "aabca"
// Output: 3
// Explanation: The 3 palindromic subsequences of length 3 are:
// - "aba" (subsequence of "aabca")
// - "aaa" (subsequence of "aabca")
// - "aca" (subsequence of "aabca")

import java.util.HashSet;
import java.util.Set;

public class Jan4__UniqueLength3PalindromicSubsequences {
    public static int countPalindromicSubsequence(String s) {
        int firstOccur[] = new int[26];
        int lastOccur[] = new int[26];
        for (int i = 0; i < 26; i++) {
            firstOccur[i] = -1;
            lastOccur[i] = -1;
        }
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (firstOccur[ch - 'a'] == -1) {
                firstOccur[ch - 'a'] = i;
            } else {
                lastOccur[ch - 'a'] = i;
            }
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (firstOccur[i] != -1 && lastOccur[i] != -1) {
                Set<Character> set = new HashSet<>();
                for (int j = firstOccur[i] + 1; j < lastOccur[i]; j++) {
                    set.add(s.charAt(j));
                }
                count += set.size();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aabca";
        System.err.println(countPalindromicSubsequence(s));
        // 3
    }
}

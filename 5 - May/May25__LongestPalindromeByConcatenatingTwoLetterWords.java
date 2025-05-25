// Longest Palindrome by Concatenating Two Letter Words - https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/?envType=daily-question&envId=2025-05-25

// You are given an array of strings words. Each element of words consists of two lowercase English letters.

// Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.

// Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.

// A palindrome is a string that reads the same forward and backward.

// Input: words = ["lc","cl","gg"]
// Output: 6
// Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
// Note that "clgglc" is another longest palindrome that can be created.

import java.util.HashMap;

public class May25__LongestPalindromeByConcatenatingTwoLetterWords {
    public static int longestPalindrome(String[] words) {
        int ans = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            String rev = new StringBuilder(word).reverse().toString();
            if (map.containsKey(rev)) {
                ans += 4;
                if (map.get(rev) == 1)
                    map.remove(rev);
                else
                    map.put(rev, map.get(rev) - 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        for (String s : map.keySet()) {
            if (s.charAt(0) == s.charAt(1)) {
                ans += 2;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = { "lc", "cl", "gg" };
        System.out.println(longestPalindrome(words));
        // 6
    }
}

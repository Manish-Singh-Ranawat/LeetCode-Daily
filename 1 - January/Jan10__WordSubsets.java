// Word Subsets - https://leetcode.com/problems/word-subsets/description/?envType=daily-question&envId=2025-01-10

// You are given two string arrays words1 and words2.

// A string b is a subset of string a if every letter in b occurs in a including multiplicity.

// For example, "wrr" is a subset of "warrior" but is not a subset of "world".
// A string a from words1 is universal if for every string b in words2, b is a subset of a.

// Return an array of all the universal strings in words1. You may return the answer in any order.

// Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
// Output: ["facebook","google","leetcode"]

import java.util.ArrayList;
import java.util.List;

public class Jan10__WordSubsets {
    public static List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];
        for (String word : words2) {
            int[] freq = getFrequencyArray(word);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for (String word : words1) {
            int[] freq = getFrequencyArray(word);
            if (isUniversal(freq, maxFreq)) {
                result.add(word);
            }
        }

        return result;
    }

    private static int[] getFrequencyArray(String word) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        return freq;
    }

    private static boolean isUniversal(int[] freq, int[] maxFreq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] < maxFreq[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words1 = { "amazon", "apple", "facebook", "google", "leetcode" };
        String[] words2 = { "e", "o" };
        System.out.println(wordSubsets(words1, words2));
        // ["facebook","google","leetcode"]
    }
}

// Count of Substrings Containing Every Vowel and K Consonants II - https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/description/?envType=daily-question&envId=2025-03-10

// You are given a string word and a non-negative integer k.

// Return the total number of substrings of word that contain every vowel ('a', 'e', 'i', 'o', and 'u') at least once and exactly k consonants.

// Input: word = "ieaouqqieaouqq", k = 1
// Output: 3
// Explanation:
// The substrings with every vowel and one consonant are:
// word[0..5], which is "ieaouq".
// word[6..11], which is "qieaou".
// word[7..12], which is "ieaouq".

import java.util.HashMap;

public class March10__CountOfSubstringsContainingEveryVowelAndKConsonantsII {
    public static long countOfSubstrings(String word, int k) {
        return atLeastK(word, k) - atLeastK(word, k + 1);
    }

    private static long atLeastK(String word, int k) {
        int n = word.length();
        int l = 0, r = 0;
        int consonants = 0;
        long result = 0;
        HashMap<Character, Integer> vowelMap = new HashMap<>();
        while (r < n) {
            char rChar = word.charAt(r);
            if (isVowel(rChar)) {
                vowelMap.put(rChar, vowelMap.getOrDefault(rChar, 0) + 1);
            } else {
                consonants++;
            }
            while (vowelMap.size() == 5 && consonants >= k) {
                result += n - r;
                char lChar = word.charAt(l);
                if (isVowel(lChar)) {
                    vowelMap.put(lChar, vowelMap.get(lChar) - 1);
                    if (vowelMap.get(lChar) == 0) {
                        vowelMap.remove(lChar);
                    }
                } else {
                    consonants--;
                }
                l++;
            }
            r++;
        }
        return result;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        String word = "ieaouqqieaouqq";
        int k = 1;
        System.out.println(countOfSubstrings(word, k));
        // 3
    }
}

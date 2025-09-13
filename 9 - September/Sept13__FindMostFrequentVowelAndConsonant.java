// Find Most Frequent Vowel and Consonant - https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/description/?envType=daily-question&envId=2025-09-13

// You are given a string s consisting of lowercase English letters ('a' to 'z').

// Your task is to:
// - Find the vowel (one of 'a', 'e', 'i', 'o', or 'u') with the maximum frequency.
// - Find the consonant (all other letters excluding vowels) with the maximum frequency.

// Return the sum of the two frequencies.

// Note: If multiple vowels or consonants have the same maximum frequency, you may choose any one of them. If there are no vowels or no consonants in the string, consider their frequency as 0.

// The frequency of a letter x is the number of times it occurs in the string.

// Input: s = "successes"
// Output: 6
// Explanation:
// The vowels are: 'u' (frequency 1), 'e' (frequency 2). The maximum frequency is 2.
// The consonants are: 's' (frequency 4), 'c' (frequency 2). The maximum frequency is 4.
// The output is 2 + 4 = 6.

public class Sept13__FindMostFrequentVowelAndConsonant {
    public static int maxFreqSum(String s) {
        int[] freq = new int[26];
        int vowel = 0;
        int consonant = 0;
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
            if (isVowel(ch))
                vowel = Math.max(vowel, freq[ch - 'a']);
            else
                consonant = Math.max(consonant, freq[ch - 'a']);
        }
        return vowel + consonant;
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {
        String s = "successes";
        System.out.println(maxFreqSum(s));
        // 6
    }
}

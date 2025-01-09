// Counting Words With a Given Prefix - https://leetcode.com/problems/counting-words-with-a-given-prefix/description/?envType=daily-question&envId=2025-01-09

// You are given an array of strings words and a string pref.

// Return the number of strings in words that contain pref as a prefix.

// A prefix of a string s is any leading contiguous substring of s.

// Input: words = ["pay","attention","practice","attend"], pref = "at"
// Output: 2
// Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".

public class Jan9__CountingWordsWithGivenPrefix {
    public static int prefixCount(String[] words, String pref) {
        int n = words.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (words[i].startsWith(pref)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words = { "pay", "attention", "practice", "attend" };
        String pref = "at";
        System.out.println(prefixCount(words, pref));
        // 2
    }
}
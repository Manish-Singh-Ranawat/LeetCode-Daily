// Count Vowel Strings in Ranges - https://leetcode.com/problems/count-vowel-strings-in-ranges/description/?envType=daily-question&envId=2025-01-02

// You are given a 0-indexed array of strings words and a 2D array of integers queries.

// Each query queries[i] = [li, ri] asks us to find the number of strings present in the range li to ri (both inclusive) of words that start and end with a vowel.

// Return an array ans of size queries.length, where ans[i] is the answer to the ith query.

// Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'.

// Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
// Output: [2,3,0]
// Explanation: The strings starting and ending with a vowel are "aba", "ece", "aa" and "e".
// The answer to the query [0,2] is 2 (strings "aba" and "ece").
// to query [1,4] is 3 (strings "ece", "aa", "e").
// to query [1,1] is 0.
// We return [2,3,0].

public class Jan2__CountVowelStringsInRanges {
    public static int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int m = queries.length;
        int[] ans = new int[m];
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            int size = words[i].length();
            prefix[i] = (i > 0 ? prefix[i - 1] : 0);
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(size - 1))) {
                prefix[i]++;
            }
        }
        for (int i = 0; i < m; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            ans[i] = prefix[ri] - (li > 0 ? prefix[li - 1] : 0);
        }
        return ans;
    }

    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        String[] words = { "aba", "bcb", "ece", "aa", "e" };
        int[][] queries = { { 0, 2 }, { 1, 4 }, { 1, 1 } };
        int[] res = vowelStrings(words, queries);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        // 2 3 0
    }
}

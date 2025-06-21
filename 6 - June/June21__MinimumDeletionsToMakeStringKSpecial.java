// Minimum Deletions to Make String K-Special - https://leetcode.com/problems/minimum-deletions-to-make-string-k-special/?envType=daily-question&envId=2025-06-21

// You are given a string word and an integer k.

// We consider word to be k-special if |freq(word[i]) - freq(word[j])| <= k for all indices i and j in the string.

// Here, freq(x) denotes the frequency of the character x in word, and |y| denotes the absolute value of y.

// Return the minimum number of characters you need to delete to make word k-special.

// Input: word = "aabcaba", k = 0
// Output: 3
// Explanation: We can make word 0-special by deleting 2 occurrences of "a" and 1 occurrence of "c". Therefore, word becomes equal to "baba" where freq('a') == freq('b') == 2.

public class June21__MinimumDeletionsToMakeStringKSpecial {
    public static int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray())
            freq[ch - 'a']++;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            int delete = 0;
            for (int j = 0; j < 26; j++) {
                if (i == j)
                    continue;
                if (freq[j] < freq[i])
                    delete += freq[j];
                else if (freq[j] > freq[i] + k)
                    delete += freq[j] - freq[i] - k;
            }
            ans = Math.min(ans, delete);
        }
        return ans;
    }

    public static void main(String[] args) {
        String word = "aabcaba";
        int k = 0;
        System.out.println(minimumDeletions(word, k));
        // 3
    }
}

// Find the Lexicographically Largest String From the Box I - https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i/description/?envType=daily-question&envId=2025-06-04

// You are given a string word, and an integer numFriends.

// Alice is organizing a game for her numFriends friends. There are multiple rounds in the game, where in each round:
// - word is split into numFriends non-empty strings, such that no previous round has had the exact same split.
// - All the split words are put into a box.

// Find the lexicographically largest string from the box after all the rounds are finished.

// Input: word = "dbca", numFriends = 2
// Output: "dbc"
// Explanation: All possible splits are:
// "d" and "bca".
// "db" and "ca".
// "dbc" and "a".

public class June4__FindLexicographicallyLargestStringFromTheBoxI {
    public static String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int n = word.length();
        int idx = bestStartingIndex(word);
        return word.substring(idx, Math.min(n, idx + n - numFriends + 1));
    }

    private static int bestStartingIndex(String s) {
        int i = 0, j = 1, n = s.length();
        while (j < n) {
            int k = 0;
            while (j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            }
            if (j + k < n && s.charAt(i + k) < s.charAt(j + k)) {
                int t = i;
                i = j;
                j = Math.max(j + 1, t + k + 1);
            } else {
                j = j + k + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        String word = "dbca";
        int numFriends = 2;
        System.out.println(answerString(word, numFriends));
        // dbc
    }
}

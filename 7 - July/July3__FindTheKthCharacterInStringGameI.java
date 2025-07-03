// Find the K-th Character in String Game I - https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/?envType=daily-question&envId=2025-07-03

// Alice and Bob are playing a game. Initially, Alice has a string word = "a".

// You are given a positive integer k.

// Now Bob will ask Alice to perform the following operation forever:
// -  Generate a new string by changing each character in word to its next character in the English alphabet, and append it to the original word.

// For example, performing the operation on "c" generates "cd" and performing the operation on "zb" generates "zbac".

// Return the value of the kth character in word, after enough operations have been done for word to have at least k characters.

// Note that the character 'z' can be changed to 'a' in the operation.

// Input: k = 5
// Output: "b"
// Explanation: Initially, word = "a". We need to do the operation three times:
// Generated string is "b", word becomes "ab".
// Generated string is "bc", word becomes "abbc".
// Generated string is "bccd", word becomes "abbcbccd".

public class July3__FindTheKthCharacterInStringGameI {
    public static char kthCharacter(int k) {
        int ans = 0;
        int t;
        while (k != 1) {
            t = 31 - Integer.numberOfLeadingZeros(k);
            if ((1 << t) == k)
                t--;
            k = k - (1 << t);
            ans++;
        }
        return (char) ('a' + ans);
    }

    public static void main(String[] args) {
        int k = 5;
        System.out.println(kthCharacter(k));
        // b
    }
}

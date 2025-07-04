// Find the K-th Character in String Game II - https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii/?envType=daily-question&envId=2025-07-04

// Alice and Bob are playing a game. Initially, Alice has a string word = "a".

// You are given a positive integer k. You are also given an integer array operations, where operations[i] represents the type of the ith operation.

// Now Bob will ask Alice to perform all operations in sequence:
// - If operations[i] == 0, append a copy of word to itself.
// - If operations[i] == 1, generate a new string by changing each character in word to its next character in the English alphabet, and append it to the original word. For example, performing the operation on "c" generates "cd" and performing the operation on "zb" generates "zbac".

// Return the value of the kth character in word after performing all the operations.

// Note that the character 'z' can be changed to 'a' in the second type of operation.

// Input: k = 10, operations = [0,1,0,1]
// Output: "b"
// Explanation: Initially, word == "a". Alice performs the four operations as follows:
// Appends "a" to "a", word becomes "aa".
// Appends "bb" to "aa", word becomes "aabb".
// Appends "aabb" to "aabb", word becomes "aabbaabb".
// Appends "bbccbbcc" to "aabbaabb", word becomes "aabbaabbbbccbbcc".

public class July4__FindTheKthCharacterInStringGameII {
    public static char kthCharacter(long k, int[] operations) {
        int ans = 0;
        k--;
        for (int i = 63 - Long.numberOfLeadingZeros(k); i >= 0; i--) {
            if (((k >> i) & 1) == 1) {
                ans += operations[i];
            }
        }
        return (char) ('a' + (ans % 26));
    }

    public static void main(String[] args) {
        long k = 10;
        int[] operations = { 0, 1, 0, 1 };
        System.out.println(kthCharacter(k, operations));
        // b
    }
}

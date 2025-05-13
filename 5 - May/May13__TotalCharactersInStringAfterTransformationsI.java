// Total Characters in String After Transformations I - https://leetcode.com/problems/total-characters-in-string-after-transformations-i/description/?envType=daily-question&envId=2025-05-13

// You are given a string s and an integer t, representing the number of transformations to perform. In one transformation, every character in s is replaced according to the following rules:
// - If the character is 'z', replace it with the string "ab".
// - Otherwise, replace it with the next character in the alphabet. For example, 'a' is replaced with 'b', 'b' is replaced with 'c', and so on.

// Return the length of the resulting string after exactly t transformations.

// Since the answer may be very large, return it modulo 109 + 7.

// Input: s = "abcyy", t = 2
// Output: 7
// Explanation:
// First Transformation (t = 1):
// 'a' becomes 'b'
// 'b' becomes 'c'
// 'c' becomes 'd'
// 'y' becomes 'z'
// 'y' becomes 'z'
// String after the first transformation: "bcdzz"
// Second Transformation (t = 2):
// 'b' becomes 'c'
// 'c' becomes 'd'
// 'd' becomes 'e'
// 'z' becomes "ab"
// 'z' becomes "ab"
// String after the second transformation: "cdeabab"
// Final Length of the string: The string is "cdeabab", which has 7 characters.

public class May13__TotalCharactersInStringAfterTransformationsI {
    public static int lengthAfterTransformations(String s, int t) {
        long MOD = 1_000_000_007;
        long[] counts = new long[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (int i = 0; i < t; i++) {
            long[] newCounts = new long[26];
            newCounts[0] += counts[25] % MOD;
            newCounts[1] += counts[25] % MOD;
            for (int j = 0; j < 25; j++) {
                newCounts[j + 1] += counts[j] % MOD;
            }
            counts = newCounts;
        }
        long total = 0;
        for (long count : counts) {
            total = (total + count) % MOD;
        }
        return (int) total;
    }

    public static void main(String[] args) {
        String s = "abcyy";
        int t = 2;
        System.out.println(lengthAfterTransformations(s, t));
        // 7
    }
}

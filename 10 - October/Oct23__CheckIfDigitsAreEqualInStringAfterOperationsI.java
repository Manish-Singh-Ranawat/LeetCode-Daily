// Check If Digits Are Equal in String After Operations I - https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/description/?envType=daily-question&envId=2025-10-23

// You are given a string s consisting of digits. Perform the following operation repeatedly until the string has exactly two digits:
// - For each pair of consecutive digits in s, starting from the first digit, calculate a new digit as the sum of the two digits modulo 10.
// - Replace s with the sequence of newly calculated digits, maintaining the order in which they are computed.

// Return true if the final two digits in s are the same; otherwise, return false.

// Input: s = "3902"
// Output: true
// Explanation:
// Initially, s = "3902"
// First operation:
// (s[0] + s[1]) % 10 = (3 + 9) % 10 = 2
// (s[1] + s[2]) % 10 = (9 + 0) % 10 = 9
// (s[2] + s[3]) % 10 = (0 + 2) % 10 = 2
// s becomes "292"
// Second operation:
// (s[0] + s[1]) % 10 = (2 + 9) % 10 = 1
// (s[1] + s[2]) % 10 = (9 + 2) % 10 = 1
// s becomes "11"
// Since the digits in "11" are the same, the output is true.

public class Oct23__CheckIfDigitsAreEqualInStringAfterOperationsI {
    public static boolean hasSameDigits(String s) {
        int n = s.length();
        char[] sArr = s.toCharArray();
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int first = (int) (sArr[j] - '0');
                int second = (int) (sArr[j + 1] - '0');
                int num = (first + second) % 10;
                sArr[j] = (char) (num + '0');
            }
        }
        return sArr[0] == sArr[1];
    }

    public static void main(String[] args) {
        String s = "3902";
        System.out.println(hasSameDigits(s));
        // true
    }
}

// Construct K Palindrome Strings - https://leetcode.com/problems/construct-k-palindrome-strings/description/?envType=daily-question&envId=2025-01-11

// Given a string s and an integer k, return true if you can use all the characters in s to construct k palindrome strings or false otherwise.

// Input: s = "annabelle", k = 2
// Output: true
// Explanation: You can construct two palindromes using all characters in s.Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"

// Input: s = "leetcode", k = 3
// Output: false
// Explanation: It is impossible to construct 3 palindromes using all the characters of s.

// Input: s = "true", k = 4
// Output: true
// Explanation: The only possible solution is to put each character in a separate string.

public class Jan11__ConstructPalindromeStrings {
    public static boolean canConstruct(String s, int k) {
        if (k > s.length())
            return false;

        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 == 1) {
                odd++;
            }
        }
        return odd <= k;
    }

    public static void main(String[] args) {
        String s = "annabelle";
        int k = 2;
        System.out.println(canConstruct(s, k));
        // true
    }

}

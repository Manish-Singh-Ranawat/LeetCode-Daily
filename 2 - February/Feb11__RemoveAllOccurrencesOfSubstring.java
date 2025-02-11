// Remove All Occurrences of a Substring - https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/?envType=daily-question&envId=2025-02-11

// Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:

// Find the leftmost occurrence of the substring part and remove it from s.
// Return s after removing all occurrences of part.

// A substring is a contiguous sequence of characters in a string.

// Input: s = "daabcbaabcbc", part = "abc"
// Output: "dab"
// Explanation: The following operations are done:
// - s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
// - s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
// - s = "dababc", remove "abc" starting at index 3, so s = "dab".
// Now s has no occurrences of "abc".

public class Feb11__RemoveAllOccurrencesOfSubstring {
    public static String removeOccurrences(String s, String part) {
        int n = part.length();
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            ans.append(ch);
            if (ans.length() >= n && ans.substring(ans.length() - n).equals(part)) {
                ans.delete(ans.length() - n, ans.length());
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "daabcbaabcbc";
        String part = "abc";
        System.out.println(removeOccurrences(s, part));
        // dab
    }
}

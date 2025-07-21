// Delete Characters to Make Fancy String - https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/?envType=daily-question&envId=2025-07-21

// A fancy string is a string where no three consecutive characters are equal.

// Given a string s, delete the minimum possible number of characters from s to make it fancy.

// Return the final string after the deletion. It can be shown that the answer will always be unique.

// Input: s = "leeetcode"
// Output: "leetcode"
// Explanation: Remove an 'e' from the first group of 'e's to create "leetcode".
// No three consecutive characters are equal, so return "leetcode".

public class July21__DeleteCharactersToMakeFancyString {
    public static String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int n = sb.length();
            if (n >= 2 && sb.charAt(n - 2) == sb.charAt(n - 1) && sb.charAt(n - 1) == c)
                continue;
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "leeetcode";
        System.out.println(makeFancyString(s));
        // "leetcode"
    }
}

// The k-th Lexicographical String of All Happy Strings of Length n - https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/?envType=daily-question&envId=2025-02-19

// A happy string is a string that:
// consists only of letters of the set ['a', 'b', 'c'].
// s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).

// For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.

// Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.

// Return the kth string of this list or return an empty string if there are less than k happy strings of length n.

// Input: n = 3, k = 9
// Output: "cab"
// Explanation: There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"

public class Feb19__TheKthLexicographicalStringOfAllHappyStringsOfLengthN {
    public static String getHappyString(int n, int k) {
        StringBuilder ans = new StringBuilder();
        int[] count = { k };
        helper(0, n, new StringBuilder(), count, ans);
        return ans.toString();
    }

    private static void helper(int idx, int n, StringBuilder s, int[] count, StringBuilder ans) {
        if (idx == n) {
            count[0]--;
            if (count[0] == 0) {
                ans.append(s);
            }
            return;
        }
        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (idx == 0 || s.charAt(idx - 1) != ch) {
                s.append(ch);
                helper(idx + 1, n, s, count, ans);
                s.deleteCharAt(s.length() - 1);
                if (count[0] == 0)
                    return;
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 9;
        System.out.println(getHappyString(n, k));
        // cab
    }
}

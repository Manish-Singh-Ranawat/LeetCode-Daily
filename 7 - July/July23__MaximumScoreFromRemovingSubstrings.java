// Maximum Score From Removing Substrings - https://leetcode.com/problems/maximum-score-from-removing-substrings/description/?envType=daily-question&envId=2025-07-23

// You are given a string s and two integers x and y. You can perform two types of operations any number of times.
// - Remove substring "ab" and gain x points.
// For example, when removing "ab" from "cabxbae" it becomes "cxbae".
// - Remove substring "ba" and gain y points.
// For example, when removing "ba" from "cabxbae" it becomes "cabxe".

// Return the maximum points you can gain after applying the above operations on s.

// Input: s = "cdbcbbaaabab", x = 4, y = 5
// Output: 19
// Explanation:
// - Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
// - Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
// - Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
// - Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
// Total score = 5 + 4 + 5 + 5 = 19.

public class July23__MaximumScoreFromRemovingSubstrings {
    public static int maximumGain(String s, int x, int y) {
        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
            s = new StringBuilder(s).reverse().toString();
        }
        int aCount = 0;
        int bCount = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                aCount++;
            } else if (c == 'b') {
                if (aCount > 0) {
                    aCount--;
                    res += x;
                } else {
                    bCount++;
                }
            } else {
                res += Math.min(bCount, aCount) * y;
                aCount = bCount = 0;
            }
        }
        res += Math.min(bCount, aCount) * y;
        return res;
    }

    public static void main(String[] args) {
        String s = "cdbcbbaaabab";
        int x = 4;
        int y = 5;
        System.out.println(maximumGain(s, x, y));
        // 19
    }
}

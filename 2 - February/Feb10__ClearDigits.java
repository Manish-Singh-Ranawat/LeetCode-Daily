// Clear Digits - https://leetcode.com/problems/clear-digits/description/?envType=daily-question&envId=2025-02-10

// You are given a string s.

// Your task is to remove all digits by doing this operation repeatedly:
// Delete the first digit and the closest non-digit character to its left.

// Return the resulting string after removing all digits.

// Input: s = "acb34"
// Output: ""
// Explanation:
// First, we apply the operation on s[3], and s becomes "ac4".
// Then we apply the operation on s[2], and s becomes "a".

public class Feb10__ClearDigits {
    public static String clearDigits(String s) {
        StringBuilder ans = new StringBuilder("");
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                ans.deleteCharAt(ans.length() - 1);
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "acb34";
        System.out.println(clearDigits(s));
        // 
    }
}

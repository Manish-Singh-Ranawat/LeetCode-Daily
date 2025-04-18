// Count and Say - https://leetcode.com/problems/count-and-say/description/?envType=daily-question&envId=2025-04-18

// The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
// - countAndSay(1) = "1"
// - countAndSay(n) is the run-length encoding of countAndSay(n - 1).

// Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".

// Given a positive integer n, return the nth element of the count-and-say sequence.

// Input: n = 4
// Output: "1211"
// Explanation:
// countAndSay(1) = "1"
// countAndSay(2) = RLE of "1" = "11"
// countAndSay(3) = RLE of "11" = "21"
// countAndSay(4) = RLE of "21" = "1211"

public class April18__CountAndSay {
    public static String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = helper(s);
        }
        return s;
    }

    private static String helper(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = s.length();
        while (i < n) {
            char ch = s.charAt(i);
            int count = 0;
            while (i < n && ch == s.charAt(i)) {
                count++;
                i++;
            }
            sb.append(String.valueOf(count));
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countAndSay(n));
        // 1211
    }
}

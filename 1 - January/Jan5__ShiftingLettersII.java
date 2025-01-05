// Shifting Letters II - https://leetcode.com/problems/shifting-letters-ii/description/?envType=daily-question&envId=2025-01-05

// You are given a string s of lowercase English letters and a 2D integer array shifts where shifts[i] = [starti, endi, directioni]. For every i, shift the characters in s from the index starti to the index endi (inclusive) forward if directioni = 1, or shift the characters backward if directioni = 0.

// Shifting a character forward means replacing it with the next letter in the alphabet (wrapping around so that 'z' becomes 'a'). Similarly, shifting a character backward means replacing it with the previous letter in the alphabet (wrapping around so that 'a' becomes 'z').

// Return the final string after all such shifts to s are applied.

// Input: s = "abc", shifts = [[0,1,0],[1,2,1],[0,2,1]]
// Output: "ace"
// Explanation: Firstly, shift the characters from index 0 to index 1 backward. Now s = "zac".
// Secondly, shift the characters from index 1 to index 2 forward. Now s = "zbd".
// Finally, shift the characters from index 0 to index 2 forward. Now s = "ace".

public class Jan5__ShiftingLettersII {
    public static String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] prefixDiff = new int[n + 1];
        for (int[] shift : shifts) {
            int left = shift[0];
            int right = shift[1];
            int direction = shift[2];
            prefixDiff[right + 1] += (direction == 1) ? 1 : -1;
            prefixDiff[left] += (direction == 1) ? -1 : 1;
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = s.charAt(i) - 'a';
        }
        int diff = 0;
        for (int i = n; i > 0; i--) {
            diff += prefixDiff[i];
            res[i - 1] = ((res[i - 1] + diff) % 26 + 26) % 26;
        }
        StringBuilder ans = new StringBuilder("");
        for (int num : res) {
            ans.append((char) ('a' + num));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "abc";
        int[][] shifts = { { 0, 1, 0 }, { 1, 2, 1 }, { 0, 2, 1 } };
        System.out.println(shiftingLetters(s, shifts));
        // ace
    }

}

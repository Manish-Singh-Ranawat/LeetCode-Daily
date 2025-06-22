// Divide a String Into Groups of Size k - https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/description/?envType=daily-question&envId=2025-06-22

// A string s can be partitioned into groups of size k using the following procedure:
// - The first group consists of the first k characters of the string, the second group consists of the next k characters of the string, and so on. Each element can be a part of exactly one group.
// - For the last group, if the string does not have k characters remaining, a character fill is used to complete the group.

// Note that the partition is done so that after removing the fill character from the last group (if it exists) and concatenating all the groups in order, the resultant string should be s.

// Given the string s, the size of each group k and the character fill, return a string array denoting the composition of every group s has been divided into, using the above procedure.

// Input: s = "abcdefghij", k = 3, fill = "x"
// Output: ["abc","def","ghi","jxx"]
// Explanation: We are forming the first three groups "abc", "def", and "ghi".
// For the last group, we can only use the character 'j' from the string. To complete this group, we add 'x' twice.
// Thus, the 4 groups formed are "abc", "def", "ghi", and "jxx".

import java.util.Arrays;

public class June22__DivideStringIntoGroupsOfSizeK {
    public static String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int size = (int) Math.ceil((double) n / (double) k);
        String[] ans = new String[size];
        for (int i = 0; i < n; i += k) {
            if (i + k > n)
                ans[i / k] = s.substring(i) + Character.toString(fill).repeat(i + k - n);
            else
                ans[i / k] = s.substring(i, i + k);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcdefghij";
        int k = 3;
        char fill = 'x';
        System.out.println(Arrays.toString(divideString(s, k, fill)));
        // ["abc","def","ghi","jxx"]
    }
}

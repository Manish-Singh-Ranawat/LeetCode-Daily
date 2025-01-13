// Minimum Length of String After Operations - https://leetcode.com/problems/minimum-length-of-string-after-operations/?envType=daily-question&envId=2025-01-13

// You are given a string s.

// You can perform the following process on s any number of times:

// Choose an index i in the string such that there is at least one character to the left of index i that is equal to s[i], and at least one character to the right that is also equal to s[i].
// Delete the closest character to the left of index i that is equal to s[i].
// Delete the closest character to the right of index i that is equal to s[i].
// Return the minimum length of the final string s that you can achieve.

// Input: s = "abaacbcbb"
// Output: 5
// Explanation: We do the following operations:
// Choose index 2, then remove the characters at indices 0 and 3. The resulting string is s = "bacbcbb".
// Choose index 3, then remove the characters at indices 0 and 5. The resulting string is s = "acbcb".

// Input: s = "aa"
// Output: 2
// Explanation: We cannot perform any operations, so we return the length of the original string.

public class Jan13__MinimumLengthOfStringAfterOperations {
    public static int minimumLength(String s) {
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            int idx = (int) (ch - 'a');
            arr[idx]++;
            if (arr[idx] == 3) {
                arr[idx] = 1;
            }
        }
        int len = 0;
        for (int i = 0; i < 26; i++) {
            len += arr[i];
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "abaacbcbb";
        System.out.println(minimumLength(s));
        // 5
    }
}
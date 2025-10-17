// Maximize the Number of Partitions After Operations - https://leetcode.com/problems/maximize-the-number-of-partitions-after-operations/description/?envType=daily-question&envId=2025-10-17

// You are given a string s and an integer k.

// First, you are allowed to change at most one index in s to another lowercase English letter.

// After that, do the following partitioning operation until s is empty:
// - Choose the longest prefix of s containing at most k distinct characters.
// -  Delete the prefix from s and increase the number of partitions by one. The remaining characters (if any) in s maintain their initial order.

// Return an integer denoting the maximum number of resulting partitions after the operations by optimally choosing at most one index to change.

// Input: s = "accca", k = 2
// Output: 3
// Explanation:
// The optimal way is to change s[2] to something other than a and c, for example, b. then it becomes "acbca".
// Then we perform the operations:
// 1. The longest prefix containing at most 2 distinct characters is "ac", we remove it and s becomes "bca".
// 2. Now The longest prefix containing at most 2 distinct characters is "bc", so we remove it and s becomes "a".
// 3. Finally, we remove "a" and s becomes empty, so the procedure ends.
// Doing the operations, the string is divided into 3 partitions, so the answer is 3.

public class Oct17__MaximizeTheNumberOfPartitionsAfterOperations {
    public static int maxPartitionsAfterOperations(String s, int k) {
        int n = s.length();
        int[][] left = new int[n][3];
        int[][] right = new int[n][3];
        int num = 0;
        int mask = 0;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int binary = 1 << (s.charAt(i) - 'a');
            if ((mask & binary) == 0) {
                count++;
                if (count <= k) {
                    mask |= binary;
                } else {
                    num++;
                    mask = binary;
                    count = 1;
                }
            }
            left[i + 1][0] = num;
            left[i + 1][1] = mask;
            left[i + 1][2] = count;
        }
        num = 0;
        mask = 0;
        count = 0;
        for (int i = n - 1; i > 0; i--) {
            int binary = 1 << (s.charAt(i) - 'a');
            if ((mask & binary) == 0) {
                count++;
                if (count <= k) {
                    mask |= binary;
                } else {
                    num++;
                    mask = binary;
                    count = 1;
                }
            }
            right[i - 1][0] = num;
            right[i - 1][1] = mask;
            right[i - 1][2] = count;
        }
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            int seg = left[i][0] + right[i][0] + 2;
            int totMask = left[i][1] | right[i][1];
            int totCount = Integer.bitCount(totMask);
            if (left[i][2] == k && right[i][2] == k && totCount < 26) {
                seg++;
            } else if (Math.min(totCount + 1, 26) <= k) {
                seg--;
            }
            maxVal = Math.max(maxVal, seg);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        String s = "accca";
        int k = 2;
        System.out.println(maxPartitionsAfterOperations(s, k));
        // 3
    }
}

// Delete Columns to Make Sorted III - https://leetcode.com/problems/delete-columns-to-make-sorted-iii/description/?envType=daily-question&envId=2025-12-22

// You are given an array of n strings strs, all of the same length.

// We may choose any deletion indices, and we delete all the characters in those indices for each string.

// For example, if we have strs = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, then the final array after deletions is ["bef", "vyz"].

// Suppose we chose a set of deletion indices answer such that after deletions, the final array has every string (row) in lexicographic order. (i.e., (strs[0][0] <= strs[0][1] <= ... <= strs[0][strs[0].length - 1]), and (strs[1][0] <= strs[1][1] <= ... <= strs[1][strs[1].length - 1]), and so on). Return the minimum possible value of answer.length.

// Input: strs = ["babca","bbazb"]
// Output: 3
// Explanation: After deleting columns 0, 1, and 4, the final array is strs = ["bc", "az"].
// Both these rows are individually in lexicographic order (ie. strs[0][0] <= strs[0][1] and strs[1][0] <= strs[1][1]).
// Note that strs[0] > strs[1] - the array strs is not necessarily in lexicographic order.

import java.util.Arrays;

public class Dec22__DeleteColumnsToMakeSortedIII {
    public static int minDeletionSize(String[] A) {
        int W = A[0].length();
        int[] dp = new int[W];
        Arrays.fill(dp, 1);
        for (int i = W - 2; i >= 0; --i)
            search: for (int j = i + 1; j < W; ++j) {
                for (String row : A)
                    if (row.charAt(i) > row.charAt(j))
                        continue search;
                dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        int kept = 0;
        for (int x : dp)
            kept = Math.max(kept, x);
        return W - kept;
    }

    public static void main(String[] args) {
        String[] strs = { "babca", "bbazb" };
        System.out.println(minDeletionSize(strs));
        // 3
    }
}

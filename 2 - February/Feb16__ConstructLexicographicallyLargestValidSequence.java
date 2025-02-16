// Construct the Lexicographically Largest Valid Sequence - https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/description/?envType=daily-question&envId=2025-02-16

// Given an integer n, find a sequence that satisfies all of the following:

// The integer 1 occurs once in the sequence.
// Each integer between 2 and n occurs twice in the sequence.
// For every integer i between 2 and n, the distance between the two occurrences of i is exactly i.
// The distance between two numbers on the sequence, a[i] and a[j], is the absolute difference of their indices, |j - i|.

// Return the lexicographically largest sequence. It is guaranteed that under the given constraints, there is always a solution.

// A sequence a is lexicographically larger than a sequence b (of the same length) if in the first position where a and b differ, sequence a has a number greater than the corresponding number in b. For example, [0,1,9,0] is lexicographically larger than [0,1,5,6] because the first position they differ is at the third number, and 9 is greater than 5.

// Input: n = 3
// Output: [3,1,2,3,2]
// Explanation: [2,3,2,1,3] is also a valid sequence, but [3,1,2,3,2] is the lexicographically largest valid sequence.

import java.util.Arrays;

public class Feb16__ConstructLexicographicallyLargestValidSequence {
    public static int[] constructDistancedSequence(int n) {
        int[] ans = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];
        Arrays.fill(ans, -1);
        helper(0, n, ans, used);
        return ans;
    }

    private static boolean helper(int idx, int n, int[] ans, boolean[] used) {
        if (idx == ans.length)
            return true;
        if (ans[idx] != -1)
            return helper(idx + 1, n, ans, used);
        for (int i = n; i >= 1; i--) {
            if (used[i])
                continue;
            int secondIdx = (i > 1) ? idx + i : idx;
            if (secondIdx < ans.length && (i == 1 || ans[secondIdx] == -1)) {
                ans[idx] = i;
                ans[secondIdx] = i;
                used[i] = true;
                if (helper(idx + 1, n, ans, used))
                    return true;
                ans[idx] = -1;
                ans[secondIdx] = -1;
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.toString(constructDistancedSequence(n)));
        // [3, 1, 2, 3, 2]
    }
}

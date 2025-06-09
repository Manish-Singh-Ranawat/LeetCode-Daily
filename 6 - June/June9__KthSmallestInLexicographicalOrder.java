// K-th Smallest in Lexicographical Order - https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/?envType=daily-question&envId=2025-06-09

// Given two integers n and k, return the kth lexicographically smallest integer in the range [1, n].

// Input: n = 13, k = 2
// Output: 10
// Explanation: The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.

public class June9__KthSmallestInLexicographicalOrder {
    public static int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while (k > 0) {
            int step = countSteps(n, curr, curr + 1);
            if (step <= k) {
                curr++;
                k -= step;
            } else {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }

    private static int countSteps(int n, long prefix1, long prefix2) {
        int steps = 0;
        while (prefix1 <= n) {
            steps += Math.min(n + 1, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return steps;
    }

    public static void main(String[] args) {
        int n = 13;
        int k = 2;
        System.out.println(findKthNumber(n, k));
        // 10
    }
}

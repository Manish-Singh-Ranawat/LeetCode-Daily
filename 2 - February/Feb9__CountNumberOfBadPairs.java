// Count Number of Bad Pairs - https://leetcode.com/problems/count-number-of-bad-pairs/description/?envType=daily-question&envId=2025-02-09

// You are given a 0-indexed integer array nums. A pair of indices (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i].

// Return the total number of bad pairs in nums.

// Input: nums = [4, 1, 3, 3]
// Output: 5
// Explanation: The pair (0, 1) is a bad pair since 1 - 0 != 1 - 4.
// The pair (0, 2) is a bad pair since 2 - 0 != 3 - 4, 2 != -1.
// The pair (0, 3) is a bad pair since 3 - 0 != 3 - 4, 3 != -1.
// The pair (1, 2) is a bad pair since 2 - 1 != 3 - 1, 1 != 2.
// The pair (2, 3) is a bad pair since 3 - 2 != 3 - 3, 1 != 0.
// There are a total of 5 bad pairs, so we return 5.

import java.util.HashMap;

public class Feb9__CountNumberOfBadPairs {
    public static long countBadPairs(int[] nums) {
        long n = nums.length;
        long good = 0;
        HashMap<Long, Long> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long cur = nums[i] - i;
            good += freq.getOrDefault(cur, 0L);
            freq.put(cur, freq.getOrDefault(cur, 0L) + 1);
        }
        long total = n * (n - 1) / 2;
        return total - good;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 3, 3 };
        System.out.println(countBadPairs(nums));
        // 5
    }
}

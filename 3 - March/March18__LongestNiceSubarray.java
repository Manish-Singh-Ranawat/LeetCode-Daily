// Longest Nice Subarray - https://leetcode.com/problems/longest-nice-subarray/description/?envType=daily-question&envId=2025-03-18

// You are given an array nums consisting of positive integers.

// We call a subarray of nums nice if the bitwise AND of every pair of elements that are in different positions in the subarray is equal to 0.

// Return the length of the longest nice subarray.

// A subarray is a contiguous part of an array.
// Note that subarrays of length 1 are always considered nice.

// Input: nums = [1,3,8,48,10]
// Output: 3
// Explanation: The longest nice subarray is [3,8,48]. This subarray satisfies the conditions:
// - 3 AND 8 = 0.
// - 3 AND 48 = 0.
// - 8 AND 48 = 0.
// It can be proven that no longer nice subarray can be obtained, so we return 3.

public class March18__LongestNiceSubarray {
    public static int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int mask = 0;
        int ans = 1;
        while (r < n) {
            while ((mask & nums[r]) != 0) {
                mask ^= nums[l];
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            mask |= nums[r];
            r++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 8, 48, 10 };
        System.out.println(longestNiceSubarray(nums));
        // 3
    }
}

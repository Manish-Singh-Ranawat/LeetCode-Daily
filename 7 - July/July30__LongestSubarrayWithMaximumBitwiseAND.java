// Longest Subarray With Maximum Bitwise AND - https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/description/?envType=daily-question&envId=2025-07-30

// You are given an integer array nums of size n.

// Consider a non-empty subarray from nums that has the maximum possible bitwise AND.

// In other words, let k be the maximum value of the bitwise AND of any subarray of nums. Then, only subarrays with a bitwise AND equal to k should be considered.
// Return the length of the longest such subarray.

// The bitwise AND of an array is the bitwise AND of all the numbers in it.

// A subarray is a contiguous sequence of elements within an array.

// Input: nums = [1,2,3,3,2,2]
// Output: 2
// Explanation:
// The maximum possible bitwise AND of a subarray is 3.
// The longest subarray with that value is [3,3], so we return 2.

public class July30__LongestSubarrayWithMaximumBitwiseAND {
    public static int longestSubarray(int[] nums) {
        int max = 0;
        int ans = 0;
        int len = 0;
        for (int num : nums) {
            if (max < num) {
                max = num;
                ans = len = 0;
            }
            if (max == num)
                len++;
            else
                len = 0;
            ans = Math.max(ans, len);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 3, 2, 2 };
        System.out.println(longestSubarray(nums));
        // 2
    }
}

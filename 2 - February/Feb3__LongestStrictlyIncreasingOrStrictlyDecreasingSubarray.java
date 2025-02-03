// Longest Strictly Increasing or Strictly Decreasing Subarray - https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/?envType=daily-question&envId=2025-02-03

// You are given an array of integers nums. Return the length of the longest subarray of nums which is either strictly increasing or strictly decreasing.

// Input: nums = [1,4,3,3,2]
// Output: 2
// Explanation:
// The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].
// The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].
// Hence, we return 2.

public class Feb3__LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    public static int longestMonotonicSubarray(int[] nums) {
        int inc = 1;
        int dec = 1;
        int ans = 1;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1;
            } else if (nums[i] < nums[i - 1]) {
                dec++;
                inc = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            ans = Math.max(ans, Math.max(inc, dec));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 4, 3, 3, 2 };
        System.out.println(longestMonotonicSubarray(nums));
        // 2
    }
}

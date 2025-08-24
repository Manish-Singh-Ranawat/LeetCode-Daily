//  Longest Subarray of 1's After Deleting One Element - https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=daily-question&envId=2025-08-24

// Given a binary array nums, you should delete one element from it.

// Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

// Input: nums = [0,1,1,1,0,1,1,0,1]
// Output: 5
// Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

public class Aug24__LongestSubarrayOfOnesAfterDeletingOneElement {
    public static int longestSubarray(int[] nums) {
        int ans = 0;
        int l = 0;
        int r = 0;
        int n = nums.length;
        int zero = 0;
        while (r < n) {
            if (nums[r] != 1)
                zero++;
            if (zero <= 1) {
                ans = Math.max(ans, r - l);
            } else {
                if (nums[l] != 1)
                    zero--;
                l++;
            }
            r++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
        System.out.println(longestSubarray(nums));
        // 5
    }
}

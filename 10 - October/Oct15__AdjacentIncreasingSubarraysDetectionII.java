// Adjacent Increasing Subarrays Detection II - https://leetcode.com/problems/adjacent-increasing-subarrays-detection-ii/description/?envType=daily-question&envId=2025-10-15

// Given an array nums of n integers, your task is to find the maximum value of k for which there exist two adjacent subarrays of length k each, such that both subarrays are strictly increasing. Specifically, check if there are two subarrays of length k starting at indices a and b (a < b), where:
// - Both subarrays nums[a..a + k - 1] and nums[b..b + k - 1] are strictly increasing.
// - The subarrays must be adjacent, meaning b = a + k.

// Return the maximum possible value of k.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Input: nums = [2,5,7,8,9,2,3,4,3,1]
// Output: 3
// Explanation:
// The subarray starting at index 2 is [7, 8, 9], which is strictly increasing.
// The subarray starting at index 5 is [2, 3, 4], which is also strictly increasing.
// These two subarrays are adjacent, and 3 is the maximum possible value of k for which two such adjacent strictly increasing subarrays exist.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Oct15__AdjacentIncreasingSubarraysDetectionII {
    public static int maxIncreasingSubarrays(List<Integer> nums) {
        int ans = 0;
        int cur = 1;
        int prev = 0;
        int n = nums.size();
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1))
                cur++;
            else {
                prev = cur;
                cur = 1;
            }
            ans = Math.max(ans, Math.min(prev, cur));
            ans = Math.max(ans, cur / 2);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1));
        System.out.println(maxIncreasingSubarrays(nums));
        // 3
    }
}

// Adjacent Increasing Subarrays Detection I - https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/description/?envType=daily-question&envId=2025-10-14

// Given an array nums of n integers and an integer k, determine whether there exist two adjacent subarrays of length k such that both subarrays are strictly increasing. Specifically, check if there are two subarrays starting at indices a and b (a < b), where:
// - Both subarrays nums[a..a + k - 1] and nums[b..b + k - 1] are strictly increasing.
// - The subarrays must be adjacent, meaning b = a + k.

// Return true if it is possible to find two such subarrays, and false otherwise.

// Input: nums = [2,5,7,8,9,2,3,4,3,1], k = 3
// Output: true
// Explanation:
// The subarray starting at index 2 is [7, 8, 9], which is strictly increasing.
// The subarray starting at index 5 is [2, 3, 4], which is also strictly increasing.
// These two subarrays are adjacent, so the result is true.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Oct14__AdjacentIncreasingSubarraysDetectionI {
    public static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int cur = 1;
        int prev = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                cur++;
            } else {
                prev = cur;
                cur = 1;
            }
            if (prev >= k && cur >= k || cur >= 2 * k)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int k = 3;
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1));
        System.out.println(hasIncreasingSubarrays(nums, k));
        // true
    }
}

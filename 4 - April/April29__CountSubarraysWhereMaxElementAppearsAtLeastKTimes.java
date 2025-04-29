// Count Subarrays Where Max Element Appears at Least K Times - https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=daily-question&envId=2025-04-29

// You are given an integer array nums and a positive integer k.

// Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.

// A subarray is a contiguous sequence of elements within an array.

// Input: nums = [1,3,2,3,3], k = 2
// Output: 6
// Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].

public class April29__CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    public static long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int l = 0;
        int r = 0;
        int count = 0;
        long ans = 0;
        while (r < n) {
            if (nums[r] == max)
                count++;
            while (count >= k) {
                ans += n - r;
                if (nums[l] == max)
                    count--;
                l++;
            }
            r++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 3, 3 };
        int k = 2;
        System.out.println(countSubarrays(nums, k));
        // 6
    }
}

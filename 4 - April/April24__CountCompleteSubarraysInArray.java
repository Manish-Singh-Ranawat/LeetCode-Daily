// Count Complete Subarrays in an Array - https://leetcode.com/problems/count-complete-subarrays-in-an-array/description/?envType=daily-question&envId=2025-04-24

// You are given an array nums consisting of positive integers.

// We call a subarray of an array complete if the following condition is satisfied:
// - The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.

// Return the number of complete subarrays.

// A subarray is a contiguous non-empty part of an array.

// Input: nums = [1,3,1,2,2]
// Output: 4
// Explanation: The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2], [3,1,2] and [3,1,2,2].

import java.util.HashMap;

public class April24__CountCompleteSubarraysInArray {
    public static int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int distinct = map.size();
        int l = 0;
        int r = 0;
        int count = 0;
        map = new HashMap<>();
        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.size() == distinct) {
                count += (n - r);
                if (map.get(nums[l]) == 1) {
                    map.remove(nums[l]);
                } else {
                    map.put(nums[l], map.get(nums[l]) - 1);
                }
                l++;
            }
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 1, 2, 2 };
        System.out.println(countCompleteSubarrays(nums));
        // 4
    }
}

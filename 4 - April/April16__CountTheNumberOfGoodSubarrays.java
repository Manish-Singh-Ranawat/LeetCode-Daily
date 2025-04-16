// Count the Number of Good Subarrays - https://leetcode.com/problems/count-the-number-of-good-subarrays/description/?envType=daily-question&envId=2025-04-16

// Given an integer array nums and an integer k, return the number of good subarrays of nums.

// A subarray arr is good if there are at least k pairs of indices (i, j) such that i < j and arr[i] == arr[j].

// A subarray is a contiguous non-empty sequence of elements within an array.

// Input: nums = [3,1,4,3,2,2,4], k = 2
// Output: 4
// Explanation: There are 4 different good subarrays:
// - [3,1,4,3,2,2] that has 2 pairs.
// - [3,1,4,3,2,2,4] that has 3 pairs.
// - [1,4,3,2,2,4] that has 2 pairs.
// - [4,3,2,2,4] that has 2 pairs.

import java.util.HashMap;

public class April16__CountTheNumberOfGoodSubarrays {
    public static long countGood(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        long pairs = 0;
        long ans = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        while (right < n) {
            int rightNumFreq = freqMap.getOrDefault(nums[right], 0);
            pairs += rightNumFreq;
            freqMap.put(nums[right], rightNumFreq + 1);
            while (pairs >= k && left < right) {
                ans += n - right;
                int leftNumFreq = freqMap.get(nums[left]);
                pairs -= (leftNumFreq - 1);
                freqMap.put(nums[left], leftNumFreq - 1);
                left++;
            }
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 3, 2, 2, 4 };
        int k = 2;
        System.out.println(countGood(nums, k));
        // 4
    }
}

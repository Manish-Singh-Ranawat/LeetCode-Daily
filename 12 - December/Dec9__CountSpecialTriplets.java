// Count Special Triplets - https://leetcode.com/problems/count-special-triplets/description/?envType=daily-question&envId=2025-12-09

// You are given an integer array nums.

// A special triplet is defined as a triplet of indices (i, j, k) such that:
// - 0 <= i < j < k < n, where n = nums.length
// - nums[i] == nums[j] * 2
// - nums[k] == nums[j] * 2

// Return the total number of special triplets in the array.

// Since the answer may be large, return it modulo 109 + 7.

// Input: nums = [6,3,6]
// Output: 1
// Explanation: The only special triplet is (i, j, k) = (0, 1, 2), where:
// nums[0] = 6, nums[1] = 3, nums[2] = 6
// nums[0] = nums[1] * 2 = 3 * 2 = 6
// nums[2] = nums[1] * 2 = 3 * 2 = 6

import java.util.HashMap;
import java.util.Map;

public class Dec9__CountSpecialTriplets {
    public static int specialTriplets(int[] nums) {
        final int MOD = 1000000007;
        Map<Integer, Integer> numCnt = new HashMap<>();
        Map<Integer, Integer> numPartialCnt = new HashMap<>();
        for (int v : nums)
            numCnt.put(v, numCnt.getOrDefault(v, 0) + 1);
        long ans = 0;
        for (int v : nums) {
            int target = v * 2;
            int lCnt = numPartialCnt.getOrDefault(target, 0);
            numPartialCnt.put(v, numPartialCnt.getOrDefault(v, 0) + 1);
            int rCnt = numCnt.getOrDefault(target, 0) -
                    numPartialCnt.getOrDefault(target, 0);
            ans = (ans + (long) lCnt * rCnt) % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int[] nums = { 6, 3, 6 };
        System.out.println(specialTriplets(nums));
        // 1
    }
}

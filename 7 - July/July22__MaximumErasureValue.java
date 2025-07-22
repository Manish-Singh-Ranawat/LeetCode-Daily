// Maximum Erasure Value - https://leetcode.com/problems/maximum-erasure-value/description/?envType=daily-question&envId=2025-07-22

// You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

// Return the maximum score you can get by erasing exactly one subarray.

// An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

// Input: nums = [4,2,4,5,6]
// Output: 17
// Explanation: The optimal subarray here is [2,4,5,6].

import java.util.HashMap;

public class July22__MaximumErasureValue {
    public static int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        int res = 0;
        while (r < n) {
            if (map.containsKey(nums[r])) {
                int idx = map.get(nums[r]);
                while (l <= idx) {
                    sum -= nums[l];
                    map.remove(nums[l]);
                    l++;
                }
            }
            sum += nums[r];
            map.put(nums[r], r);
            res = Math.max(res, sum);
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 2, 4, 5, 6 };
        System.out.println(maximumUniqueSubarray(nums));
        // 17
    }
}

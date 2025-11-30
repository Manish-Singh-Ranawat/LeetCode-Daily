// Make Sum Divisible by P - https://leetcode.com/problems/make-sum-divisible-by-p/description/?envType=daily-question&envId=2025-11-30

// Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by p. It is not allowed to remove the whole array.

// Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.

// A subarray is defined as a contiguous block of elements in the array.

// Input: nums = [3,1,4,2], p = 6
// Output: 1
// Explanation: The sum of the elements in nums is 10, which is not divisible by 6. We can remove the subarray [4], and the sum of the remaining elements is 6, which is divisible by 6.

import java.util.HashMap;

public class Nov30__MakeSumDivisibleByP {
    public static int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums)
            totalSum = (totalSum + num) % p;
        int target = totalSum % p;
        if (target == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currentSum = 0;
        int minLen = n;
        for (int i = 0; i < n; ++i) {
            currentSum = (currentSum + nums[i]) % p;
            int needed = (currentSum - target + p) % p;
            if (map.containsKey(needed))
                minLen = Math.min(minLen, i - map.get(needed));
            map.put(currentSum, i);
        }
        return minLen == n ? -1 : minLen;
    }

    public static void main(String[] args) {
        int p = 6;
        int[] nums = { 3, 1, 4, 2 };
        System.out.println(minSubarray(nums, p));
        // 1
    }
}

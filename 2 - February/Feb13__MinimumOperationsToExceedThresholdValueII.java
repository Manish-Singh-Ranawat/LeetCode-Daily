// Minimum Operations to Exceed Threshold Value II - https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/description/?envType=daily-question&envId=2025-02-13

// You are given a 0-indexed integer array nums, and an integer k.

// In one operation, you will:
// Take the two smallest integers x and y in nums.
// Remove x and y from nums.
// Add min(x, y) * 2 + max(x, y) anywhere in the array.
// Note that you can only apply the described operation if nums contains at least two elements.

// Return the minimum number of operations needed so that all elements of the array are greater than or equal to k.

// Input: nums = [2,11,10,1,3], k = 10
// Output: 2
// Explanation: In the first operation, we remove elements 1 and 2, then add 1 * 2 + 2 to nums. nums becomes equal to [4, 11, 10, 3].
// In the second operation, we remove elements 3 and 4, then add 3 * 2 + 4 to nums. nums becomes equal to [10, 11, 10].
// At this stage, all the elements of nums are greater than or equal to 10 so we can stop.
// It can be shown that 2 is the minimum number of operations needed so that all elements of the array are greater than or equal to 10.

import java.util.PriorityQueue;

public class Feb13__MinimumOperationsToExceedThresholdValueII {
    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (num < k)
                pq.offer((long) num);
        }
        int operations = 0;
        while (!pq.isEmpty()) {
            long x = pq.poll();
            operations++;
            if (pq.isEmpty())
                break;
            long y = pq.poll();
            long newValue = 2L * x + y;
            if (newValue < k)
                pq.offer(newValue);
        }
        return operations;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 11, 10, 1, 3 };
        int k = 10;
        System.out.println(minOperations(nums, k));
        // 2
    }
}

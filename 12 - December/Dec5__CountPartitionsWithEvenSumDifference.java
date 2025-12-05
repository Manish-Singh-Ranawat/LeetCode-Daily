// Count Partitions with Even Sum Difference - https://leetcode.com/problems/count-partitions-with-even-sum-difference/description/?envType=daily-question&envId=2025-12-05

// You are given an integer array nums of length n.

// A partition is defined as an index i where 0 <= i < n - 1, splitting the array into two non-empty subarrays such that:
// - Left subarray contains indices [0, i].
// - Right subarray contains indices [i + 1, n - 1].

// Return the number of partitions where the difference between the sum of the left and right subarrays is even.

// Input: nums = [10,10,3,7,6]
// Output: 4
// Explanation:
// The 4 partitions are:
// [10], [10, 3, 7, 6] with a sum difference of 10 - 26 = -16, which is even.
// [10, 10], [3, 7, 6] with a sum difference of 20 - 16 = 4, which is even.
// [10, 10, 3], [7, 6] with a sum difference of 23 - 13 = 10, which is even.
// [10, 10, 3, 7], [6] with a sum difference of 30 - 6 = 24, which is even.

public class Dec5__CountPartitionsWithEvenSumDifference {
    public static int countPartitions(int[] nums) {
        int totalSum = 0;
        for (int x : nums) 
            totalSum += x;
        return totalSum % 2 == 0 ? nums.length - 1 : 0;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 10, 3, 7, 6 };
        System.out.println(countPartitions(nums));
        // 4
    }
}

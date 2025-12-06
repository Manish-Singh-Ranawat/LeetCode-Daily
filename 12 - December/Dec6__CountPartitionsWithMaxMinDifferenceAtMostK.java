// Count Partitions With Max-Min Difference at Most K - https://leetcode.com/problems/count-partitions-with-max-min-difference-at-most-k/?envType=daily-question&envId=2025-12-06

// You are given an integer array nums and an integer k. Your task is to partition nums into one or more non-empty contiguous segments such that in each segment, the difference between its maximum and minimum elements is at most k.

// Return the total number of ways to partition nums under this condition.

// Since the answer may be too large, return it modulo 109 + 7.

// Input: nums = [9,4,1,3,7], k = 4
// Output: 6
// Explanation:
// There are 6 valid partitions where the difference between the maximum and minimum elements in each segment is at most k = 4:
// [[9], [4], [1], [3], [7]]
// [[9], [4], [1], [3, 7]]
// [[9], [4], [1, 3], [7]]
// [[9], [4, 1], [3], [7]]
// [[9], [4, 1], [3, 7]]
// [[9], [4, 1, 3], [7]]

import java.util.Deque;
import java.util.LinkedList;

public class Dec6__CountPartitionsWithMaxMinDifferenceAtMostK {
    public static int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long mod = (long) 1e9 + 7;
        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];
        Deque<Integer> minQ = new LinkedList<>();
        Deque<Integer> maxQ = new LinkedList<>();
        dp[0] = 1;
        prefix[0] = 1;
        for (int i = 0, j = 0; i < n; i++) {
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[i])
                maxQ.pollLast();
            maxQ.offerLast(i);
            while (!minQ.isEmpty() && nums[minQ.peekLast()] >= nums[i])
                minQ.pollLast();
            minQ.offerLast(i);
            while (!maxQ.isEmpty() && !minQ.isEmpty() && nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {
                if (maxQ.peekFirst() == j) 
                    maxQ.pollFirst();
                if (minQ.peekFirst() == j) 
                    minQ.pollFirst();
                j++;
            }
            dp[i + 1] = (prefix[i] - (j > 0 ? prefix[j - 1] : 0) + mod) % mod;
            prefix[i + 1] = (prefix[i] + dp[i + 1]) % mod;
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        int[] nums = {9, 4, 1, 3, 7};
        int k = 4;
        System.out.println(countPartitions(nums, k));
        // 6
    }
}

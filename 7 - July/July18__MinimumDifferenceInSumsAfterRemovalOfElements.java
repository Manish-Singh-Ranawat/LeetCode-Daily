// Minimum Difference in Sums After Removal of Elements - https://leetcode.com/problems/minimum-difference-in-sums-after-removal-of-elements/description/?envType=daily-question&envId=2025-07-18

// You are given a 0-indexed integer array nums consisting of 3 * n elements.

// You are allowed to remove any subsequence of elements of size exactly n from nums. The remaining 2 * n elements will be divided into two equal parts:
// - The first n elements belonging to the first part and their sum is sumfirst.
// - The next n elements belonging to the second part and their sum is sumsecond.

// The difference in sums of the two parts is denoted as sumfirst - sumsecond.
// - For example, if sumfirst = 3 and sumsecond = 2, their difference is 1.
// - Similarly, if sumfirst = 2 and sumsecond = 3, their difference is -1.

// Return the minimum difference possible between the sums of the two parts after the removal of n elements.

// Input: nums = [3,1,2]
// Output: -1
// Explanation: Here, nums has 3 elements, so n = 1. 
// Thus we have to remove 1 element from nums and divide the array into two equal parts.
// - If we remove nums[0] = 3, the array will be [1,2]. The difference in sums of the two parts will be 1 - 2 = -1.
// - If we remove nums[1] = 1, the array will be [3,2]. The difference in sums of the two parts will be 3 - 2 = 1.
// - If we remove nums[2] = 2, the array will be [3,1]. The difference in sums of the two parts will be 3 - 1 = 2.
// The minimum difference between sums of the two parts is min(-1,1,2) = -1. 

import java.util.PriorityQueue;

public class July18__MinimumDifferenceInSumsAfterRemovalOfElements {
    public static long minimumDifference(int[] nums) {
        int n3 = nums.length;
        int n = n3 / 3;
        long[] part1 = new long[n + 1];
        long sum = 0;
        PriorityQueue<Integer> ql = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            ql.add(nums[i]);
        }
        part1[0] = sum;
        for (int i = n; i < n * 2; ++i) {
            sum += nums[i];
            ql.add(nums[i]);
            sum -= ql.poll();
            part1[i - (n - 1)] = sum;
        }

        long part2 = 0;
        PriorityQueue<Integer> qr = new PriorityQueue<>();
        for (int i = n * 3 - 1; i >= n * 2; --i) {
            part2 += nums[i];
            qr.add(nums[i]);
        }
        long ans = part1[n] - part2;
        for (int i = n * 2 - 1; i >= n; --i) {
            part2 += nums[i];
            qr.add(nums[i]);
            part2 -= qr.poll();
            ans = Math.min(ans, part1[i - n] - part2);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2 };
        System.out.println(minimumDifference(nums));
        // -1
    }
}

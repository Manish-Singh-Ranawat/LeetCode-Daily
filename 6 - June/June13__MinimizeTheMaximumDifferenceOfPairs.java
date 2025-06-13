// Minimize the Maximum Difference of Pairs - https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/?envType=daily-question&envId=2025-06-13

// You are given a 0-indexed integer array nums and an integer p. Find p pairs of indices of nums such that the maximum difference amongst all the pairs is minimized. Also, ensure no index appears more than once amongst the p pairs.

// Note that for a pair of elements at the index i and j, the difference of this pair is |nums[i] - nums[j]|, where |x| represents the absolute value of x.

// Return the minimum maximum difference among all p pairs. We define the maximum of an empty set to be zero.

// Input: nums = [10,1,2,7,1,3], p = 2
// Output: 1
// Explanation: The first pair is formed from the indices 1 and 4, and the second pair is formed from the indices 2 and 5. 
// The maximum difference is max(|nums[1] - nums[4]|, |nums[2] - nums[5]|) = max(0, 1) = 1. Therefore, we return 1.

import java.util.Arrays;

public class June13__MinimizeTheMaximumDifferenceOfPairs {
    public static int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        int low = 0;
        int high = nums[n - 1] - nums[0];
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(n, nums, mid) >= p) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int countPairs(int n, int[] nums, int val) {
        int i = 0;
        int count = 0;
        while (i < n - 1) {
            if (nums[i + 1] - nums[i] <= val) {
                count++;
                i += 2;
            } else
                i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 1, 2, 7, 1, 3 };
        int p = 2;
        System.out.println(minimizeMax(nums, p));
        // 1
    }
}

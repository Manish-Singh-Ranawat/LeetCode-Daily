// Smallest Subarrays With Maximum Bitwise OR - https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or/description/?envType=daily-question&envId=2025-07-29

// You are given a 0-indexed array nums of length n, consisting of non-negative integers. For each index i from 0 to n - 1, you must determine the size of the minimum sized non-empty subarray of nums starting at i (inclusive) that has the maximum possible bitwise OR.

// In other words, let Bij be the bitwise OR of the subarray nums[i...j]. You need to find the smallest subarray starting at i, such that bitwise OR of this subarray is equal to max(Bik) where i <= k <= n - 1.
// The bitwise OR of an array is the bitwise OR of all the numbers in it.

// Return an integer array answer of size n where answer[i] is the length of the minimum sized subarray starting at i with maximum bitwise OR.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Input: nums = [1,0,2,1,3]
// Output: [3,3,2,2,1]
// Explanation:
// The maximum possible bitwise OR starting at any index is 3. 
// - Starting at index 0, the shortest subarray that yields it is [1,0,2].
// - Starting at index 1, the shortest subarray that yields the maximum bitwise OR is [0,2,1].
// - Starting at index 2, the shortest subarray that yields the maximum bitwise OR is [2,1].
// - Starting at index 3, the shortest subarray that yields the maximum bitwise OR is [1,3].
// - Starting at index 4, the shortest subarray that yields the maximum bitwise OR is [3].
// Therefore, we return [3,3,2,2,1]. 

import java.util.Arrays;

public class July29__SmallestSubarraysWithMaximumBitwiseOR {
    public static int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] pos = new int[31];
        Arrays.fill(pos, -1);
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            int j = i;
            for (int bit = 0; bit < 31; ++bit) {
                if ((nums[i] & (1 << bit)) == 0) {
                    if (pos[bit] != -1) {
                        j = Math.max(j, pos[bit]);
                    }
                } else {
                    pos[bit] = i;
                }
            }
            ans[i] = j - i + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, 2, 1, 3 };
        System.out.println(Arrays.toString(smallestSubarrays(nums)));
        // [3,3,2,2,1]
    }
}

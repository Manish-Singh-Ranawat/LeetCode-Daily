// Binary Prefix Divisible By 5 - https://leetcode.com/problems/binary-prefix-divisible-by-5/description/?envType=daily-question&envId=2025-11-24

// You are given a binary array nums (0-indexed).

// We define xi as the number whose binary representation is the subarray nums[0..i] (from most-significant-bit to least-significant-bit).
// - For example, if nums = [1,0,1], then x0 = 1, x1 = 2, and x2 = 5.

// Return an array of booleans answer where answer[i] is true if xi is divisible by 5.

// Input: nums = [0,1,1]
// Output: [true,false,false]
// Explanation: The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.
// Only the first number is divisible by 5, so answer[0] is true.

import java.util.ArrayList;
import java.util.List;

public class Nov24__BinaryPrefixDivisibleBy5 {
    public static List<Boolean> prefixesDivBy5(int[] nums) {
        int rem = 0;
        List<Boolean> ans = new ArrayList<Boolean>();
        for (int num : nums) {
            rem = ((rem << 1) + num) % 5;
            ans.add(rem == 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1 };
        System.out.println(prefixesDivBy5(nums));
        // [true, false, false]
    }
}

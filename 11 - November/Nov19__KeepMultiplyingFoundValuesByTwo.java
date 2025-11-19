// Keep Multiplying Found Values by Two - https://leetcode.com/problems/keep-multiplying-found-values-by-two/?envType=daily-question&envId=2025-11-19

// You are given an array of integers nums. You are also given an integer original which is the first number that needs to be searched for in nums.

// You then do the following steps:
// - If original is found in nums, multiply it by two (i.e., set original = 2 * original).
// - Otherwise, stop the process.
// - Repeat this process with the new number as long as you keep finding the number.

// Return the final value of original.

// Input: nums = [5,3,6,1,12], original = 3
// Output: 24
// Explanation: 
// - 3 is found in nums. 3 is multiplied by 2 to obtain 6.
// - 6 is found in nums. 6 is multiplied by 2 to obtain 12.
// - 12 is found in nums. 12 is multiplied by 2 to obtain 24.
// - 24 is not found in nums. Thus, 24 is returned.

import java.util.HashSet;
import java.util.Set;

public class Nov19__KeepMultiplyingFoundValuesByTwo {
    public static int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        while (set.contains(original))
            original *= 2;
        return original;
    }

    public static void main(String[] args) {
        int original = 3;
        int[] nums = { 5, 3, 6, 1, 12 };
        System.out.println(findFinalValue(nums, original));
        // 24
    }
}

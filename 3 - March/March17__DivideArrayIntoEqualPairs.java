// Divide Array Into Equal Pairs - https://leetcode.com/problems/divide-array-into-equal-pairs/?envType=daily-question&envId=2025-03-17

// You are given an integer array nums consisting of 2 * n integers.

// You need to divide nums into n pairs such that:
// - Each element belongs to exactly one pair.
// - The elements present in a pair are equal.

// Return true if nums can be divided into n pairs, otherwise return false.

// Input: nums = [3,2,3,2,2,2]
// Output: true
// Explanation: 
// There are 6 elements in nums, so they should be divided into 6 / 2 = 3 pairs.
// If nums is divided into the pairs (2, 2), (3, 3), and (2, 2), it will satisfy all the conditions.

import java.util.HashSet;
import java.util.Set;

public class March17__DivideArrayIntoEqualPairs {
    public static boolean divideArray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                set.remove(num);
            else
                set.add(num);
        }
        return set.isEmpty();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 2, 2, 2 };
        System.out.println(divideArray(nums));
        // true
    }
}

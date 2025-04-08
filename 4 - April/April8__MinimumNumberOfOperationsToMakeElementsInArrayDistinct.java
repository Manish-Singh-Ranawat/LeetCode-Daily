// Minimum Number of Operations to Make Elements in Array Distinct - https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/?envType=daily-question&envId=2025-04-08

// You are given an integer array nums. You need to ensure that the elements in the array are distinct. To achieve this, you can perform the following operation any number of times:

// Remove 3 elements from the beginning of the array. If the array has fewer than 3 elements, remove all remaining elements.
// Note that an empty array is considered to have distinct elements. Return the minimum number of operations needed to make the elements in the array distinct.

// Input: nums = [1,2,3,4,2,3,3,5,7]
// Output: 2
// Explanation:
// In the first operation, the first 3 elements are removed, resulting in the array [4, 2, 3, 3, 5, 7].
// In the second operation, the next 3 elements are removed, resulting in the array [3, 5, 7], which has distinct elements.

import java.util.HashSet;
import java.util.Set;

public class April8__MinimumNumberOfOperationsToMakeElementsInArrayDistinct {
    public static int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (set.contains(nums[i])) {
                return i / 3 + 1;
            }
            set.add(nums[i]);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 2, 3, 3, 5, 7 };
        System.out.println(minimumOperations(nums));
        // 2
    }
}

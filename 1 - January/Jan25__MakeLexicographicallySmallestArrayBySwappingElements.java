// Make Lexicographically Smallest Array by Swapping Elements - https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/description/?envType=daily-question&envId=2025-01-25

// You are given a 0-indexed array of positive integers nums and a positive integer limit.

// In one operation, you can choose any two indices i and j and swap nums[i] and nums[j] if |nums[i] - nums[j]| <= limit.

// Return the lexicographically smallest array that can be obtained by performing the operation any number of times.

// An array a is lexicographically smaller than an array b if in the first position where a and b differ, array a has an element that is less than the corresponding element in b. For example, the array [2,10,3] is lexicographically smaller than the array [10,2,3] because they differ at index 0 and 2 < 10.

// Input: nums = [1,5,3,9,8], limit = 2
// Output: [1,3,5,8,9]
// Explanation: Apply the operation 2 times:
// - Swap nums[1] with nums[2]. The array becomes [1,3,5,9,8]
// - Swap nums[3] with nums[4]. The array becomes [1,3,5,8,9]
// We cannot obtain a lexicographically smaller array by applying any more operations.
// Note that it may be possible to get the same result by doing different operations.

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Jan25__MakeLexicographicallySmallestArrayBySwappingElements {
    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        ArrayList<ArrayDeque<Integer>> groups = new ArrayList<>();
        HashMap<Integer, Integer> numToGroup = new HashMap<>();
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        for (int i = 0; i < n; i++) {
            if (groups.isEmpty() || Math.abs(sortedNums[i] - groups.get(groups.size() - 1).getLast()) > limit) {
                groups.add(new ArrayDeque<>());
            }
            groups.get(groups.size() - 1).addLast(sortedNums[i]);
            numToGroup.put(sortedNums[i], groups.size() - 1);
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int groupIndex = numToGroup.get(nums[i]);
            result[i] = groups.get(groupIndex).pollFirst();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 3, 9, 8 };
        int limit = 2;
        int[] res = lexicographicallySmallestArray(nums, limit);
        System.out.println(Arrays.toString(res));
        // [1, 3, 5, 8, 9]
    }
}

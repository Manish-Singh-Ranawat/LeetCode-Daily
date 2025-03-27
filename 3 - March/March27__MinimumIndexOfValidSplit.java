// Minimum Index of a Valid Split - zhttps://leetcode.com/problems/minimum-index-of-a-valid-split/description/?envType=daily-question&envId=2025-03-27

// An element x of an integer array arr of length m is dominant if more than half the elements of arr have a value of x.

// You are given a 0-indexed integer array nums of length n with one dominant element.

// You can split nums at an index i into two arrays nums[0, ..., i] and nums[i + 1, ..., n - 1], but the split is only valid if:
// - 0 <= i < n - 1
// - nums[0, ..., i], and nums[i + 1, ..., n - 1] have the same dominant element.

// Here, nums[i, ..., j] denotes the subarray of nums starting at index i and ending at index j, both ends being inclusive. Particularly, if j < i then nums[i, ..., j] denotes an empty subarray.

// Return the minimum index of a valid split. If no valid split exists, return -1.

// Input: nums = [1,2,2,2]
// Output: 2
// Explanation: We can split the array at index 2 to obtain arrays [1,2,2] and [2]. 
// In array [1,2,2], element 2 is dominant since it occurs twice in the array and 2 * 2 > 3. 
// In array [2], element 2 is dominant since it occurs once in the array and 1 * 2 > 1.
// Both [1,2,2] and [2] have the same dominant element as nums, so this is a valid split. 
// It can be shown that index 2 is the minimum index of a valid split. 

import java.util.ArrayList;
import java.util.List;

public class March27__MinimumIndexOfValidSplit {
    public static int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int dominant = 0;
        int freq = 0;
        for (int num : nums) {
            if (freq == 0) {
                dominant = num;
                freq = 1;
            } else if (num == dominant) {
                freq++;
            } else {
                freq--;
            }
        }
        int totalCount = 0;
        for (int num : nums) {
            if (num == dominant)
                totalCount++;
        }
        int leftCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == dominant)
                leftCount++;
            int rightCount = totalCount - leftCount;
            if (leftCount * 2 > i + 1 && rightCount * 2 > n - i - 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 2, 2));
        System.out.println(minimumIndex(nums));
        // 2
    }
}

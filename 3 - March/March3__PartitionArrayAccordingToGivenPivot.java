// Partition Array According to Given Pivot - https://leetcode.com/problems/partition-array-according-to-given-pivot/?envType=daily-question&envId=2025-03-03

// You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions are satisfied:
// - Every element less than pivot appears before every element greater than pivot.
// - Every element equal to pivot appears in between the elements less than and greater than pivot.
// - The relative order of the elements less than pivot and the elements greater than pivot is maintained.

// More formally, consider every pi, pj where pi is the new position of the ith element and pj is the new position of the jth element. If i < j and both elements are smaller (or larger) than pivot, then pi < pj.

// Return nums after the rearrangement.

// Input: nums = [9,12,5,10,14,3,10], pivot = 10
// Output: [9,5,3,10,10,12,14]
// Explanation: 
// The elements 9, 5, and 3 are less than the pivot so they are on the left side of the array.
// The elements 12 and 14 are greater than the pivot so they are on the right side of the array.
// The relative ordering of the elements less than and greater than pivot is also maintained. [9, 5, 3] and [12, 14] are the respective orderings.

import java.util.Arrays;

public class March3__PartitionArrayAccordingToGivenPivot {
    public static int[] pivotArray(int[] nums, int pivot) {
        int less = 0;
        int equal = 0;
        for (int num : nums) {
            if (num < pivot)
                less++;
            else if (num == pivot)
                equal++;
        }
        int[] ans = new int[nums.length];
        int l = 0;
        int e = less;
        int g = less + equal;
        for (int num : nums) {
            if (num < pivot) {
                ans[l] = num;
                l++;
            } else if (num == pivot) {
                ans[e] = num;
                e++;
            } else {
                ans[g] = num;
                g++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 9, 12, 5, 10, 14, 3, 10 };
        int pivot = 10;
        System.out.println(Arrays.toString(pivotArray(nums, pivot)));
        // [9, 5, 3, 10, 10, 12, 14]
    }
}

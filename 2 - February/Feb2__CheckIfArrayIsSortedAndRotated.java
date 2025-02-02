// Check if Array Is Sorted and Rotated - https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

// Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

// There may be duplicates in the original array.
// Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

// Input: nums = [3,4,5,1,2]
// Output: true
// Explanation: [1,2,3,4,5] is the original sorted array.
// You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].

public class Feb2__CheckIfArrayIsSortedAndRotated {
    public static boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 1, 2 };
        System.out.println(check(arr));
        // true
    }
}

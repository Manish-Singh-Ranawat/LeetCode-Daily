// Merge Two 2D Arrays by Summing Values - https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/description/?envType=daily-question&envId=2025-03-02

// You are given two 2D integer arrays nums1 and nums2.

// nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
// nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
// Each array contains unique ids and is sorted in ascending order by id.

// Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:
// - Only ids that appear in at least one of the two arrays should be included in the resulting array.
// - Each id should be included only once and its value should be the sum of the values of this id in the two arrays. If the id does not exist in one of the two arrays, then assume its value in that array to be 0.4

// Return the resulting array. The returned array must be sorted in ascending order by id.

// Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
// Output: [[1,6],[2,3],[3,2],[4,6]]
// Explanation: The resulting array contains the following:
// - id = 1, the value of this id is 2 + 4 = 6.
// - id = 2, the value of this id is 3.
// - id = 3, the value of this id is 2.
// - id = 4, the value of this id is 5 + 1 = 6.

import java.util.ArrayList;
import java.util.Arrays;

public class March2__MergeTwo2DArraysBySummingValues {
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0;
        int j = 0;
        ArrayList<int[]> list = new ArrayList<>();
        while (i < m && j < n) {
            if (nums1[i][0] == nums2[j][0]) {
                list.add(new int[] { nums1[i][0], nums1[i][1] + nums2[j][1] });
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                list.add(nums1[i]);
                i++;
            } else {
                list.add(nums2[j]);
                j++;
            }
        }
        while (i < m) {
            list.add(nums1[i]);
            i++;
        }
        while (j < n) {
            list.add(nums2[j]);
            j++;
        }
        int[][] ans = new int[list.size()][2];
        for (int idx = 0; idx < list.size(); idx++) {
            ans[idx] = list.get(idx);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums1 = { { 1, 2 }, { 2, 3 }, { 4, 5 } };
        int[][] nums2 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
        int[][] ans = mergeArrays(nums1, nums2);
        for (int[] it : ans) {
            System.out.print(Arrays.toString(it) + " ");
        }
        // [1, 6] [2, 3] [3, 2] [4, 6]
    }
}

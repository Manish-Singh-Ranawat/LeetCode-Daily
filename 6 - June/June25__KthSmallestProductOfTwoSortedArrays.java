// Kth Smallest Product of Two Sorted Arrays - https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays/?envType=daily-question&envId=2025-06-25

// Given two sorted 0-indexed integer arrays nums1 and nums2 as well as an integer k, return the kth (1-based) smallest product of nums1[i] * nums2[j] where 0 <= i < nums1.length and 0 <= j < nums2.length.

// Input: nums1 = [-2,-1,0,1,2], nums2 = [-3,-1,2,4,5], k = 3
// Output: -6
// Explanation: The 3 smallest products are:
// - nums1[0] * nums2[4] = (-2) * 5 = -10
// - nums1[0] * nums2[3] = (-2) * 4 = -8
// - nums1[4] * nums2[0] = 2 * (-3) = -6
// The 3rd smallest product is -6.

public class June25__KthSmallestProductOfTwoSortedArrays {

    public static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n1 = nums1.length, n2 = nums2.length;
        int pos1 = 0, pos2 = 0;
        while (pos1 < n1 && nums1[pos1] < 0) {
            pos1++;
        }
        while (pos2 < n2 && nums2[pos2] < 0) {
            pos2++;
        }
        long left = (long) -1e10, right = (long) 1e10;
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            int i1 = 0, i2 = pos2 - 1;
            while (i1 < pos1 && i2 >= 0) {
                if ((long) nums1[i1] * nums2[i2] > mid) {
                    i1++;
                } else {
                    count += pos1 - i1;
                    i2--;
                }
            }
            i1 = pos1;
            i2 = n2 - 1;
            while (i1 < n1 && i2 >= pos2) {
                if ((long) nums1[i1] * nums2[i2] > mid) {
                    i2--;
                } else {
                    count += i2 - pos2 + 1;
                    i1++;
                }
            }
            i1 = 0;
            i2 = pos2;
            while (i1 < pos1 && i2 < n2) {
                if ((long) nums1[i1] * nums2[i2] > mid) {
                    i2++;
                } else {
                    count += n2 - i2;
                    i1++;
                }
            }
            i1 = pos1;
            i2 = 0;
            while (i1 < n1 && i2 < pos2) {
                if ((long) nums1[i1] * nums2[i2] > mid) {
                    i1++;
                } else {
                    count += n1 - i1;
                    i2++;
                }
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums1 = { -2, -1, 0, 1, 2 };
        int[] nums2 = { -3, -1, 2, 4, 5 };
        long k = 3;
        System.out.println(kthSmallestProduct(nums1, nums2, k));
        // -6
    }
}

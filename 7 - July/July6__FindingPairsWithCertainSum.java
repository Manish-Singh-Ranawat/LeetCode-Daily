// Finding Pairs With a Certain Sum - https://leetcode.com/problems/finding-pairs-with-a-certain-sum/description/?envType=daily-question&envId=2025-07-06

// You are given two integer arrays nums1 and nums2. You are tasked to implement a data structure that supports queries of two types:

// 1. Add a positive integer to an element of a given index in the array nums2.
// 2. Count the number of pairs (i, j) such that nums1[i] + nums2[j] equals a given value (0 <= i < nums1.length and 0 <= j < nums2.length).

// Implement the FindSumPairs class:
// - FindSumPairs(int[] nums1, int[] nums2) Initializes the FindSumPairs object with two integer arrays nums1 and nums2.
// - void add(int index, int val) Adds val to nums2[index], i.e., apply nums2[index] += val.
// - int count(int tot) Returns the number of pairs (i, j) such that nums1[i] + nums2[j] == tot.

// Input :
// ["FindSumPairs", "count", "add", "count", "count", "add", "add", "count"]
// [[[1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]], [7], [3, 2], [8], [4], [0, 1], [1, 1], [7]]
// Output :  [null, 8, null, 2, 1, null, null, 11]

import java.util.HashMap;

class FindSumPairs {
    int[] nums1;
    int[] nums2;
    HashMap<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.map = new HashMap<>();
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int num : nums2)
            map.put(num, map.getOrDefault(num, 0) + 1);
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        map.put(oldVal, map.get(oldVal) - 1);
        int newVal = oldVal + val;
        nums2[index] = newVal;
        map.put(newVal, map.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int ans = 0;
        for (int num : nums1)
            ans += map.getOrDefault(tot - num, 0);
        return ans;
    }
}

public class July6__FindingPairsWithCertainSum {
    public static void main(String[] args) {
        FindSumPairs findSumPairs = new FindSumPairs(new int[] { 1, 1, 2, 2, 2, 3 }, new int[] { 1, 4, 5, 2, 5, 4 });
        System.out.println(findSumPairs.count(7)); // 8
        findSumPairs.add(3, 2);
        System.out.println(findSumPairs.count(8)); // 2
        System.out.println(findSumPairs.count(4)); // 1
        findSumPairs.add(0, 1);
        findSumPairs.add(1, 1);
        System.out.println(findSumPairs.count(7)); // 11
    }
}

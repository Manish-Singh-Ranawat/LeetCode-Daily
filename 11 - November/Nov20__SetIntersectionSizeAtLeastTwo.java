// Set Intersection Size At Least Two - https://leetcode.com/problems/set-intersection-size-at-least-two/description/?envType=daily-question&envId=2025-11-20

// You are given a 2D integer array intervals where intervals[i] = [starti, endi] represents all the integers from starti to endi inclusively.

// A containing set is an array nums where each interval from intervals has at least two integers in nums.
// - For example, if intervals = [[1,3], [3,7], [8,9]], then [1,2,4,7,8,9] and [2,3,4,8,9] are containing sets.

// Return the minimum possible size of a containing set.

// Input: intervals = [[1,3],[3,7],[8,9]]
// Output: 5
// Explanation: let nums = [2, 3, 4, 8, 9].
// It can be shown that there cannot be any containing array of size 4.

import java.util.Arrays;

public class Nov20__SetIntersectionSizeAtLeastTwo {
    public static int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int[] todo = new int[intervals.length];
        Arrays.fill(todo, 2);
        int ans = 0;
        int t = intervals.length;
        while (--t >= 0) {
            int s = intervals[t][0];
            int m = todo[t];
            for (int p = s; p < s + m; ++p) {
                for (int i = 0; i <= t; ++i)
                    if (todo[i] > 0 && p <= intervals[i][1])
                        todo[i]--;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 3, 7 }, { 8, 9 } };
        System.out.println(intersectionSizeTwo(intervals));
        // 5
    }
}

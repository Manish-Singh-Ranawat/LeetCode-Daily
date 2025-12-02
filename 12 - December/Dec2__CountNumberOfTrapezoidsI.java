// Count Number of Trapezoids I - https://leetcode.com/problems/count-number-of-trapezoids-i/description/?envType=daily-question&envId=2025-12-02

// You are given a 2D integer array points, where points[i] = [xi, yi] represents the coordinates of the ith point on the Cartesian plane.

// A horizontal trapezoid is a convex quadrilateral with at least one pair of horizontal sides (i.e. parallel to the x-axis). Two lines are parallel if and only if they have the same slope.

// Return the number of unique horizontal trapezoids that can be formed by choosing any four distinct points from points.

// Since the answer may be very large, return it modulo 109 + 7.

// Input: points = [[1,0],[2,0],[3,0],[2,2],[3,2]]
// Output: 3
// Explanation: There are three distinct ways to pick four points that form a horizontal trapezoid:
// Using points [1,0], [2,0], [3,2], and [2,2].
// Using points [2,0], [3,0], [3,2], and [2,2].
// Using points [1,0], [3,0], [3,2], and [2,2].

import java.util.HashMap;

public class Dec2__CountNumberOfTrapezoidsI {
    public static int countTrapezoids(int[][] points) {
        int mod = (int) 1e9 + 7;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] it : points) 
            map.put(it[1], map.getOrDefault(it[1], 0) + 1);
        long ans = 0;
        long sum = 0;
        for (int val : map.values()) {
            long edges = ((long)val * (val - 1) % mod) / 2;
            ans = (ans + edges * sum) % mod;
            sum = (sum + edges) % mod;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int[][] points = { { 1, 0 }, { 2, 0 }, { 3, 0 }, { 2, 2 }, { 3, 2 } };
        System.out.println(countTrapezoids(points));
        // 3
    }
}

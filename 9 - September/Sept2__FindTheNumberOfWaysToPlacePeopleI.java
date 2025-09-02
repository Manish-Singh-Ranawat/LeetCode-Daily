// Find the Number of Ways to Place People I - https://leetcode.com/problems/find-the-number-of-ways-to-place-people-i/?envType=daily-question&envId=2025-09-02

// You are given a 2D array points of size n x 2 representing integer coordinates of some points on a 2D plane, where points[i] = [xi, yi].

// Count the number of pairs of points (A, B), where
// - A is on the upper left side of B, and
// - there are no other points in the rectangle (or line) they make (including the border).

// Return the count.

// Input: points = [[6,2],[4,4],[2,6]]
// Output: 2
// Explanation:
// The left one is the pair (points[1], points[0]), where points[1] is on the upper left side of points[0] and the rectangle is empty.
// The middle one is the pair (points[2], points[1]), same as the left one it is a valid pair.
// The right one is the pair (points[2], points[0]), where points[2] is on the upper left side of points[0], but points[1] is inside the rectangle so it's not a valid pair.

import java.util.Arrays;

public class Sept2__FindTheNumberOfWaysToPlacePeopleI {
    public static int numberOfPairs(int[][] points) {
        int ans = 0;
        int n = points.length;
        Arrays.sort(points, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        for (int i = 0; i < n; i++) {
            int upperY = points[i][1];
            int maxLowerY = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                int currentY = points[j][1];
                if (currentY <= upperY && currentY > maxLowerY) {
                    maxLowerY = currentY;
                    ans++;
                    if (maxLowerY == upperY)
                        break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = { { 6, 2 }, { 4, 4 }, { 2, 6 } };
        System.out.println(numberOfPairs(points));
        // 2
    }
}

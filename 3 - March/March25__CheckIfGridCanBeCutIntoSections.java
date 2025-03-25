// Check if Grid can be Cut into Sections - https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/description/?envType=daily-question&envId=2025-03-25

// You are given an integer n representing the dimensions of an n x n grid, with the origin at the bottom-left corner of the grid. You are also given a 2D array of coordinates rectangles, where rectangles[i] is in the form [startx, starty, endx, endy], representing a rectangle on the grid. 

// Each rectangle is defined as follows:
// - (startx, starty): The bottom-left corner of the rectangle.
// - (endx, endy): The top-right corner of the rectangle.

// Note that the rectangles do not overlap. Your task is to determine if it is possible to make either two horizontal or two vertical cuts on the grid such that:
// - Each of the three resulting sections formed by the cuts contains at least one rectangle.
// - Every rectangle belongs to exactly one section.

// Return true if such cuts can be made; otherwise, return false.

// Input: n = 5, rectangles = [[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]]
// Output: true
// Explanation: We can make horizontal cuts at y = 2 and y = 4. Hence, output is true.

import java.util.Arrays;

public class March25__CheckIfGridCanBeCutIntoSections {
    public static boolean checkValidCuts(int n, int[][] rectangles) {
        int m = rectangles.length;
        int[][] x = new int[m][2];
        int[][] y = new int[m][2];
        for (int i = 0; i < m; i++) {
            x[i][0] = rectangles[i][0];
            x[i][1] = rectangles[i][2];
            y[i][0] = rectangles[i][1];
            y[i][1] = rectangles[i][3];
        }
        Arrays.sort(x, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        Arrays.sort(y, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        return helper(x) || helper(y);
    }

    private static boolean helper(int[][] intervals) {
        int count = 0;
        int furthestEnd = intervals[0][1];
        for (int it[] : intervals) {
            int start = it[0];
            int end = it[1];
            if (start >= furthestEnd) {
                count++;
            }
            furthestEnd = Math.max(furthestEnd, end);
        }
        return count >= 2;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] rectangles = { { 1, 0, 5, 2 }, { 0, 2, 2, 4 }, { 3, 2, 5, 3 }, { 0, 4, 4, 5 } };
        System.out.println(checkValidCuts(n, rectangles));
        // true
    }
}
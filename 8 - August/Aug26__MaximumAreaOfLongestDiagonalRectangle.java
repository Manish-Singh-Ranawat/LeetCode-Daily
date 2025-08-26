// Maximum Area of Longest Diagonal Rectangle - https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/description/?envType=daily-question&envId=2025-08-26

// You are given a 2D 0-indexed integer array dimensions.

// For all indices i, 0 <= i < dimensions.length, dimensions[i][0] represents the length and dimensions[i][1] represents the width of the rectangle i.

// Return the area of the rectangle having the longest diagonal. If there are multiple rectangles with the longest diagonal, return the area of the rectangle having the maximum area.

// Input: dimensions = [[9,3],[8,6]]
// Output: 48
// Explanation: 
// For index = 0, length = 9 and width = 3. Diagonal length = sqrt(9 * 9 + 3 * 3) = sqrt(90) ≈ 9.487.
// For index = 1, length = 8 and width = 6. Diagonal length = sqrt(8 * 8 + 6 * 6) = sqrt(100) = 10.
// So, the rectangle at index 1 has a greater diagonal length therefore we return area = 8 * 6 = 48.

public class Aug26__MaximumAreaOfLongestDiagonalRectangle {
    public static int areaOfMaxDiagonal(int[][] dimensions) {
        int ans = 0;
        int max = 0;
        for (int[] it : dimensions) {
            int l = it[0];
            int w = it[1];
            int d = (l * l) + (w * w);
            if (d > max) {
                max = d;
                ans = l * w;
            } else if (max == d)
                ans = Math.max(ans, l * w);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] dimensions = { { 9, 3 }, { 8, 6 } };
        System.out.println(areaOfMaxDiagonal(dimensions));
    }
}

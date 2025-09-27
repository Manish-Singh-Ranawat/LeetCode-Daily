// Largest Triangle Area - https://leetcode.com/problems/largest-triangle-area/description/?envType=daily-question&envId=2025-09-27

// Given an array of points on the X-Y plane points where points[i] = [xi, yi], return the area of the largest triangle that can be formed by any three different points. Answers within 10-5 of the actual answer will be accepted.

// Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
// Output: 2.00000
// Explanation: The five points are shown in the above figure. The red triangle is the largest.

public class Sept27__LargestTriangleArea {
    public static double largestTriangleArea(int[][] points) {
        double ans = 0;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    double a = euclideanDistance(points[i], points[j]);
                    double b = euclideanDistance(points[j], points[k]);
                    double c = euclideanDistance(points[k], points[i]);
                    if (isValidTriangle(a, b, c)) {
                        double S = (a + b + c) / 2;
                        ans = Math.max(ans, Math.sqrt(S * (S - a) * (S - b) * (S - c)));
                    }
                }
            }
        }

        return ans;
    }

    private static double euclideanDistance(int[] p1, int[] p2) {
        int x = p1[0] - p2[0];
        int y = p1[1] - p2[1];
        return Math.sqrt(x * x + y * y);
    }

    private static boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && b + c > a && c + a > b;
    }

    public static void main(String[] args) {
        int[][] points = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 0, 2 }, { 2, 0 } };
        System.out.println(largestTriangleArea(points));
        // 2
    }
}
// Find the Number of Ways to Place People II - https://leetcode.com/problems/find-the-number-of-ways-to-place-people-ii/description/?envType=daily-question&envId=2025-09-03

// You are given a 2D array points of size n x 2 representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

// We define the right direction as positive x-axis (increasing x-coordinate) and the left direction as negative x-axis (decreasing x-coordinate). Similarly, we define the up direction as positive y-axis (increasing y-coordinate) and the down direction as negative y-axis (decreasing y-coordinate)

// You have to place n people, including Alice and Bob, at these points such that there is exactly one person at every point. Alice wants to be alone with Bob, so Alice will build a rectangular fence with Alice's position as the upper left corner and Bob's position as the lower right corner of the fence (Note that the fence might not enclose any area, i.e. it can be a line). If any person other than Alice and Bob is either inside the fence or on the fence, Alice will be sad.

// Return the number of pairs of points where you can place Alice and Bob, such that Alice does not become sad on building the fence.

// Note that Alice can only build a fence with Alice's position as the upper left corner, and Bob's position as the lower right corner. For example, Alice cannot build either of the fences in the picture below with four corners (1, 1), (1, 3), (3, 1), and (3, 3), because:
// - With Alice at (3, 3) and Bob at (1, 1), Alice's position is not the upper left corner and Bob's position is not the lower right corner of the fence.
// - With Alice at (1, 3) and Bob at (1, 1), Bob's position is not the lower right corner of the fence.

 

// Example 1:


// Input: points = [[1,1],[2,2],[3,3]]
// Output: 0
// Explanation: There is no way to place Alice and Bob such that Alice can build a fence with Alice's position as the upper left corner and Bob's position as the lower right corner. Hence we return 0. 

import java.util.Arrays;

public class Sept3__FindTheNumberOfWaysToPlacePeopleII {
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
        int[][] points = { { 1, 1 }, { 2, 2 }, { 3, 3 } };
        System.out.println(numberOfPairs(points));
        // 0
    }
}

// Find the Maximum Number of Fruits Collected - https://leetcode.com/problems/find-the-maximum-number-of-fruits-collected/?envType=daily-question&envId=2025-08-07

// There is a game dungeon comprised of n x n rooms arranged in a grid.

// You are given a 2D array fruits of size n x n, where fruits[i][j] represents the number of fruits in the room (i, j). Three children will play in the game dungeon, with initial positions at the corner rooms (0, 0), (0, n - 1), and (n - 1, 0).

// The children will make exactly n - 1 moves according to the following rules to reach the room (n - 1, n - 1):
// - The child starting from (0, 0) must move from their current room (i, j) to one of the rooms (i + 1, j + 1), (i + 1, j), and (i, j + 1) if the target room exists.
// - The child starting from (0, n - 1) must move from their current room (i, j) to one of the rooms (i + 1, j - 1), (i + 1, j), and (i + 1, j + 1) if the target room exists.
// - The child starting from (n - 1, 0) must move from their current room (i, j) to one of the rooms (i - 1, j + 1), (i, j + 1), and (i + 1, j + 1) if the target room exists.

// When a child enters a room, they will collect all the fruits there. If two or more children enter the same room, only one child will collect the fruits, and the room will be emptied after they leave.

// Return the maximum number of fruits the children can collect from the dungeon.

// Input: fruits = [[1,2,3,4],[5,6,8,7],[9,10,11,12],[13,14,15,16]]
// Output: 100
// Explanation: In this example
// The 1st child (green) moves on the path (0,0) -> (1,1) -> (2,2) -> (3, 3).
// The 2nd child (red) moves on the path (0,3) -> (1,2) -> (2,3) -> (3, 3).
// The 3rd child (blue) moves on the path (3,0) -> (3,1) -> (3,2) -> (3, 3).
// In total they collect 1 + 6 + 11 + 16 + 4 + 8 + 12 + 13 + 14 + 15 = 100 fruits.

import java.util.Arrays;

public class Aug7__FindMaximumNumberOfFruitsCollected {
    public static int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int ans = 0;
        for (int i = 0; i < n; i++)
            ans += fruits[i][i];
        ans += helper(fruits);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = fruits[j][i];
                fruits[j][i] = fruits[i][j];
                fruits[i][j] = temp;
            }
        }
        ans += helper(fruits);
        return ans;
    }

    private static int helper(int[][] fruits) {
        int n = fruits.length;
        int[] prev = new int[n];
        int[] curr = new int[n];
        Arrays.fill(prev, Integer.MIN_VALUE);
        Arrays.fill(curr, Integer.MIN_VALUE);
        prev[n - 1] = fruits[0][n - 1];
        for (int i = 1; i < n - 1; i++) {
            for (int j = Math.max(n - 1 - i, i + 1); j < n; ++j) {
                int best = prev[j];
                if (j - 1 >= 0)
                    best = Math.max(best, prev[j - 1]);
                if (j + 1 < n)
                    best = Math.max(best, prev[j + 1]);
                curr[j] = best + fruits[i][j];
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[n - 1];
    }

    public static void main(String[] args) {
        int[][] fruits = { { 1, 2, 3, 4 }, { 5, 6, 8, 7 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        System.out.println(maxCollectedFruits(fruits));
        // 100
    }
}

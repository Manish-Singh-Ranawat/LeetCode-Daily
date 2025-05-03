// Minimum Domino Rotations For Equal Row - https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/?envType=daily-question&envId=2025-05-03

// In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

// We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.

// Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.

// If it cannot be done, return -1.

// Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
// Output: 2
// Explanation: 
// The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
// If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

public class May3__MinimumDominoRotationsForEqualRow {
    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int ans = countRotations(tops, bottoms, tops[0]);
        if (tops[0] != bottoms[0])
            ans = Math.min(ans, countRotations(tops, bottoms, bottoms[0]));
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private static int countRotations(int[] tops, int[] bottoms, int target) {
        int n = tops.length;
        int rotateBottom = 0;
        int rotateTop = 0;
        for (int i = 0; i < n; i++) {
            if (tops[i] != target && bottoms[i] != target)
                return Integer.MAX_VALUE;
            if (tops[i] != target)
                rotateTop++;
            if (bottoms[i] != target)
                rotateBottom++;
        }
        return Math.min(rotateTop, rotateBottom);
    }

    public static void main(String[] args) {
        int[] tops = { 2, 1, 2, 4, 2, 2 };
        int[] bottoms = { 5, 2, 6, 2, 3, 2 };
        System.out.println(minDominoRotations(tops, bottoms));
        // 2
    }
}

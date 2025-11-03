// Minimum Time to Make Rope Colorful - https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/?envType=daily-question&envId=2025-11-03

// Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.

// Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color, so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful. You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that Bob needs to remove the ith balloon from the rope.

// Return the minimum time Bob needs to make the rope colorful.

// Input: colors = "abaac", neededTime = [1,2,3,4,5]
// Output: 3
// Explanation: In the above image, 'a' is blue, 'b' is red, and 'c' is green.
// Bob can remove the blue balloon at index 2. This takes 3 seconds.
// There are no longer two consecutive balloons of the same color. Total time = 3.

public class Nov3__MinimumTimeToMakeRopeColorful {
    public static int minCost(String colors, int[] neededTime) {
        int max = 0;
        int sum = 0;
        int n = colors.length();
        for (int i = 0; i < n; i++) {
            if (i > 0 && colors.charAt(i) != colors.charAt(i - 1))
                max = 0;
            sum += Math.min(max, neededTime[i]);
            max = Math.max(max, neededTime[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = { 1, 2, 3, 4, 5 };
        System.out.println(minCost(colors, neededTime));
        // 3
    }
}

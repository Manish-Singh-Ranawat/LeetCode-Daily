// Container With Most Water - https://leetcode.com/problems/container-with-most-water/description/?envType=daily-question&envId=2025-10-04

// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.

// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49

public class Oct4__ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            int w = r - l;
            ans = Math.max(ans, h * w);
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));
        // 49
    }
}
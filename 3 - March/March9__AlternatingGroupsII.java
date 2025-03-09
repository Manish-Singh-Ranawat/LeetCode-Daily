// Alternating Groups II - https://leetcode.com/problems/alternating-groups-ii/?envType=daily-question&envId=2025-03-09

// There is a circle of red and blue tiles. You are given an array of integers colors and an integer k. The color of tile i is represented by colors[i]:
// colors[i] == 0 means that tile i is red.
// colors[i] == 1 means that tile i is blue.

// An alternating group is every k contiguous tiles in the circle with alternating colors (each tile in the group except the first and last one has a different color from its left and right tiles).

// Return the number of alternating groups.

// Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.

// Input: colors = [0,1,0,1,0], k = 3
// Output: 3

public class March9__AlternatingGroupsII {
    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int l = 0;
        int r = 1;
        int ans = 0;
        while (r < n + k - 1) {
            if (colors[r % n] != colors[(r - 1) % n]) {
                if (r - l + 1 == k) {
                    l++;
                    ans++;
                }
            } else {
                l = r;
            }
            r++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] colors = { 0, 1, 0, 1, 0 };
        int k = 3;
        System.out.println(numberOfAlternatingGroups(colors, k));
        // 3
    }
}

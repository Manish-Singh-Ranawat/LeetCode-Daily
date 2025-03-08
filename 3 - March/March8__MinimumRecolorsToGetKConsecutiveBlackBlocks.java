// Minimum Recolors to Get K Consecutive Black Blocks - https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/?envType=daily-question&envId=2025-03-08

// You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.

// You are also given an integer k, which is the desired number of consecutive black blocks.
// In one operation, you can recolor a white block such that it becomes a black block.

// Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.

// Input: blocks = "WBBWWBBWBW", k = 7
// Output: 3
// Explanation: One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks so that blocks = "BBBBBBBWBW". 
// It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations. Therefore, we return 3.

public class March8__MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public static int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int white = 0;
        int minOperations = Integer.MAX_VALUE;
        int l = 0;
        for (int r = 0; r < n; r++) {
            if (blocks.charAt(r) == 'W')
                white++;
            if (r - l + 1 == k) {
                minOperations = Math.min(minOperations, white);
                if (blocks.charAt(l) == 'W')
                    white--;
                l++;
            }
        }
        return minOperations;
    }

    public static void main(String[] args) {
        String blocks = "WBBWWBBWBW";
        int k = 7;
        System.out.println(minimumRecolors(blocks, k));
        // 3
    }
}

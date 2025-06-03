// Maximum Candies You Can Get from Boxes - https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/description/?envType=daily-question&envId=2025-06-03

// You have n boxes labeled from 0 to n - 1. You are given four arrays: status, candies, keys, and containedBoxes where:
// - status[i] is 1 if the ith box is open and 0 if the ith box is closed,
// - candies[i] is the number of candies in the ith box,
// - keys[i] is a list of the labels of the boxes you can open after opening the ith box.
// - containedBoxes[i] is a list of the boxes you found inside the ith box.

// You are given an integer array initialBoxes that contains the labels of the boxes you initially have. You can take all the candies in any open box and you can use the keys in it to open new boxes and you also can use the boxes you find in it.

// Return the maximum number of candies you can get following the rules above.

// Input: status = [1,0,1,0], candies = [7,5,4,100], keys = [[],[],[1],[]], containedBoxes = [[1,2],[3],[],[]], initialBoxes = [0]
// Output: 16
// Explanation: You will be initially given box 0. You will find 7 candies in it and boxes 1 and 2.
// Box 1 is closed and you do not have a key for it so you will open box 2. You will find 4 candies and a key to box 1 in box 2.
// In box 1, you will find 5 candies and box 3 but you will not find a key to box 3 so box 3 will remain closed.
// Total number of candies collected = 7 + 4 + 5 = 16 candy.

import java.util.ArrayDeque;
import java.util.Queue;

public class June3__MaximumCandiesYouCanGetFromBoxes {
    public static int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes,
            int[] initialBoxes) {
        int n = status.length;
        boolean[] canOpen = new boolean[n];
        boolean[] hasBox = new boolean[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++)
            canOpen[i] = (status[i] == 1);
        Queue<Integer> q = new ArrayDeque<>();
        int ans = 0;
        for (int box : initialBoxes) {
            hasBox[box] = true;
            if (canOpen[box]) {
                q.offer(box);
                used[box] = true;
                ans += candies[box];
            }
        }
        while (!q.isEmpty()) {
            int bigBox = q.poll();
            for (int key : keys[bigBox]) {
                canOpen[key] = true;
                if (!used[key] && hasBox[key]) {
                    q.offer(key);
                    used[key] = true;
                    ans += candies[key];
                }
            }
            for (int box : containedBoxes[bigBox]) {
                hasBox[box] = true;
                if (!used[box] && canOpen[box]) {
                    q.offer(box);
                    used[box] = true;
                    ans += candies[box];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] status = { 1, 0, 1, 0 };
        int[] candies = { 7, 5, 4, 100 };
        int[][] keys = { {}, {}, { 1 }, {} };
        int[][] containedBoxes = { { 1, 2 }, { 3 }, {}, {} };
        int[] initialBoxes = { 0 };
        System.out.println(maxCandies(status, candies, keys, containedBoxes, initialBoxes));
        // 16
    }
}

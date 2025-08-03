// Maximum Fruits Harvested After at Most K Steps - https://leetcode.com/problems/maximum-fruits-harvested-after-at-most-k-steps/?envType=daily-question&envId=2025-08-03

// Fruits are available at some positions on an infinite x-axis. You are given a 2D integer array fruits where fruits[i] = [positioni, amounti] depicts amounti fruits at the position positioni. fruits is already sorted by positioni in ascending order, and each positioni is unique.

// You are also given an integer startPos and an integer k. Initially, you are at the position startPos. From any position, you can either walk to the left or right. It takes one step to move one unit on the x-axis, and you can walk at most k steps in total. For every position you reach, you harvest all the fruits at that position, and the fruits will disappear from that position.

// Return the maximum total number of fruits you can harvest.

// Input: fruits = [[0,9],[4,1],[5,7],[6,2],[7,4],[10,9]], startPos = 5, k = 4
// Output: 14
// Explanation: 
// You can move at most k = 4 steps, so you cannot reach position 0 nor 10.
// The optimal way is to:
// - Harvest the 7 fruits at the starting position 5
// - Move left to position 4 and harvest 1 fruit
// - Move right to position 6 and harvest 2 fruits
// - Move right to position 7 and harvest 4 fruits
// You moved 1 + 3 = 4 steps and harvested 7 + 1 + 2 + 4 = 14 fruits in total.

public class Aug3__MaximumFruitsHarvestedAfterAtMostKSteps {
    public static int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int ans = 0;
        int sum = 0;
        int left = 0;
        int right = 0;
        int n = fruits.length;
        while (right < n) {
            sum += fruits[right][1];
            while (left <= right && steps(fruits, startPos, left, right) > k) {
                sum -= fruits[left][1];
                left++;
            }
            ans = Math.max(ans, sum);
            right++;
        }
        return ans;
    }

    private static int steps(int[][] fruits, int startPos, int left, int right) {
        return fruits[right][0] - fruits[left][0]
                + Math.min(Math.abs(startPos - fruits[left][0]), Math.abs(fruits[right][0] - startPos));
    }

    public static void main(String[] args) {
        int[][] fruits = { { 0, 9 }, { 4, 1 }, { 5, 7 }, { 6, 2 }, { 7, 4 }, { 10, 9 } };
        int startPos = 5;
        int k = 4;
        System.out.println(maxTotalFruits(fruits, startPos, k));
        // 14
    }
}

// Put Marbles in Bags - https://leetcode.com/problems/put-marbles-in-bags/description/?envType=daily-question&envId=2025-03-31

// You have k bags. You are given a 0-indexed integer array weights where weights[i] is the weight of the ith marble. You are also given the integer k.

// Divide the marbles into the k bags according to the following rules:
// - No bag is empty.
// - If the ith marble and jth marble are in a bag, then all marbles with an index between the ith and jth indices should also be in that same bag.
// - If a bag consists of all the marbles with an index from i to j inclusively, then the cost of the bag is weights[i] + weights[j].

// The score after distributing the marbles is the sum of the costs of all the k bags.

// Return the difference between the maximum and minimum scores among marble distributions.

// Input: weights = [1,3,5,1], k = 2
// Output: 4
// Explanation: 
// The distribution [1],[3,5,1] results in the minimal score of (1+1) + (3+1) = 6. 
// The distribution [1,3],[5,1], results in the maximal score of (1+3) + (5+1) = 10. 
// Thus, we return their difference 10 - 6 = 4.


import java.util.Arrays;

public class March31__PutMarblesInBags {
    public static long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] pairWt = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            pairWt[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(pairWt);
        long ans = 0;
        for (int i = 0; i < k - 1; i++) {
            ans += pairWt[n - i - 2] - pairWt[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] weights = { 1, 3, 5, 1 };
        int k = 2;
        System.out.println(putMarbles(weights, k));
        // 4
    }
}

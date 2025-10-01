// Water Bottles - https://leetcode.com/problems/water-bottles/description/?envType=daily-question&envId=2025-10-01

// There are numBottles water bottles that are initially full of water. You can exchange numExchange empty water bottles from the market with one full water bottle.

// The operation of drinking a full water bottle turns it into an empty bottle.

// Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.

// Input: numBottles = 15, numExchange = 4
// Output: 19
// Explanation: You can exchange 4 empty bottles to get 1 full water bottle. 
// Number of water bottles you can drink: 15 + 3 + 1 = 19.

public class Oct1__WaterBottles {
    public static int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        while (numBottles >= numExchange) {
            int k = numBottles / numExchange;
            ans += (k * numExchange);
            numBottles -= (k * numExchange);
            numBottles += k;
        }
        ans += numBottles;
        return ans;
    }

    public static void main(String[] args) {
        int numBottles = 15;
        int numExchange = 4;
        System.out.println(numWaterBottles(numBottles, numExchange));
        // 19
    }
}

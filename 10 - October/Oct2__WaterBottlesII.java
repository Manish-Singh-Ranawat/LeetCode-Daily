// Water Bottles II - https://leetcode.com/problems/water-bottles-ii/description/?envType=daily-question&envId=2025-10-02

// You are given two integers numBottles and numExchange.

// numBottles represents the number of full water bottles that you initially have. In one operation, you can perform one of the following operations:
// - Drink any number of full water bottles turning them into empty bottles.
// - Exchange numExchange empty bottles with one full water bottle. Then, increase numExchange by one.

// Note that you cannot exchange multiple batches of empty bottles for the same value of numExchange. For example, if numBottles == 3 and numExchange == 1, you cannot exchange 3 empty water bottles for 3 full bottles.

// Return the maximum number of water bottles you can drink.

// Input: numBottles = 13, numExchange = 6
// Output: 15

public class Oct2__WaterBottlesII {
    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;
        int empty = numBottles;
        while (empty >= numExchange) {
            empty -= numExchange;
            ans++;
            empty++;
            numExchange++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int numBottles = 13;
        int numExchange = 6;
        System.out.println(maxBottlesDrunk(numBottles, numExchange));
        // 15
    }
}

// Alice and Bob Playing Flower Game - https://leetcode.com/problems/alice-and-bob-playing-flower-game/?envType=daily-question&envId=2025-08-29

// Alice and Bob are playing a turn-based game on a field, with two lanes of flowers between them. There are x flowers in the first lane between Alice and Bob, and y flowers in the second lane between them.

// The game proceeds as follows:
// - Alice takes the first turn.
// - In each turn, a player must choose either one of the lane and pick one flower from that side.
// -  At the end of the turn, if there are no flowers left at all, the current player captures their opponent and wins the game.

// Given two integers, n and m, the task is to compute the number of possible pairs (x, y) that satisfy the conditions:
// - Alice must win the game according to the described rules.
// - The number of flowers x in the first lane must be in the range [1,n].
// - The number of flowers y in the second lane must be in the range [1,m].

// Return the number of possible pairs (x, y) that satisfy the conditions mentioned in the statement.

// Input: n = 3, m = 2
// Output: 3
// Explanation: The following pairs satisfy conditions described in the statement: (1,2), (3,2), (2,1).

public class Aug29__AliceAndBobPlayingFlowerGame {
    public static long flowerGame(int n, int m) {
        long nOdd = (n + 1) / 2;
        long nEven = n / 2;
        long mOdd = (m + 1) / 2;
        long mEven = m / 2;
        return nOdd * mEven + nEven * mOdd;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 2;
        System.out.println(flowerGame(n, m)); 
        // 3
    }
}

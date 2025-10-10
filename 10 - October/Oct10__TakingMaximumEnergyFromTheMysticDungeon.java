// Taking Maximum Energy From the Mystic Dungeon - https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon/?envType=daily-question&envId=2025-10-10

// In a mystic dungeon, n magicians are standing in a line. Each magician has an attribute that gives you energy. Some magicians can give you negative energy, which means taking energy from you.

// You have been cursed in such a way that after absorbing energy from magician i, you will be instantly transported to magician (i + k). This process will be repeated until you reach the magician where (i + k) does not exist.

// In other words, you will choose a starting point and then teleport with k jumps until you reach the end of the magicians' sequence, absorbing all the energy during the journey.

// You are given an array energy and an integer k. Return the maximum possible energy you can gain.

// Note that when you are reach a magician, you must take energy from them, whether it is negative or positive energy.

// Input: energy = [5,2,-10,-5,1], k = 3
// Output: 3
// Explanation: We can gain a total energy of 3 by starting from magician 1 absorbing 2 + 1 = 3.

public class Oct10__TakingMaximumEnergyFromTheMysticDungeon {
    public static int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        int ans = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = energy[i] + (i + k < n ? dp[i + k] : 0);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] energy = { 5, 2, -10, -5, 1 };
        System.out.println(maximumEnergy(energy, k));
        // 3
    }
}

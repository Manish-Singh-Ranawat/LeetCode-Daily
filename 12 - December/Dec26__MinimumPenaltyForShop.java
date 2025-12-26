// Minimum Penalty for a Shop - https://leetcode.com/problems/minimum-penalty-for-a-shop/description/?envType=daily-question&envId=2025-12-26

// You are given the customer visit log of a shop represented by a 0-indexed string customers consisting only of characters 'N' and 'Y':
// - if the ith character is 'Y', it means that customers come at the ith hour
// - whereas 'N' indicates that no customers come at the ith hour.

// If the shop closes at the jth hour (0 <= j <= n), the penalty is calculated as follows:
// - For every hour when the shop is open and no customers come, the penalty increases by 1.
// - For every hour when the shop is closed and customers come, the penalty increases by 1.

// Return the earliest hour at which the shop must be closed to incur a minimum penalty.

// Note that if a shop closes at the jth hour, it means the shop is closed at the hour j.

// Input: customers = "YYNY"
// Output: 2

public class Dec26__MinimumPenaltyForShop {
    public static int bestClosingTime(String customers) {
        int minPenalty = 0;
        int curPenalty = 0;
        int earliestHour = 0;
        for (int i = 0; i < customers.length(); i++) {
            char ch = customers.charAt(i);
            if (ch == 'Y')
                curPenalty--;
            else
                curPenalty++;
            if (curPenalty < minPenalty) {
                earliestHour = i + 1;
                minPenalty = curPenalty;
            }
        }
        return earliestHour;
    }

    public static void main(String[] args) {
        String customers = "YYNY";
        System.out.println(bestClosingTime(customers));
        // 2
    }
}

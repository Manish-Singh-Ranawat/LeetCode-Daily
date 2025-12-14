// Number of Ways to Divide a Long Corridor - https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/?envType=daily-question&envId=2025-12-14

// Along a long library corridor, there is a line of seats and decorative plants. You are given a 0-indexed string corridor of length n consisting of letters 'S' and 'P' where each 'S' represents a seat and each 'P' represents a plant.

// One room divider has already been installed to the left of index 0, and another to the right of index n - 1. Additional room dividers can be installed. For each position between indices i - 1 and i (1 <= i <= n - 1), at most one divider can be installed.

// Divide the corridor into non-overlapping sections, where each section has exactly two seats with any number of plants. There may be multiple ways to perform the division. Two ways are different if there is a position with a room divider installed in the first way but not in the second way.

// Return the number of ways to divide the corridor. Since the answer may be very large, return it modulo 109 + 7. If there is no way, return 0.

// Input: corridor = "SSPPSPS"
// Output: 3
// Explanation: There are 3 different ways to divide the corridor.
// The black bars in the above image indicate the two room dividers already installed.
// Note that in each of the ways, each section has exactly two seats.

public class Dec14__NumberOfWaysToDivideLongCorridor {
    public static int numberOfWays(String corridor) {
        int MOD = 1_000_000_007;
        long count = 1;
        int seats = 0;
        Integer previousPairLast = null;
        for (int index = 0; index < corridor.length(); index++) {
            if (corridor.charAt(index) == 'S') {
                seats += 1;
                if (seats == 2) {
                    previousPairLast = index;
                    seats = 0;
                } else if (seats == 1 && previousPairLast != null) {
                    count *= (index - previousPairLast);
                    count %= MOD;
                }
            }
        }
        if (seats == 1 || previousPairLast == null)
            return 0;
        return (int) count;
    }

    public static void main(String[] args) {
        String corridor = "SSPPSPS";
        System.out.println(numberOfWays(corridor));
        // 3
    }
}

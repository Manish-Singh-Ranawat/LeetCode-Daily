// The Earliest and Latest Rounds Where Players Compete - https://leetcode.com/problems/the-earliest-and-latest-rounds-where-players-compete/description/?envType=daily-question&envId=2025-07-12

// There is a tournament where n players are participating. The players are standing in a single row and are numbered from 1 to n based on their initial standing position (player 1 is the first player in the row, player 2 is the second player in the row, etc.).

// The tournament consists of multiple rounds (starting from round number 1). In each round, the ith player from the front of the row competes against the ith player from the end of the row, and the winner advances to the next round. When the number of players is odd for the current round, the player in the middle automatically advances to the next round.

// For example, if the row consists of players 1, 2, 4, 6, 7
// - Player 1 competes against player 7.
// - Player 2 competes against player 6.
// - Player 4 automatically advances to the next round.

// After each round is over, the winners are lined back up in the row based on the original ordering assigned to them initially (ascending order).

// The players numbered firstPlayer and secondPlayer are the best in the tournament. They can win against any other player before they compete against each other. If any two other players compete against each other, either of them might win, and thus you may choose the outcome of this round.

// Given the integers n, firstPlayer, and secondPlayer, return an integer array containing two values, the earliest possible round number and the latest possible round number in which these two players will compete against each other, respectively.

// Input: n = 11, firstPlayer = 2, secondPlayer = 4
// Output: [3,4]
// Explanation:
// One possible scenario which leads to the earliest round number:
// First round: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
// Second round: 2, 3, 4, 5, 6, 11
// Third round: 2, 3, 4
// One possible scenario which leads to the latest round number:
// First round: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
// Second round: 1, 2, 3, 4, 5, 6
// Third round: 1, 2, 4
// Fourth round: 2, 4

import java.util.Arrays;

public class July12__TheEarliestAndLatestRoundsWherePlayersCompete {
    public static int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        if (firstPlayer > secondPlayer) {
            int temp = firstPlayer;
            firstPlayer = secondPlayer;
            secondPlayer = temp;
        }
        int[] res = dp(n, firstPlayer, secondPlayer);
        return new int[] { res[0], res[1] };
    }

    private static int[][][] F = new int[30][30][30];
    private static int[][][] G = new int[30][30][30];

    private static int[] dp(int n, int f, int s) {
        if (F[n][f][s] != 0) {
            return new int[] { F[n][f][s], G[n][f][s] };
        }
        if (f + s == n + 1) {
            return new int[] { 1, 1 };
        }
        if (f + s > n + 1) {
            int[] res = dp(n, n + 1 - s, n + 1 - f);
            F[n][f][s] = res[0];
            G[n][f][s] = res[1];
            return new int[] { F[n][f][s], G[n][f][s] };
        }

        int earliest = Integer.MAX_VALUE;
        int latest = Integer.MIN_VALUE;
        int n_half = (n + 1) / 2;
        if (s <= n_half) {
            for (int i = 0; i < f; ++i) {
                for (int j = 0; j < s - f; ++j) {
                    int[] res = dp(n_half, i + 1, i + j + 2);
                    earliest = Math.min(earliest, res[0]);
                    latest = Math.max(latest, res[1]);
                }
            }
        } else {
            int s_prime = n + 1 - s;
            int mid = (n - 2 * s_prime + 1) / 2;
            for (int i = 0; i < f; ++i) {
                for (int j = 0; j < s_prime - f; ++j) {
                    int[] res = dp(n_half, i + 1, i + j + mid + 2);
                    earliest = Math.min(earliest, res[0]);
                    latest = Math.max(latest, res[1]);
                }
            }
        }

        F[n][f][s] = earliest + 1;
        G[n][f][s] = latest + 1;
        return new int[] { F[n][f][s], G[n][f][s] };
    }

    public static void main(String[] args) {
        int n = 11;
        int firstPlayer = 2;
        int secondPlayer = 4;
        System.out.println(Arrays.toString(earliestAndLatest(n, firstPlayer, secondPlayer)));
        // [3, 4]
    }
}

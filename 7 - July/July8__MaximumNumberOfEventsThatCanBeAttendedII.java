// Maximum Number of Events That Can Be Attended II - https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/description/?envType=daily-question&envId=2025-07-08

// You are given an array of events where events[i] = [startDayi, endDayi, valuei]. The ith event starts at startDayi and ends at endDayi, and if you attend this event, you will receive a value of valuei. You are also given an integer k which represents the maximum number of events you can attend.

// You can only attend one event at a time. If you choose to attend an event, you must attend the entire event. Note that the end day is inclusive: that is, you cannot attend two events where one of them starts and the other ends on the same day.

// Return the maximum sum of values that you can receive by attending events.

// Input: events = [[1,2,4],[3,4,3],[2,3,1]], k = 2
// Output: 7
// Explanation: Choose the green events, 0 and 1 (0-indexed) for a total value of 4 + 3 = 7.

import java.util.Arrays;

public class July8__MaximumNumberOfEventsThatCanBeAttendedII {
    // -- Tabulation --
    public static int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = n - 1; i >= 0; i--) {
            int end = events[i][1];
            int val = events[i][2];
            int nextIdx = findNextNonOverlappingEvent(events, end);
            for (int j = 1; j <= k; j++) {
                int pick = val + dp[nextIdx][j - 1];
                int notPick = dp[i + 1][j];
                dp[i][j] = Math.max(pick, notPick);
            }
        }
        return dp[0][k];
    }

    private static int findNextNonOverlappingEvent(int[][] events, int target) {
        int low = 0;
        int high = events.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (events[mid][0] <= target) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return low;
    }

    // -- Memoization --
    // public int maxValue(int[][] events, int k) {
    //     Arrays.sort(events, (a, b) -> a[0] - b[0]);
    //     int n = events.length;
    //     int[][] dp = new int[n][k + 1];
    //     for (int[] row : dp) {
    //         Arrays.fill(row, -1);
    //     }
    //     return helper(0, k, events, dp);
    // }

    // private static int helper(int i, int k, int[][] events, int[][] dp) {
    //     if (i >= events.length || k == 0)
    //         return 0;
    //     int end = events[i][1];
    //     int val = events[i][2];
    //     if (dp[i][k] != -1)
    //         return dp[i][k];
    //     int nextIdx = findNextNonOverlappingEvent(events, end);
    //     int pick = val + helper(nextIdx, k - 1, events, dp);
    //     int notPick = helper(i + 1, k, events, dp);
    //     return dp[i][k] = Math.max(pick, notPick);
    // }

    public static void main(String[] args) {
        int[][] events = { { 1, 2, 4 }, { 3, 4, 3 }, { 2, 3, 1 } };
        int k = 2;
        System.out.println(maxValue(events, k));
        // 7
    }
}

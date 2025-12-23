// Two Best Non-Overlapping Events - https://leetcode.com/problems/two-best-non-overlapping-events/?envType=daily-question&envId=2025-12-23

// You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei]. The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei. You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.

// Return this maximum sum.

// Note that the start time and end time is inclusive: that is, you cannot attend two events where one of them starts and the other ends at the same time. More specifically, if you attend an event with end time t, the next event must start at or after t + 1.

// Input: events = [[1,3,2],[4,5,2],[2,4,3]]
// Output: 4
// Explanation: Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.

import java.util.ArrayList;
import java.util.List;

public class Dec23__TwoBestNonOverlappingEvents {
    public static int maxTwoEvents(int[][] events) {
        List<int[]> times = new ArrayList<>();
        for (int[] event : events) {
            times.add(new int[] { event[0], 1, event[2] });
            times.add(new int[] { event[1] + 1, 0, event[2] });
        }
        times.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int ans = 0;
        int maxValue = 0;
        for (int[] timeValue : times) {
            if (timeValue[1] == 1)
                ans = Math.max(ans, timeValue[2] + maxValue);
            else
                maxValue = Math.max(maxValue, timeValue[2]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] events = { { 1, 3, 2 }, { 4, 5, 2 }, { 2, 4, 3 } };
        System.out.println(maxTwoEvents(events));
        // 4
    }
}
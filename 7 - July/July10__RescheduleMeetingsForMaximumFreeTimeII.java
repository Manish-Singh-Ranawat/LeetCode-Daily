// Reschedule Meetings for Maximum Free Time II - https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-ii/description/?envType=daily-question&envId=2025-07-10

// You are given an integer eventTime denoting the duration of an event. You are also given two integer arrays startTime and endTime, each of length n.

// These represent the start and end times of n non-overlapping meetings that occur during the event between time t = 0 and time t = eventTime, where the ith meeting occurs during the time [startTime[i], endTime[i]].

// You can reschedule at most one meeting by moving its start time while maintaining the same duration, such that the meetings remain non-overlapping, to maximize the longest continuous period of free time during the event.

// Return the maximum amount of free time possible after rearranging the meetings.

// Note that the meetings can not be rescheduled to a time outside the event and they should remain non-overlapping.

// Note: In this version, it is valid for the relative ordering of the meetings to change after rescheduling one meeting.

// Input: eventTime = 5, startTime = [1,3], endTime = [2,5]
// Output: 2
// Explanation: Reschedule the meeting at [1, 2] to [2, 3], leaving no meetings during the time [0, 2].

public class July10__RescheduleMeetingsForMaximumFreeTimeII {
    public static int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gap = new int[n + 1];
        gap[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            gap[i] = startTime[i] - endTime[i - 1];
        }
        gap[n] = eventTime - endTime[n - 1];
        int[] maxRight = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], gap[i + 1]);
        }
        int maxLeft = 0;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int currEventTime = endTime[i - 1] - startTime[i - 1];
            if (currEventTime <= Math.max(maxLeft, maxRight[i])) {
                ans = Math.max(ans, gap[i - 1] + currEventTime + gap[i]);
            }
            ans = Math.max(ans, gap[i - 1] + gap[i]);
            maxLeft = Math.max(maxLeft, gap[i - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int eventTime = 5;
        int[] startTime = { 1, 3 };
        int[] endTime = { 2, 5 };
        System.out.println(maxFreeTime(eventTime, startTime, endTime));
        // 2
    }
}

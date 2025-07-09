// Reschedule Meetings for Maximum Free Time I - https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-i/description/?envType=daily-question&envId=2025-07-09

// You are given an integer eventTime denoting the duration of an event, where the event occurs from time t = 0 to time t = eventTime.

// You are also given two integer arrays startTime and endTime, each of length n. These represent the start and end time of n non-overlapping meetings, where the ith meeting occurs during the time [startTime[i], endTime[i]].

// You can reschedule at most k meetings by moving their start time while maintaining the same duration, to maximize the longest continuous period of free time during the event.

// The relative order of all the meetings should stay the same and they should remain non-overlapping.

// Return the maximum amount of free time possible after rearranging the meetings.

// Note that the meetings can not be rescheduled to a time outside the event.

// Input: eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5]
// Output: 2
// Explanation: Reschedule the meeting at [1, 2] to [2, 3], leaving no meetings during the time [0, 2].

public class July9__RescheduleMeetingsForMaximumFreeTimeI {
    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int res = 0;
        int t = 0;
        for (int i = 0; i < n; i++) {
            t += endTime[i] - startTime[i];
            int left = i <= k - 1 ? 0 : endTime[i - k];
            int right = i == n - 1 ? eventTime : startTime[i + 1];
            res = Math.max(res, right - left - t);
            if (i >= k - 1) {
                t -= endTime[i - k + 1] - startTime[i - k + 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int eventTime = 5;
        int k = 1;
        int[] startTime = { 1, 3 };
        int[] endTime = { 2, 5 };
        System.out.println(maxFreeTime(eventTime, k, startTime, endTime));
        // 2
    }
}

// Count Days Without Meetings - https://leetcode.com/problems/count-days-without-meetings/description/?envType=daily-question&envId=2025-03-24

// You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1). You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).

// Return the count of days when the employee is available for work but no meetings are scheduled.

// Note: The meetings may overlap.

// Input: days = 10, meetings = [[5,7],[1,3],[9,10]]
// Output: 2
// Explanation: There is no meeting scheduled on the 4th and 8th days.

import java.util.Arrays;

public class March24__CountDaysWithoutMeetings {
    public static int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        int n = meetings.length;
        int count = 0;
        int lastEndTime = 0;
        for (int i = 0; i < n; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            if (start > lastEndTime + 1) {
                count += start - lastEndTime - 1;
            }
            lastEndTime = Math.max(lastEndTime, end);
        }
        count += days - lastEndTime;
        return count;
    }

    public static void main(String[] args) {
        int days = 10;
        int[][] meetings = { { 5, 7 }, { 1, 3 }, { 9, 10 } };
        System.out.println(countDays(days, meetings));
        // 2
    }
}

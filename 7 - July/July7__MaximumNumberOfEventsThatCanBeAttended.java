// Maximum Number of Events That Can Be Attended - https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/?envType=daily-question&envId=2025-07-07

// You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

// You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.

// Return the maximum number of events you can attend.

// Input: events = [[1,2],[2,3],[3,4]]
// Output: 3
// Explanation: You can attend all the three events.
// One way to attend them all is as shown.
// Attend the first event on day 1.
// Attend the second event on day 2.
// Attend the third event on day 3.

import java.util.Arrays;
import java.util.PriorityQueue;

public class July7__MaximumNumberOfEventsThatCanBeAttended {
    public static int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int max = 1;
        for (int[] e : events)
            max = Math.max(max, e[1]);
        int ans = 0;
        int j = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= max; i++) {
            while (j < n && events[j][0] <= i) {
                pq.offer(events[j][1]);
                j++;
            }
            while (!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] events = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
        System.out.println(maxEvents(events));
        // 3
    }
}

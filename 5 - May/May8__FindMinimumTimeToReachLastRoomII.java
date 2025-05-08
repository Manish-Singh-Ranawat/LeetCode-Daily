// Find Minimum Time to Reach Last Room II - https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii/description/?envType=daily-question&envId=2025-05-08

// There is a dungeon with n x m rooms arranged as a grid.

// You are given a 2D array moveTime of size n x m, where moveTime[i][j] represents the minimum time in seconds when you can start moving to that room. You start from the room (0, 0) at time t = 0 and can move to an adjacent room. Moving between adjacent rooms takes one second for one move and two seconds for the next, alternating between the two.

// Return the minimum time to reach the room (n - 1, m - 1).

// Two rooms are adjacent if they share a common wall, either horizontally or vertically.

// Input: moveTime = [[0,4],[4,4]]
// Output: 7
// Explanation: The minimum time required is 7 seconds.
// At time t == 4, move from room (0, 0) to room (1, 0) in one second.
// At time t == 5, move from room (1, 0) to room (1, 1) in two seconds.

import java.util.Arrays;
import java.util.PriorityQueue;

public class May8__FindMinimumTimeToReachLastRoomII {
    public static int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;
        pq.offer(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[1];
            int y = cur[2];
            if (visited[x][y])
                continue;
            visited[x][y] = true;
            if (x == n - 1 && y == m - 1) {
                return dist[x][y];
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                int d = Math.max(dist[x][y], moveTime[nx][ny]) + (x + y) % 2 + 1;
                if (d < dist[nx][ny]) {
                    dist[nx][ny] = d;
                    pq.offer(new int[] { d, nx, ny });
                }
            }
        }
        return dist[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] moveTime = { { 0, 4 }, { 4, 4 } };
        System.out.println(minTimeToReach(moveTime));
        // 7
    }
}

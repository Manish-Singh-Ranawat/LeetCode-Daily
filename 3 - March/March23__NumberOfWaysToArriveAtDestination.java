// Number of Ways to Arrive at Destination - https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/

// You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

// You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

// Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.

// Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
// Output: 4
// Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
// The four ways to get there in 7 minutes are:
// - 0 ➝ 6
// - 0 ➝ 4 ➝ 6
// - 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
// - 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class March23__NumberOfWaysToArriveAtDestination {
    public static int countPaths(int n, int[][] roads) {
        int mod = (int) (1e9 + 7);
        ArrayList<ArrayList<Pair>> adj = getAdjacencyList(n, roads);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.first, b.first));
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            long curDist = cur.first;
            int node = cur.second;
            for (Pair it : adj.get(node)) {
                int adjNode = (int) it.first;
                long wt = it.second;
                if (curDist + wt < dist[adjNode]) {
                    dist[adjNode] = curDist + wt;
                    ways[adjNode] = ways[node];
                    pq.offer(new Pair(dist[adjNode], adjNode));
                } else if (curDist + wt == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }

    private static ArrayList<ArrayList<Pair>> getAdjacencyList(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] it : roads) {
            int u = it[0];
            int v = it[1];
            int wt = it[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        return adj;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 }, { 3, 5, 1 }, { 6, 5, 1 }, { 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };
        System.out.println(countPaths(n, roads));
        // 4
    }
}

class Pair {
    long first;
    int second;

    Pair(long first, int second) {
        this.first = first;
        this.second = second;
    }
}
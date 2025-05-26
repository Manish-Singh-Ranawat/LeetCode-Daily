// Largest Color Value in a Directed Graph - https://leetcode.com/problems/largest-color-value-in-a-directed-graph/?envType=daily-question&envId=2025-05-26

// There is a directed graph of n colored nodes and m edges. The nodes are numbered from 0 to n - 1.

// You are given a string colors where colors[i] is a lowercase English letter representing the color of the ith node in this graph (0-indexed). You are also given a 2D array edges where edges[j] = [aj, bj] indicates that there is a directed edge from node aj to node bj.

// A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that there is a directed edge from xi to xi+1 for every 1 <= i < k. The color value of the path is the number of nodes that are colored the most frequently occurring color along that path.

// Return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.

// Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
// Output: 3
// Explanation: The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored "a".

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class May26__LargestColorValueInDirectedGraph {
    public static int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        int[][] dp = new int[n][26];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.add(i);
            int colorIdx = colors.charAt(i) - 'a';
            dp[i][colorIdx] = 1;
        }
        int visited = 0;
        int maxColorValue = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            visited++;
            for (int neighbor : adj.get(node)) {
                for (int c = 0; c < 26; c++) {
                    int increment = (colors.charAt(neighbor) - 'a' == c) ? 1 : 0;
                    dp[neighbor][c] = Math.max(dp[neighbor][c], dp[node][c] + increment);
                }
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    q.add(neighbor);
            }
            for (int val : dp[node])
                maxColorValue = Math.max(maxColorValue, val);
        }
        return visited == n ? maxColorValue : -1;
    }

    public static void main(String[] args) {
        String colors = "abaca";
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 3, 4 } };
        System.out.println(largestPathValue(colors, edges));
        // 3
    }
}

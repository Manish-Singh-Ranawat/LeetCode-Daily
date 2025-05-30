// Find Closest Node to Given Two Nodes - https://leetcode.com/problems/find-closest-node-to-given-two-nodes/?envType=daily-question&envId=2025-05-30

// You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.

// The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from node i to node edges[i]. If there is no outgoing edge from i, then edges[i] == -1.

// You are also given two integers node1 and node2.

// Return the index of the node that can be reached from both node1 and node2, such that the maximum between the distance from node1 to that node, and from node2 to that node is minimized. If there are multiple answers, return the node with the smallest index, and if no possible answer exists, return -1.

// Note that edges may contain cycles.

// Input: edges = [2,2,3,-1], node1 = 0, node2 = 1
// Output: 2
// Explanation: The distance from node 0 to node 2 is 1, and the distance from node 1 to node 2 is 1.
// The maximum of those two distances is 1. It can be proven that we cannot get a node with a smaller maximum distance than 1, so we return node 2.

import java.util.Arrays;

public class May30__FindClosestNodeToGivenTwoNodes {
    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[node1] = 0;
        dist2[node2] = 0;
        dfs(node1, edges, new boolean[n], dist1);
        dfs(node2, edges, new boolean[n], dist2);
        int minDist = Integer.MAX_VALUE;
        int node = -1;
        for (int i = 0; i < n; i++) {
            int d = Math.max(dist1[i], dist2[i]);
            if (d < minDist) {
                minDist = d;
                node = i;
            }
        }
        return node;
    }

    private static void dfs(int node, int[] edges, boolean[] visited, int[] dist) {
        visited[node] = true;
        int adjNode = edges[node];
        if (adjNode != -1 && !visited[adjNode]) {
            dist[adjNode] = 1 + dist[node];
            dfs(adjNode, edges, visited, dist);
        }
    }

    public static void main(String[] args) {
        int[] edges = { 2, 2, 3, -1 };
        int node1 = 0;
        int node2 = 1;
        System.out.println(closestMeetingNode(edges, node1, node2));
        // 2
    }
}

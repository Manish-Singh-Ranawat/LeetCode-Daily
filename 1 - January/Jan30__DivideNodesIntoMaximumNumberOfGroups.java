// Divide Nodes Into the Maximum Number of Groups - https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/description/?envType=daily-question&envId=2025-01-30

// You are given a positive integer n representing the number of nodes in an undirected graph. The nodes are labeled from 1 to n.

// You are also given a 2D integer array edges, where edges[i] = [ai, bi] indicates that there is a bidirectional edge between nodes ai and bi. Notice that the given graph may be disconnected.

// Divide the nodes of the graph into m groups (1-indexed) such that:

// Each node in the graph belongs to exactly one group.
// For every pair of nodes in the graph that are connected by an edge [ai, bi], if ai belongs to the group with index x, and bi belongs to the group with index y, then |y - x| = 1.
// Return the maximum number of groups (i.e., maximum m) into which you can divide the nodes. Return -1 if it is impossible to group the nodes with the given conditions.

// Input: n = 6, edges = [[1,2],[1,4],[1,5],[2,6],[2,3],[4,6]]
// Output: 4
// Explanation: 
// - Add node 5 to the first group.
// - Add node 1 to the second group.
// - Add nodes 2 and 4 to the third group.
// - Add nodes 3 and 6 to the fourth group.
// We can see that every edge is satisfied.
// It can be shown that that if we create a fifth group and move any node from the third or fourth group to it, at least on of the edges will not be satisfied.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Jan30__DivideNodesIntoMaximumNumberOfGroups {
    public static int magnificentSets(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = getAdjacencyList(n, edges);
        boolean[] visited = new boolean[n + 1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int maxCount = 0;
            if (!visited[i]) {
                ArrayList<Integer> connectedComponents = getConnectedComponents(i, adj, visited);
                for (int it : connectedComponents) {
                    int len = longestLength(it, adj);
                    if (len == -1)
                        return -1;
                    maxCount = Math.max(maxCount, len);
                }
            }
            res += maxCount;
        }
        return res;
    }

    public static ArrayList<Integer> getConnectedComponents(int src, ArrayList<ArrayList<Integer>> adj,
            boolean[] visited) {
        ArrayList<Integer> components = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            components.add(node);
            for (int adjNode : adj.get(node)) {
                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    q.offer(adjNode);
                }
            }
        }
        return components;
    }

    public static int longestLength(int src, ArrayList<ArrayList<Integer>> adj) {
        int maxLen = 0;
        Queue<int[]> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        q.offer(new int[] { src, 1 });
        map.put(src, 1);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int len = cur[1];
            for (int adjNode : adj.get(node)) {
                if (!map.containsKey(adjNode)) {
                    map.put(adjNode, len + 1);
                    q.offer(new int[] { adjNode, len + 1 });
                } else {
                    if (len == map.get(adjNode))
                        return -1;
                }
            }
        }
        for (Integer value : map.values()) {
            maxLen = Math.max(maxLen, value);
        }
        return maxLen;
    }

    public static ArrayList<ArrayList<Integer>> getAdjacencyList(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = { { 1, 2 }, { 1, 4 }, { 1, 5 }, { 2, 6 }, { 2, 3 }, { 4, 6 } };
        System.out.println(magnificentSets(n, edges));
        // 4
    }
}

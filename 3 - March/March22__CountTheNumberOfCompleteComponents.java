// Count the Number of Complete Components - https://leetcode.com/problems/count-the-number-of-complete-components/description/?envType=daily-question&envId=2025-03-22

// You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.

// Return the number of complete connected components of the graph.

// A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

// A connected component is said to be complete if there exists an edge between every pair of its vertices.

// Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
// Output: 3
// Explanation: From the picture above, one can see that all of the components of this graph are complete.

import java.util.ArrayList;
import java.util.List;

public class March22__CountTheNumberOfCompleteComponents {
    public static int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] info = new int[2];
                dfs(i, visited, adj, info);
                int v = info[0];
                int e = info[1];
                if (v * (v - 1) == e)
                    count++;
            }
        }
        return count;
    }

    private static void dfs(int node, boolean[] visited, List<List<Integer>> adj, int[] info) {
        visited[node] = true;
        info[0]++;
        info[1] += adj.get(node).size();
        for (int adjNode : adj.get(node)) {
            if (!visited[adjNode]) {
                dfs(adjNode, visited, adj, info);
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 } };
        System.out.println(countCompleteComponents(n, edges));
        // 3
    }
}

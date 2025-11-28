// Maximum Number of K-Divisible Components - https://leetcode.com/problems/maximum-number-of-k-divisible-components/description/?envType=daily-question&envId=2025-11-28

// There is an undirected tree with n nodes labeled from 0 to n - 1. You are given the integer n and a 2D integer array edges of length n - 1, where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

// You are also given a 0-indexed integer array values of length n, where values[i] is the value associated with the ith node, and an integer k.

// A valid split of the tree is obtained by removing any set of edges, possibly empty, from the tree such that the resulting components all have values that are divisible by k, where the value of a connected component is the sum of the values of its nodes.

// Return the maximum number of components in any valid split.

// Input: n = 5, edges = [[0,2],[1,2],[1,3],[2,4]], values = [1,8,1,4,4], k = 6
// Output: 2
// Explanation: We remove the edge connecting node 1 with 2. The resulting split is valid because:
// - The value of the component containing nodes 1 and 3 is values[1] + values[3] = 12.
// - The value of the component containing nodes 0, 2, and 4 is values[0] + values[2] + values[4] = 6.
// It can be shown that no other valid split has more than 2 connected components.

import java.util.ArrayList;
import java.util.List;

public class Nov28__MaximumNumberOfKDivisibleComponents {
    public static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) 
            adjList.add(new ArrayList<>());
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        int[] componentCount = new int[1];
        dfs(0, -1, adjList, values, k, componentCount);
        return componentCount[0];
    }

    private static int dfs(int current, int parent, List<List<Integer>> adj, int[] values, int k, int[] comp) {
        int sum = 0;
        for (int next : adj.get(current)) {
            if (next != parent) {
                sum += dfs(next, current, adj, values, k, comp);
                sum %= k;
            }
        }
        sum = (sum + values[current]) % k;
        if (sum == 0)
            comp[0]++;
        return sum;
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 6;
        int[][] edges = { { 0, 2 }, { 1, 2 }, { 1, 3 }, { 2, 4 } };
        int[] values = { 1, 8, 1, 4, 4 };
        System.out.println(maxKDivisibleComponents(n, edges, values, k));
        // 2
    }
}

// Minimum Cost Walk in Weighted Graph - https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph/description/?envType=daily-question&envId=2025-03-20

// There is an undirected weighted graph with n vertices labeled from 0 to n - 1.

// You are given the integer n and an array edges, where edges[i] = [ui, vi, wi] indicates that there is an edge between vertices ui and vi with a weight of wi.

// A walk on a graph is a sequence of vertices and edges. The walk starts and ends with a vertex, and each edge connects the vertex that comes before it and the vertex that comes after it. It's important to note that a walk may visit the same edge or vertex more than once.

// The cost of a walk starting at node u and ending at node v is defined as the bitwise AND of the weights of the edges traversed during the walk. In other words, if the sequence of edge weights encountered during the walk is w0, w1, w2, ..., wk, then the cost is calculated as w0 & w1 & w2 & ... & wk, where & denotes the bitwise AND operator.

// You are also given a 2D array query, where query[i] = [si, ti]. For each query, you need to find the minimum cost of the walk starting at vertex si and ending at vertex ti. If there exists no such walk, the answer is -1.

// Return the array answer, where answer[i] denotes the minimum cost of a walk for query i.

// Input: n = 5, edges = [[0,1,7],[1,3,7],[1,2,1]], query = [[0,3],[3,4]]
// Output: [1,-1]
// Explanation: To achieve the cost of 1 in the first query, we need to move on the following edges: 0->1 (weight 7), 1->2 (weight 1), 2->1 (weight 1), 1->3 (weight 7).
// In the second query, there is no walk between nodes 3 and 4, so the answer is -1.

import java.util.Arrays;
import java.util.HashMap;

public class March20__MinimumCostWalkInWeightedGraph {
    public static int[] minimumCost(int n, int[][] edges, int[][] query) {
        DisjointSet ds = new DisjointSet(n);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] e : edges) {
            ds.unionBySize(e[0], e[1]);
        }
        for (int[] e : edges) {
            int root = ds.findParent(e[0]);
            int w = e[2];
            map.put(root, map.getOrDefault(root, w) & w);
        }
        int q = query.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int start = query[i][0];
            int end = query[i][1];
            int startRoot = ds.findParent(start);
            int endRoot = ds.findParent(end);
            if (startRoot == endRoot) {
                ans[i] = map.get(startRoot);
            } else
                ans[i] = -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { { 0, 1, 7 }, { 1, 3, 7 }, { 1, 2, 1 } };
        int[][] query = { { 0, 3 }, { 3, 4 } };
        System.out.println(Arrays.toString(minimumCost(n, edges, query)));
        // [1, -1]
    }
}

class DisjointSet {
    public int[] rank;
    public int[] size;
    public int[] parent;

    DisjointSet(int n) {
        this.rank = new int[n + 1];
        this.size = new int[n + 1];
        this.parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            rank[i] = 0;
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    public boolean unionByRank(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv)
            return false;
        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pv] < rank[pu]) {
            parent[pv] = pu;
        } else {
            parent[pu] = pv;
            rank[pv]++;
        }
        return true;
    }

    public boolean unionBySize(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv)
            return false;
        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        return true;
    }
}
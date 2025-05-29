// Maximize the Number of Target Nodes After Connecting Trees II - https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii/?envType=daily-question&envId=2025-05-29

// There exist two undirected trees with n and m nodes, labeled from [0, n - 1] and [0, m - 1], respectively.

// You are given two 2D integer arrays edges1 and edges2 of lengths n - 1 and m - 1, respectively, where edges1[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the first tree and edges2[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the second tree.

// Node u is target to node v if the number of edges on the path from u to v is even. Note that a node is always target to itself.

// Return an array of n integers answer, where answer[i] is the maximum possible number of nodes that are target to node i of the first tree if you had to connect one node from the first tree to another node in the second tree.

// Note that queries are independent from each other. That is, for every query you will remove the added edge before proceeding to the next query.

// Input: edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]]
// Output: [8,7,7,8,8]
// Explanation:
// For i = 0, connect node 0 from the first tree to node 0 from the second tree.
// For i = 1, connect node 1 from the first tree to node 4 from the second tree.
// For i = 2, connect node 2 from the first tree to node 7 from the second tree.
// For i = 3, connect node 3 from the first tree to node 0 from the second tree.
// For i = 4, connect node 4 from the first tree to node 4 from the second tree.

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class May29__MaximizeTheNumberOfTargetNodesAfterConnectingTreesII {
    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        List<List<Integer>> adj1 = adjacencyList(n, edges1);
        List<List<Integer>> adj2 = adjacencyList(m, edges2);
        int[] color1 = new int[n];
        int[] color2 = new int[m];
        int white1 = bfs(0, -1, color1, adj1);
        int black1 = n - white1;
        int white2 = bfs(0, -1, color2, adj2);
        int black2 = m - white2;
        int max = Math.max(white2, black2);
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = (color1[i] == 0 ? white1 : black1) + max;
        return res;
    }

    private static int bfs(int node, int parent, int[] color, List<List<Integer>> adj) {
        int white = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { node, parent, 0 });
        color[0] = 0;
        while (!q.isEmpty()) {
            int n = q.peek()[0];
            int p = q.peek()[1];
            int c = q.peek()[2];
            q.poll();
            color[n] = c;
            if (c == 0)
                white++;
            for (int adjNode : adj.get(n)) {
                if (adjNode != p) {
                    q.offer(new int[] { adjNode, n, 1 - c });
                }
            }
        }
        return white;
    }

    private static List<List<Integer>> adjacencyList(int v, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }

    public static void main(String[] args) {
        int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 } };
        int[][] edges2 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 7 }, { 1, 4 }, { 4, 5 }, { 4, 6 } };
        System.out.println(Arrays.toString(maxTargetNodes(edges1, edges2)));
        // [8,7,7,8,8]
    }
}

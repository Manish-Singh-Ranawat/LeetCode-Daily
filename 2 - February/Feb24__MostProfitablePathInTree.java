// Most Profitable Path in a Tree - https://leetcode.com/problems/most-profitable-path-in-a-tree/?envType=daily-question&envId=2025-02-24

// There is an undirected tree with n nodes labeled from 0 to n - 1, rooted at node 0. You are given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

// At every node i, there is a gate. You are also given an array of even integers amount, where amount[i] represents :
// - the price needed to open the gate at node i, if amount[i] is negative, or,
// - the cash reward obtained on opening the gate at node i, otherwise.

// The game goes on as follows:
// Initially, Alice is at node 0 and Bob is at node bob.
// At every second, Alice and Bob each move to an adjacent node. Alice moves towards some leaf node, while Bob moves towards node 0.
// For every node along their path, Alice and Bob either spend money to open the gate at that node, or accept the reward.

// Note that:
// If the gate is already open, no price will be required, nor will there be any cash reward.
// If Alice and Bob reach the node simultaneously, they share the price/reward for opening the gate there. In other words, if the price to open the gate is c, then both Alice and Bob pay c / 2 each. Similarly, if the reward at the gate is c, both of them receive c / 2 each.
// If Alice reaches a leaf node, she stops moving. Similarly, if Bob reaches node 0, he stops moving. Note that these events are independent of each other.

// Return the maximum net income Alice can have if she travels towards the optimal leaf node.

// Input: edges = [[0,1],[1,2],[1,3],[3,4]], bob = 3, amount = [-2,4,2,-4,6]
// Output: 6
// Explanation: 
// The above diagram represents the given tree. The game goes as follows:
// - Alice is initially on node 0, Bob on node 3. They open the gates of their respective nodes.
//   Alice's net income is now -2.
// - Both Alice and Bob move to node 1. 
//   Since they reach here simultaneously, they open the gate together and share the reward.
//   Alice's net income becomes -2 + (4 / 2) = 0.
// - Alice moves on to node 3. Since Bob already opened its gate, Alice's income remains unchanged.
//   Bob moves on to node 0, and stops moving.
// - Alice moves on to node 4 and opens the gate there. Her net income becomes 0 + 6 = 6.
// Now, neither Alice nor Bob can make any further moves, and the game ends.
// It is not possible for Alice to get a higher net income.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Feb24__MostProfitablePathInTree {
    public static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Map<Integer, Integer> bobPath = new HashMap<>();
        findBobPath(bob, -1, 0, adj, bobPath);
        return findAlicePath(0, -1, 0, amount, adj, bobPath);
    }

    private static boolean findBobPath(int node, int parent, int time, List<List<Integer>> adj,
            Map<Integer, Integer> bobPath) {
        bobPath.put(node, time);
        if (node == 0)
            return true;
        for (int neighbor : adj.get(node)) {
            if (neighbor == parent)
                continue;
            if (findBobPath(neighbor, node, time + 1, adj, bobPath)) {
                return true;
            }
        }
        bobPath.remove(node);
        return false;
    }

    private static int findAlicePath(int node, int parent, int time, int[] amount, List<List<Integer>> adj,
            Map<Integer, Integer> bobPath) {
        int bobTime = bobPath.getOrDefault(node, Integer.MAX_VALUE);
        int currentIncome = 0;
        if (time < bobTime) {
            currentIncome = amount[node];
        } else if (time == bobTime) {
            currentIncome = amount[node] / 2;
        }
        if (node != 0 && adj.get(node).size() == 1) {
            return currentIncome;
        }
        int maxProfit = 0;
        for (int neighbor : adj.get(node)) {
            if (neighbor == parent)
                continue;
            maxProfit = Math.max(maxProfit, findAlicePath(neighbor, node, time + 1, amount, adj, bobPath));
        }
        return currentIncome + maxProfit;
    }

    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 1, 3 }, { 3, 4 } };
        int bob = 3;
        int[] amount = { -2, 4, 2, -4, 6 };
        System.out.println(mostProfitablePath(edges, bob, amount));
        // 6
    }
}

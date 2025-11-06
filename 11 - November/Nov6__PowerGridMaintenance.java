// Power Grid Maintenance - https://leetcode.com/problems/power-grid-maintenance/description/?envType=daily-question&envId=2025-11-06

// You are given an integer c representing c power stations, each with a unique identifier id from 1 to c (1‑based indexing).

// These stations are interconnected via n bidirectional cables, represented by a 2D array connections, where each element connections[i] = [ui, vi] indicates a connection between station ui and station vi. Stations that are directly or indirectly connected form a power grid.

// Initially, all stations are online (operational).

// You are also given a 2D array queries, where each query is one of the following two types:
// - [1, x]: A maintenance check is requested for station x. If station x is online, it resolves the check by itself. If station x is offline, the check is resolved by the operational station with the smallest id in the same power grid as x. If no operational station exists in that grid, return -1.
// - [2, x]: Station x goes offline (i.e., it becomes non-operational).

// Return an array of integers representing the results of each query of type [1, x] in the order they appear.

// Note: The power grid preserves its structure; an offline (non‑operational) node remains part of its grid and taking it offline does not alter connectivity.

// Input: c = 5, connections = [[1,2],[2,3],[3,4],[4,5]], queries = [[1,3],[2,1],[1,1],[2,2],[1,2]]
// Output: [3,2,3]
// Explanation:
// Initially, all stations {1, 2, 3, 4, 5} are online and form a single power grid.
// Query [1,3]: Station 3 is online, so the maintenance check is resolved by station 3.
// Query [2,1]: Station 1 goes offline. The remaining online stations are {2, 3, 4, 5}.
// Query [1,1]: Station 1 is offline, so the check is resolved by the operational station with the smallest id among {2, 3, 4, 5}, which is station 2.
// Query [2,2]: Station 2 goes offline. The remaining online stations are {3, 4, 5}.
// Query [1,2]: Station 2 is offline, so the check is resolved by the operational station with the smallest id among {3, 4, 5}, which is station 3.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class Nov6__PowerGridMaintenance {
    public static int[] processQueries(int c, int[][] connections, int[][] queries) {
        DisjointSet ds = new DisjointSet(c);
        for (int[] conn : connections)
            ds.unionBySize(conn[0], conn[1]);
        HashMap<Integer, PriorityQueue<Integer>> componentMap = new HashMap<>();
        HashSet<Integer> offline = new HashSet<>();
        for (int i = 1; i <= c; i++) {
            int parent = ds.findParent(i);
            componentMap
                    .computeIfAbsent(parent, k -> new PriorityQueue<>())
                    .add(i);
        }
        List<Integer> result = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0];
            int station = q[1];
            if (type == 2) {
                offline.add(station);
            } else {
                if (!offline.contains(station)) {
                    result.add(station);
                } else {
                    int parent = ds.findParent(station);
                    PriorityQueue<Integer> pq = componentMap.get(parent);
                    while (pq != null && !pq.isEmpty() && offline.contains(pq.peek())) {
                        pq.poll();
                    }
                    if (pq == null || pq.isEmpty()) {
                        result.add(-1);
                    } else {
                        result.add(pq.peek());
                    }
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int c = 5;
        int[][] connections = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
        int[][] queries = { { 1, 3 }, { 2, 1 }, { 1, 1 }, { 2, 2 }, { 1, 2 } };
        System.out.println(Arrays.toString(processQueries(c, connections, queries)));
        // [3, 2, 3]
    }
}

class DisjointSet {
    public int[] rank;
    public int[] size;
    public int[] parent;

    DisjointSet(int n) {
        rank = new int[n + 1];
        size = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            rank[i] = 0;
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findParent(int x) {
        if (x == parent[x])
            return x;
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
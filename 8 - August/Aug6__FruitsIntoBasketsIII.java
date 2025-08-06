// Fruits Into Baskets III - https://leetcode.com/problems/fruits-into-baskets-iii/description/?envType=daily-question&envId=2025-08-06

// You are given two arrays of integers, fruits and baskets, each of length n, where fruits[i] represents the quantity of the ith type of fruit, and baskets[j] represents the capacity of the jth basket.

// From left to right, place the fruits according to these rules:
// - Each fruit type must be placed in the leftmost available basket with a capacity greater than or equal to the quantity of that fruit type.
// - Each basket can hold only one type of fruit.
// - If a fruit type cannot be placed in any basket, it remains unplaced.

// Return the number of fruit types that remain unplaced after all possible allocations are made.

// Input: fruits = [4,2,5], baskets = [3,5,4]
// Output: 1
// Explanation:
// fruits[0] = 4 is placed in baskets[1] = 5.
// fruits[1] = 2 is placed in baskets[0] = 3.
// fruits[2] = 5 cannot be placed in baskets[2] = 4.
// Since one fruit type remains unplaced, we return 1.

import java.util.Arrays;

public class Aug6__FruitsIntoBasketsIII {
    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        SegmentTree st = new SegmentTree();
        st.baskets = baskets;
        int n = baskets.length;
        int unplacedFruits = 0;
        if (n == 0) {
            return fruits.length;
        }
        Arrays.fill(st.segmentTree, Integer.MIN_VALUE);
        st.buildSegmentTree(1, 0, n - 1);
        for (int fruitQty : fruits) {
            int left = 0, right = n - 1;
            int candidateIndex = -1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (st.queryMaxCapacity(1, 0, n - 1, 0, mid) >= fruitQty) {
                    candidateIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (candidateIndex != -1 && baskets[candidateIndex] >= fruitQty) {
                st.updateCapacity(1, 0, n - 1, candidateIndex, Integer.MIN_VALUE);
            } else {
                unplacedFruits++;
            }
        }
        return unplacedFruits;
    }

    public static void main(String[] args) {
        int[] fruits = { 4, 2, 5 };
        int[] baskets = { 3, 5, 4 };
        System.out.println(numOfUnplacedFruits(fruits, baskets));
        // 1
    }
}

class SegmentTree {
    public int[] segmentTree = new int[400007];
    public int[] baskets;

    public void buildSegmentTree(int node, int left, int right) {
        if (left == right) {
            segmentTree[node] = baskets[left];
            return;
        }
        int mid = (left + right) >> 1;
        buildSegmentTree(node << 1, left, mid);
        buildSegmentTree((node << 1) | 1, mid + 1, right);
        segmentTree[node] = Math.max(segmentTree[node << 1], segmentTree[(node << 1) | 1]);
    }

    public int queryMaxCapacity(int node, int left, int right, int queryLeft, int queryRight) {
        if (queryLeft > right || queryRight < left) {
            return Integer.MIN_VALUE;
        }
        if (queryLeft <= left && right <= queryRight) {
            return segmentTree[node];
        }
        int mid = (left + right) >> 1;
        return Math.max(
                queryMaxCapacity(node << 1, left, mid, queryLeft, queryRight),
                queryMaxCapacity((node << 1) | 1, mid + 1, right, queryLeft, queryRight));
    }

    public void updateCapacity(int node, int left, int right, int position, int newValue) {
        if (left == right) {
            segmentTree[node] = newValue;
            return;
        }
        int mid = (left + right) >> 1;
        if (position <= mid) {
            updateCapacity(node << 1, left, mid, position, newValue);
        } else {
            updateCapacity((node << 1) | 1, mid + 1, right, position, newValue);
        }
        segmentTree[node] = Math.max(segmentTree[node << 1], segmentTree[(node << 1) | 1]);
    }
}
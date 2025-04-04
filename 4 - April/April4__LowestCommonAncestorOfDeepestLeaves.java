// Lowest Common Ancestor of Deepest Leaves - https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/?envType=daily-question&envId=2025-04-04

// Given the root of a binary tree, return the lowest common ancestor of its deepest leaves.

// Recall that:
// - The node of a binary tree is a leaf if and only if it has no children
// - The depth of the root of the tree is 0. if the depth of a node is d, the depth of each of its children is d + 1.
// - The lowest common ancestor of a set S of nodes, is the node A with the largest depth such that every node in S is in the subtree with root A.

// Input: root = [3,5,1,6,2,0,8,null,null,7,4]
//         3
//       /    \
//     5       1
//   /  \    /  \
//  6    2  0    8
//      / \         
//     7   4
// Output: [2,7,4]
// Explanation: We return the node with value 2.
// The nodes 7 and 4 are the deepest leaf-nodes of the tree.
// Note that nodes 6, 0, and 8 are also leaf nodes, but the depth of them is 2, but the depth of nodes 7 and 4 is 3.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//  Definition for a binary tree node.
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static TreeNode createTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.offer(root);
        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    list.add(current.data);
                    queue.add(current.left);
                    queue.add(current.right);
                } else {
                    list.add(null);
                }
            }
            levelOrder.add(list);
        }
        levelOrder.removeLast();
        return levelOrder;
    }
}
// ----------------------

class Pair {
    TreeNode node;
    int depth;

    Pair(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

public class April4__LowestCommonAncestorOfDeepestLeaves {
    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair ans = dfs(root, 0);
        return ans.node;
    }

    private static Pair dfs(TreeNode root, int depth) {
        if (root == null) {
            return new Pair(null, depth);
        }
        Pair left = dfs(root.left, depth + 1);
        Pair right = dfs(root.right, depth + 1);
        if (left.depth > right.depth) {
            return left;
        }
        if (left.depth < right.depth) {
            return right;
        }
        return new Pair(root, left.depth);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(
            new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 });
        TreeNode ans = lcaDeepestLeaves(root);
        System.out.println(TreeNode.levelOrder(ans));
        // [[2], [7, 4]]
    }
}

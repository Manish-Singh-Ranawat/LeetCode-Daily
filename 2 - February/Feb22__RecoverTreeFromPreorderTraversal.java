// Recover a Tree From Preorder Traversal - https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/description/?envType=daily-question&envId=2025-02-22

// We run a preorder depth-first search (DFS) on the root of a binary tree.

// At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  If the depth of a node is D, the depth of its immediate child is D + 1.  The depth of the root node is 0.

// If a node has only one child, that child is guaranteed to be the left child.

// Given the output traversal of this traversal, recover the tree and return its root.

// Input: traversal = "1-2--3--4-5--6--7"
// Output: [1,2,5,3,4,6,7]
//         1
//       /   \
//      2      5
//    /  \   /  \
//   3    4  6   7

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//  Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
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
                    list.add(current.val);
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
// -----------------

public class Feb22__RecoverTreeFromPreorderTraversal {
    public static TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> st = new Stack<>();
        int i = 0;
        int n = traversal.length();
        while (i < n) {
            int depth = 0;
            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }
            int val = 0;
            while (i < n && traversal.charAt(i) != '-') {
                int digit = Character.getNumericValue(traversal.charAt(i));
                val = (val * 10 + digit);
                i++;
            }
            TreeNode node = new TreeNode(val);
            while (!st.isEmpty() && st.size() > depth)
                st.pop();
            if (!st.isEmpty()) {
                if (st.peek().left == null) {
                    st.peek().left = node;
                } else {
                    st.peek().right = node;
                }
            }
            st.push(node);
        }
        while (st.size() > 1) {
            st.pop();
        }
        return st.peek();
    }

    public static void main(String[] args) {
        String traversal = "1-2--3--4-5--6--7";
        TreeNode root = recoverFromPreorder(traversal);
        System.out.println(TreeNode.levelOrder(root));
        // [[1], [2, 5], [3, 4, 6, 7]]
    }
}

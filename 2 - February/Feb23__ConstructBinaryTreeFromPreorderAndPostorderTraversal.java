// Construct Binary Tree from Preorder and Postorder Traversal - https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/?envType=daily-question&envId=2025-02-23

// Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.

// If there exist multiple answers, you can return any of them.

// Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
// Output: [1,2,3,4,5,6,7]
//         1
//       /   \
//      2      3
//    /  \   /  \
//   4    5  6   7

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class Feb23__ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        HashMap<Integer, Integer> postMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            postMap.put(postorder[i], i);
        }
        return buildTree(preorder, 0, n - 1, postorder, 0, n - 1, postMap);
    }

    private static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart,
            int postEnd, HashMap<Integer, Integer> postMap) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return root;
        }
        int leftChildVal = preorder[preStart + 1];
        int leftChildIndex = postMap.get(leftChildVal);
        int leftSubtreeSize = leftChildIndex - postStart + 1;
        root.left = buildTree(preorder, preStart + 1, preStart + leftSubtreeSize, postorder, postStart, leftChildIndex,
                postMap);
        root.right = buildTree(preorder, preStart + leftSubtreeSize + 1, preEnd, postorder, leftChildIndex + 1,
                postEnd - 1, postMap);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = { 1, 2, 4, 5, 3, 6, 7 };
        int[] postorder = { 4, 5, 2, 6, 7, 3, 1 };
        TreeNode root = constructFromPrePost(preorder, postorder);
        System.out.println(TreeNode.levelOrder(root));
        // [[1], [2, 3], [4, 5, 6, 7]]
    }
}
// Find Elements in a Contaminated Binary Tree - https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/?envType=daily-question&envId=2025-02-21

// Given a binary tree with the following rules:
// root.val == 0

// For any treeNode:
// If treeNode.val has a value x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
// If treeNode.val has a value x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
// Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.

// Implement the FindElements class:
// FindElements(TreeNode* root) Initializes the object with a contaminated binary tree and recovers it.
// bool find(int target) Returns true if the target value exists in the recovered binary tree.

// Input :
// ["FindElements","find","find","find"]
// [[[-1,-1,-1,-1,-1]],[1],[3],[5]]

// Output : [null,true,true,false]

// Explanation :
// FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
// findElements.find(1); // return True
// findElements.find(3); // return True
// findElements.find(5); // return False

import java.util.HashSet;
import java.util.LinkedList;
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
}
// -----------------

class FindElements {
    HashSet<Integer> set;

    public FindElements(TreeNode root) {
        this.set = new HashSet<>();
        dfs(root, 0);
    }

    public boolean find(int target) {
        return set.contains(target);
    }

    private void dfs(TreeNode root, int val) {
        if (root == null)
            return;
        set.add(val);
        dfs(root.left, 2 * val + 1);
        dfs(root.right, 2 * val + 2);
    }
}

public class Feb21__FindElementsInContaminatedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[] { -1, -1, -1, -1, -1 });
        FindElements fe = new FindElements(root);
        System.out.println(fe.find(1)); // true
        System.out.println(fe.find(3)); // true
        System.out.println(fe.find(5)); // false
    }
}

// Delete Nodes From Linked List Present in Array - https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description/?envType=daily-question&envId=2025-11-01

// You are given an array of integers nums and the head of a linked list. Return the head of the modified linked list after removing all nodes from the linked list that have a value that exists in nums.

// Input: nums = [1], head = [1,2,1,2,1,2]
// Output: [2,2,2]

import java.util.HashSet;
import java.util.Set;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }

    public static ListNode constructLL(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < n; i++) {
            ListNode newNode = new ListNode(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }
        return head;
    }

    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("null \n");
    }
}

public class Nov1__DeleteNodesFromLinkedListPresentInArray {
    public static ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null) {
            if (set.contains(temp.next.val)) {
                temp.next = temp.next.next;
            } else
                temp = temp.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = { 1 };
        ListNode head = ListNode.constructLL(new int[] { 1, 2, 1, 2, 1, 2 });
        ListNode.print(modifiedList(nums, head));
        // [2,2,2]
    }
}

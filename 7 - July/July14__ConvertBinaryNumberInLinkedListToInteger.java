// Convert Binary Number in a Linked List to Integer - https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/?envType=daily-question&envId=2025-07-14

// Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

// Return the decimal value of the number in the linked list.

// The most significant bit is at the head of the linked list.

// Input: head = [1,0,1]
// Output: 5
// Explanation: (101) in base 2 = (5) in base 10

public class July14__ConvertBinaryNumberInLinkedListToInteger {
    public static int getDecimalValue(ListNode head) {
        int ans = head.val;
        while (head.next != null) {
            ans = (ans << 1) | head.next.val;
            head = head.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.constructLL(new int[] { 1, 0, 1 });
        System.out.println(getDecimalValue(head));
        // 5
    }
}

class ListNode {
    int val;
    ListNode next;

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
}

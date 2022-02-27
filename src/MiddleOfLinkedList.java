// Link: https://leetcode.com/problems/middle-of-the-linked-list/

// Tip: to find the middle, we need to be able to look ahead
// use fast and slow pointers to solve this problem

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        System.out.println("Middle Node: " + findMiddleNode(head).val);
        // must be 1
        // Edge case

        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Middle Node: " + findMiddleNode(head).val);
        // must be 3

        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Middle Node: " + findMiddleNode(head).val);
        // must be 4

        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println("Middle Node: " + findMiddleNode(head).val);
        // must be 4
    }

    // Time Complexity is O(n) - where n is the # of nodes
    // Space Complexity is O(1) - no additional space needed if input grows
    public static ListNode findMiddleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null) {
            if (fast.next.next == null) {
                return slow.next;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

// Link: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list

// Can be solved in two ways:

// 1. Two iterations over LL counting number of nodes in the first and identifying which one to remove
// 2. fast and slow pointers - need only one pass over the LL


public class DeleteMiddleNodeOfLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        deleteMiddleNodeFastAndSlow(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        // must be 1 -> 2 -> 4 -> 5 -> null
    }

    // Time complexity is O(n) - where n is the number of nodes
    // Space complexity is O(1) - no additional space if input grows
    public static ListNode deleteMiddleNodeFastAndSlow(ListNode head) {
        if (head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    // Time complexity is O(n) - although making two passes, overall it's O(n)
    // Space complexity is O(1) - no additional space if input grows
    public ListNode deleteMiddleNodeCnt(ListNode head) {
        if (head.next == null) return null;
        int nodeCnt = 0;
        ListNode pointer = head;

        while (pointer.next != null) {
            nodeCnt++;
            pointer = pointer.next;
        }

        int nodeToDelete = nodeCnt % 2 == 0 ? nodeCnt / 2 - 1 : nodeCnt / 2;

        pointer = head;

        while (nodeToDelete > 0) {
            pointer = pointer.next;
            nodeToDelete--;
        }

        pointer.next = pointer.next.next;

        return head;
    }
}

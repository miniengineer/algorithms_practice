//Given head, the head of a linked list, determine if the linked list has a cycle in it.
//
//    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
//    Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
//    Note that pos is not passed as a parameter.
//
//    Return true if there is a cycle in the linked list. Otherwise, return false.
//
//    Example 1:
//
//    Input: head = [3,2,0,-4], pos = 1
//    Output: true
//    Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
//
//    Example 2:
//
//    Input: head = [1,2], pos = 0
//    Output: true
//    Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
//
//    Example 3:
//
//    Input: head = [1], pos = -1
//    Output: false
//    Explanation: There is no cycle in the linked list.

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = head.next;

        System.out.println(hasCycle(head));
        // must be true
    }

    // Time complexity is O(n)
    // Space complexity is O(1) - cause we don't use extra space,
    //                            only two constant pointers
    public static boolean hasCycle(ListNode head) {
        // use two pointers that point to two consecutive nodes
        // if LL has a cycle, then at some point they will point to the same node
        // if LL doesn't have a cycle, then at some point the one that moves faster will hit null

        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        // there is no point to check if slow != null
        // because fast is one step ahead of slow
        // and if fast is not null, then slow is 100% not null
        while (fast != null && fast.next != null) {
            if (slow == fast) return true;

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}

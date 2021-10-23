//Given the head of a singly linked list, reverse the list, and return the reversed list.
//
//    Example 1:
//
//
//    Input: head = [1,2,3,4,5]
//    Output: [5,4,3,2,1]
//    Example 2:
//
//
//    Input: head = [1,2]
//    Output: [2,1]
//    Example 3:
//
//    Input: head = []
//    Output: []

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = reverseList(head);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
        // must be [5,4,3,2,1]
    }

    // iterative
    // Time complexity O(n)
    // Space complexity O(1)
    public static ListNode reverseList(ListNode head) {
        if (head == null) return head;

        // create new LL -> reversed
        // loop through head and reassign the head of reversed
        // once head is null
        // return the reversed

        ListNode reversed = new ListNode(head.val);
        head = head.next;

        while (head != null) {
            ListNode newHead = new ListNode(head.val, reversed);
            reversed = newHead;

            head = head.next;
        }

        return reversed;
    }

    // with two pointers
    //        1 -> 2 -> 3 -> 4 -> 5
    // null
    //  |     |
    // prev  curr
    //
    // null <- 1    2 -> 3 -> 4 -> 5
    //         |    |
    //       prev  curr

    // Time complexity O(n)
    // Space complexity O(1) - because we will always have constant number of pointers (two)
    public static ListNode reverseListWithTwoPointers(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            // remember the next node before reassigning
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

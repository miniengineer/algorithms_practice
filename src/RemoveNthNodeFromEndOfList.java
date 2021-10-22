//Given the head of a linked list, remove the nth node from the end of the list and return its head.
//
//    Example 1:
//
//
//    Input: head = [1,2,3,4,5], n = 2
//    Output: [1,2,3,5]
//    Example 2:
//
//    Input: head = [1], n = 1
//    Output: []
//    Example 3:
//
//    Input: head = [1,2], n = 1
//    Output: [1]

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = removeNthNode(head, 2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
        // must be [1,2,3,5]
    }

    // Time complexity is O(n) - because of two pointers
    // Space complexity is O(1) - constant because no matter how long is LL
    //                            we will still initialize only three pointers
    public static ListNode removeNthNode(ListNode head, int n) {
        // create left and right pointers
        // where right is shifted n-steps from left
        // when right hits the end of LL (null)
        // it means that our left pointer points to the node 2 steps from the end

        // create dummy so that left points to dummy
        // when right hits null, left will be pointing to the node
        // next of which is the node we need to remove
        ListNode dummy = new ListNode(0, head);

        ListNode left = dummy;
        ListNode right = head;

        // reassign right pointer to be n steps from left pointer
        while (n > 0) {
            right = right.next;
            n--;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        // right pointer points to null
        // remove the node
        left.next = left.next.next;

        // important to return the updated list
        return dummy.next;
    }
}

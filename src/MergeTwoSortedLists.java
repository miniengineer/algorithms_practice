//Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
//
//    Example 1:
//
//
//    Input: l1 = [1,2,4], l2 = [1,3,4]
//    Output: [1,1,2,3,4,4]
//    Example 2:
//
//    Input: l1 = [], l2 = []
//    Output: []
//    Example 3:
//
//    Input: l1 = [], l2 = [0]
//    Output: [0]

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(l1, l2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
        // must be [1,1,2,3,4,4]
    }

    // Time complexity is O(l1 + l2) - because exactly one of l1 and l2 is incremented on each loop iteration,
    //                                 the while loop runs for a number of iterations equal to the sum of the lengths
    //                                 of the two lists.
    // Space complexity is O(1)
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedList = new ListNode(0);
        ListNode p = mergedList;

        while (l1 != null && l2 != null) {
            ListNode newNode = new ListNode();

            if (l1.val < l2.val) {
                newNode.val = l1.val;
                l1 = l1.next;
            } else {
                newNode.val = l2.val;
                l2 = l2.next;
            }

            p.next = newNode;
            p = newNode;
        }


        if (l1 == null) {
            p.next = l2;
        }

        if (l2 == null) {
            p.next = l1;
        }

        return mergedList.next;
    }
}

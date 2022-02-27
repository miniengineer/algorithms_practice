// Link: https://leetcode.com/problems/linked-list-cycle-ii/

// This could be solve using a HashSet, but there's also a constant space solution
// Idea is based on the logic from LinkedList cycle. Once cycle was found, we calculate
// length of the cycle and iterate through LL again, but this time fast pointer's position
// is ahead of slow by # of cycle nodes. With this start, it's guaranteed that moving slow
// and fast pointer by one step will make them meet at the cycle start

// Cycle start in the context of this problem is where the tail of LL is pointing to
// not the tail itself!


public class StartOfLinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).val);
        // must be 3

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).val);
        // must be 4

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).val);
        // must be 1
    }

    // Time Complexity is O(n) - number of operations depends on the # of nodes (n) in LL
    // Space Complexity is O(1) - won't need any additional space if input grows
    public static ListNode findCycleStart(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head.next;
        int cycleLength = 0;

        while (fast.next != null && fast.next.next != null) {
            if (slow == fast) {
                cycleLength = lengthOfLinkedListCycle(slow);
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        // no cycle was detected
        if (cycleLength == 0) return null;

        slow = head;
        fast = head;

        // move fast pointer into its new position
        while (cycleLength > 0) {
            fast = fast.next;
            cycleLength--;
        }

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static int lengthOfLinkedListCycle(ListNode slow) {
        ListNode curr = slow.next;
        int length = 1;
        while (curr != slow) {
            curr = curr.next;
            length++;
        }

        return length;
    }
}

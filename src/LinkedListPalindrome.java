public class LinkedListPalindrome {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println("Is palindrome: " + isPalindrome(head));
        // must be true

        ListNode headTwo = new ListNode(2);
        headTwo.next = new ListNode(4);
        headTwo.next.next = new ListNode(6);
        headTwo.next.next.next = new ListNode(3);
        headTwo.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindrome(headTwo));
        // must be false
    }

    // Time Complexity is O(n) - we're only traversing input LL
    // Space Complexity is O(1) - no additional space necessary if input LL grows
    public static boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;

        ListNode middleNode = findMiddleNode(head);
        ListNode secondHalfHead = reverse(middleNode);
        ListNode copyOfSecondHalfHead = secondHalfHead;

        // once the second half was reversed
        // they will meet at the middle node which now points to null
        while (head != null && secondHalfHead != null) {
            if (head.val != secondHalfHead.val) {
                break; // not a palindrome
            }

            head = head.next;
            secondHalfHead = secondHalfHead.next;
        }

        reverse(copyOfSecondHalfHead);

        // previous loop ended at the middle node that points to null
        // loop didn't break somewhere in the middle == all values were the same
        // it's a valid palindrome

        // using OR operator in case of even nodes LL
        if (head == null || secondHalfHead == null) {
            return true;
        }

        return false;
    }

    public static ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null) {
            if (fast.next.next == null) return slow.next;
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;

        // once head is null == we reached the end of LL
        // no more list node pointers to reassign
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}

// Link: https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/

//    A critical point in a linked list is defined as either a local maxima or a local minima.
//
//    A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.
//
//    A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.
//
//    Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.
//
//    Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] where minDistance is the minimum distance between any two distinct critical points and maxDistance is the maximum distance between any two distinct critical points. If there are fewer than two critical points, return [-1, -1].
//
//
//
//    Example 1:
//
//
//    Input: head = [3,1]
//    Output: [-1,-1]
//    Explanation: There are no critical points in [3,1].
//    Example 2:
//
//
//    Input: head = [5,3,1,2,5,1,2]
//    Output: [1,3]
//    Explanation: There are three critical points:
//    - [5,3,1,2,5,1,2]: The third node is a local minima because 1 is less than 3 and 2.
//    - [5,3,1,2,5,1,2]: The fifth node is a local maxima because 5 is greater than 2 and 1.
//    - [5,3,1,2,5,1,2]: The sixth node is a local minima because 1 is less than 5 and 2.
//    The minimum distance is between the fifth and the sixth node. minDistance = 6 - 5 = 1.
//    The maximum distance is between the third and the sixth node. maxDistance = 6 - 3 = 3.

import java.util.Arrays;

public class FindMinAndMaxNumOfNodesBetweenCriticalPoints {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(2);

        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(head)));
        // must be [1,3]
    }

    // Time Complexity is O(n) - where n is the # of nodes
    // Space Complexity is O(1)
    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        // in case there are less than 2 critical points => [-1, -1]
        // in case there are only two critical points => minDistance == maxDistance

        int[] noCriticalPoint = { -1, -1 };

        if (head.next == null || head.next.next == null) return noCriticalPoint;

        // keep track of the node we're currently at
        int currNodeIndex = 2;
        int prevNodeVal = head.val;
        Integer minDist = Integer.MAX_VALUE;

        ListNode currNode = head.next;
        int prevCriticalPointIndex = 0;
        int firstCriticalPointIndex = 0;

        // loop until there is no next node to compare
        while (currNode.next != null) {
            boolean localMinima = currNode.val < prevNodeVal && currNode.val < currNode.next.val;
            boolean localMaxima = currNode.val > prevNodeVal && currNode.val > currNode.next.val;

            if (localMinima || localMaxima) {
                if (prevCriticalPointIndex != 0) {
                    minDist = Math.min(minDist, currNodeIndex - prevCriticalPointIndex);
                } else {
                    firstCriticalPointIndex = currNodeIndex;
                }
                prevCriticalPointIndex = currNodeIndex;
            }

            prevNodeVal = currNode.val;
            currNode = currNode.next;
            currNodeIndex++;
        }


        // there are only two critical points
        if (prevCriticalPointIndex == firstCriticalPointIndex) return noCriticalPoint;

        int maxDist = prevCriticalPointIndex - firstCriticalPointIndex;

        return new int[] { minDist, maxDist };
    }
}

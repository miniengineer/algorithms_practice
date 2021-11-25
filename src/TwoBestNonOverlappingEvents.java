//    Link: https://leetcode.com/problems/two-best-non-overlapping-events/

//    You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei]. The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei. You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.
//
//    Return this maximum sum.
//
//    Note that the start time and end time is inclusive: that is,
//    you cannot attend two events where one of them starts and the other ends at the same time.
//    More specifically, if you attend an event with end time t, the next event must start at or after t + 1.
//
//    Example 1:
//    Input: events = [[1,3,2],[4,5,2],[2,4,3]]
//    Output: 4
//    Explanation: Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.
//    Example 2:
//
//    Example 1 Diagram
//    Input: events = [[1,3,2],[4,5,2],[1,5,5]]
//    Output: 5
//    Explanation: Choose event 2 for a sum of 5.

import java.util.Arrays;

public class TwoBestNonOverlappingEvents {
    public static void main(String[] arg) {

    }

    // Brute-force implementation, O(n^2) time complexity
    public int maxTwoEvents(int[][] events) {
        // sort events by start time in descending order
        Arrays.sort(events, (int[] e1, int[] e2) -> Integer.compare(e1[0], e2[0]));

        for (int[] a : events) {
            System.out.println(Arrays.toString(a));
        }

        int maxAttendingValue = 0;
        int currMaxAttendingValue = 0;

        for (int i = 0; i < events.length; i++) {
            int[] currEvent = events[i];

            // check if attending only this event is good enough
            maxAttendingValue = Math.max(maxAttendingValue, currEvent[2]);

            for (int j = i + 1; j < events.length; j++) {
                int[] nextEvent = events[j];

                // reassign maxAttending value only if we can attend two events
                if (currEvent[1] < nextEvent[0]) {
                    currMaxAttendingValue = currEvent[2] + nextEvent[2];
                    maxAttendingValue = Math.max(currMaxAttendingValue, maxAttendingValue);
                }
            }

        }

        return maxAttendingValue;
    }
}

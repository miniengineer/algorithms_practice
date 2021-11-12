//Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
//
//
//    Example 1:
//
//    Input: intervals = [[0,30],[5,10],[15,20]]
//    Output: 2
//
//    Example 2:
//
//    Input: intervals = [[7,10],[2,4]]
//    Output: 1


import java.util.PriorityQueue;

public class MeetingRoomsTwo {
    public static void main(String[] args) {
        int[][] intervals = { {0,30},{5,10},{15,20} };

        System.out.println(minMeetingRooms(intervals));
        // must be 2
    }

    // Time complexity is O(n) - loops + O(log n) - adding to PQ = O(n)
    // Space complexity is O(n)
    public static int minMeetingRooms(int[][] intervals) {
        // start with one room
        int necessaryRooms = 0;
        PriorityQueue<Integer> startTimes = new PriorityQueue<>();
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        // sort meeting times by start time
        // don't actually need to sort, since using MinHeap
        // Arrays.sort(intervals, (int[] m1, int[] m2) -> m1[0] - m2[0]);

        // add start and end times to min heaps
        for (int[] meeting : intervals) {
            startTimes.add(meeting[0]);
            endTimes.add(meeting[1]);
        }

        while (!startTimes.isEmpty()) {
            if (startTimes.peek() < endTimes.peek()) {
                necessaryRooms++;
            } else {
                endTimes.poll();
            }

            startTimes.poll();
        }

        return necessaryRooms;
    }
}

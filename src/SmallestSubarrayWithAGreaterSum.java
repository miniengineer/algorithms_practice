// Given an array of positive numbers and a positive number ‘S,’
// find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
// Return 0 if no such subarray exists.

// Tip: use sliding window technique;

public class SmallestSubarrayWithAGreaterSum {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 2, 3, 2 };
        int S = 7;


        SmallestSubarrayWithAGreaterSum solution = new SmallestSubarrayWithAGreaterSum();
        System.out.println(solution.findMinSubArrayWithGreaterSum(arr, S));
        // must be 2
        // Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
    }

    // Time complexity is O(n) - outer loop runs once for each element in the array,
    //                           inner loop iterates over each item only once
    //                           so it's O(n+n) = O(2n) which is eventually O(n)

    // Space complexity is O(1) - since no additional space required
    public int findMinSubArrayWithGreaterSum(int[] arr, int S) {
        int minWindowSize = Integer.MAX_VALUE;
        int windowStart = 0;
        int windowSum = 0;

        for (int windowEnd = 0; windowEnd < arr.length - 1; windowEnd++) {
            windowSum += arr[windowEnd];

            while (windowSum >= S) {
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);

                // reduce window
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return minWindowSize == Integer.MAX_VALUE ? 0 : minWindowSize;
    }
}

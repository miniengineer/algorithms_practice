// Link: https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

// Given an array of positive integers arr and a number k.
// Return the maximum sum of a subarray of size k.

// Tip: use sliding window technique for optimal solution

public class MaxSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 1, 3, 2 };
        int k = 3;

        MaxSumSubarrayOfSizeK mSSOSK = new MaxSumSubarrayOfSizeK();
        System.out.println(mSSOSK.maximumSumSubarray(arr, k));
        // must be 9
        // Explanation: Subarray with maximum sum is [5, 1, 3]
    }

    // Time Complexity is O(n) - since we iterate over arr only once
    // Space Complexity is O(1) - since we don't create new variables
    public int maximumSumSubarray(int[] arr, int k) {
        int maxSum = 0;
        int windowStart = 0;
        int windowSum = 0;

        for (int windowEnd = 0; windowEnd < arr.length - 1; windowEnd++) {
            windowSum += arr[windowEnd];

            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);

                // slide the window to one step
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return maxSum;
    }
}

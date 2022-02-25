// Link: https://leetcode.com/problems/subarray-product-less-than-k/

// Tip: for this problem, we don't need to return list of subarrays, only the number
// use two pointers - start and end and account for cases when product is more or !!equal!! to target
// since product has to be strictly less than the target

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[] { 1, 1, 1 }, 1));
        // must be 0
        // product will always be == target

        System.out.println(numSubarrayProductLessThanK(new int[] { 1, 2, 3 }, 0));
        // must be 0
        // an edge case

        System.out.println(numSubarrayProductLessThanK(new int[] { 10,5,2,6 }, 100));
        // must be 8
        // Explanation: The 8 subarrays that have product less than 100 are:
        //    [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
        // Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
    }

    // Time Complexity is O(n) - since we're iterating through the array once.
    //                           The inner for loop is for moving a pointer, so doesn't count

    // Space Complexity is O(1) - no additional space is necessary is input grows
    public static int numSubarrayProductLessThanK(int[] arr, int target) {
        if (target == 0) return 0;

        int start = 0;
        double product = 1;
        int numOfSubarrays = 0;

        for (int end = 0; end < arr.length; end++) {
            product *= arr[end];

            while (product >= target && start < end) {
                product /= arr[start++];
            }

            // account for inputs like [1,1]
            // when product will always be >= target
            // but it will go out of the previous loop because
            // start become == end pointer
            if (product < target) {
                numOfSubarrays += end - start + 1;
            }
        }

        return numOfSubarrays;
    }
}

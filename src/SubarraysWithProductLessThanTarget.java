import java.util.*;

// Tip: this problem follows two pointers and sliding window pattern
// no need to sort the array!
// increase the window and at each point
// shrink - if product is larger or equal to sum
// add all contiguous sub arrays using a temp list

public class SubarraysWithProductLessThanTarget {
    public static void main(String[] args) {
        System.out.println(findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        // must be  [2], [5], [2, 5], [3], [5, 3], [10]
        // Explanation: There are six contiguous subarrays whose product is less than the target.

        System.out.println(findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
        // must be [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
        // Explanation: There are seven contiguous subarrays whose product is less than the target.
    }

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        int start = 0;
        // in case of integer overflow
        double product = 1;

        for (int end = 0; end < arr.length; end++) {
            product *= arr[end];

            // need to adjust left pointer and reduce the product
            // till we've reached the last element
            while (product >= target && start < arr.length) {
                product /= arr[start++];
            }

            List<Integer> temp = new LinkedList<>();
            for (int i = end; i >= start; i--) {
                temp.add(0, arr[i]);
                subarrays.add(new ArrayList<>(temp));
            }
        }

        return subarrays;
    }
}

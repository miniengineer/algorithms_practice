// Link: https://leetcode.com/problems/3sum-smaller/

// tip: sort the array, once sorted can apply the same strategy as PairWithTargetSum
// two pointers - start & end, move them depending on constraints

import java.util.Arrays;

public class ThreeSumSmaller {
    public static void main(String[] args) {
        int[] nums = { -1, 4, 2, 1, 3 };
        int target = 5;

        System.out.println(threeSumSmaller(nums, target));
        // must be 4
        // Explanation: There are four triplets whose sum is less than the target:
        //   [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
    }

    // Time Complexity is O(n^2) - sort will have O(n logn) complexity but overall it's n squared
    // Space Complexity is O(1) - no need for additional data structure
    public static int threeSumSmaller(int[] arr, int target) {
        if (arr.length < 2) return 0;

        Arrays.sort(arr);
        int count = 0;
        int start, end;

        for (int i = 0; i < arr.length - 2; i++) {
            start = i + 1;
            end = arr.length - 1;

            while (end > start) {
                int currSum = arr[i] + arr[start] + arr[end];

                if (currSum < target) {
                    // since sum with current end is less than target
                    // all the sums counted by decrementing end (choosing numbers less than current end)
                    // are also 100% less than the targetSum
                    count += end - start;

                    // by moving start we would definitely need to re-evaluate
                    start++;
                } else {
                    end--;
                }
            }

        }

        return count;
    }
}

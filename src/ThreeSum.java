// Link: https://leetcode.com/problems/3sum/

// The condition is to find unique triplets with a + b + c = 0

// Since set cannot contain duplicates, we need to sort the array
// This also lets us use two pointers - start and end as in PairWithTargetSum

// key to the solution is always make sure that a - first number in triplet is not the same as number before
// also once we found a unique triplet, we need to move one pointer to make sure that it's value is unique
// in this case we always make sure that at least two nums in the triplet are unique, so we don't have to worry
// about the third number

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = { -3, 0, 1, 2, -1, 1, -2 };

        System.out.println(threeSum(nums));
        // must be  [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
        // Explanation: There are four unique triplets whose sum is equal to zero.
    }

    // Time Complexity is O(n logn) + O(n^2) = overall O(n^2) - where n is the number of elements in array
    //                                         n logn is for sorting and n^2 is for nested loops
    // Space Complexity is O(n logn) - because of sorting, depends on the programming language, library
    //                                 in Java for primitive types it's gonna use dual pivot quicksort
    //                                 with Space complexity of O(n logn)
    //                                 In case of object, hybrid between mergeSort and quickSort called TimSort
    //                                 which takes linear space
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList();
        if (nums.length < 2) return triplets;

        // sort the array
        // it will help with avoiding duplicate triplets
        Arrays.sort(nums);
        int start, end;

        for (int i = 0; i < nums.length; i++) {
            // avoid duplicates in the same position
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            start = i + 1;
            end = nums.length - 1;

            while (end > start) {
                int threeSum = nums[i] + nums[start] + nums[end];
                if (threeSum > 0) {
                    end--;
                } else if (threeSum < 0) {
                    start++;
                } else {
                    triplets.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;

                    while (end > start && nums[start] == nums[start - 1]) {
                        start++;
                    }
                }
            }
        }


        return triplets;
    }
}

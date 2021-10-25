//Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= first < second <= numbers.length.
//
//    Return the indices of the two numbers, index1 and index2, as an integer array [index1, index2] of length 2.
//
//    The tests are generated such that there is exactly one solution. You may not use the same element twice.
//
//
//
//    Example 1:
//
//    Input: numbers = [2,7,11,15], target = 9
//    Output: [1,2]
//    Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

//    Example 2:
//
//    Input: numbers = [2,3,4], target = 6
//    Output: [1,3]
//    Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3.

//    Example 3:
//
//    Input: numbers = [-1,0], target = -1
//    Output: [1,2]
//    Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2.


import java.util.Arrays;

public class TwoSum2 {
    public static void main(String[] args) {
        int[] numbers = { 2, 7, 11, 15 };
        int target = 9;

        System.out.println(Arrays.toString(twoSum(numbers, target)));
        // must be [1,2]
        // because sum is 2 & 7 and index starts at 1
    }

    // Time complexity is O(n)
    // Space complexity is O(1)
    public static int[] twoSum(int[] numbers, int target) {
        // since array is sorted, we can use this to our advantage
        // after reaching a certain number on the right side of array
        // we're certain that the sum would be > target

        // create two pointers: low & high and move each one
        // depending on the current sum of numbers[low] + numbers[high]
        // if current sum is greater than target,
        // we need to move the high pointer to decrease one of the numbers
        // if current sum is less than target,
        // we need to move the low pointer to increase one of the numbers
        int low = 0;
        int high = numbers.length - 1;

        while (numbers[low] + numbers[high] != target) {
            if (numbers[low] + numbers[high] > target) {
                high--;
            } else {
                low++;
            }
        }

        return new int[] { low + 1, high + 1 };

//         // alternatively
//         while (low < high) {
//             int currSum = numbers[low] + numbers[high];

//             if (currSum > target) {
//                 high--;
//             } else if (currSum < target) {
//                 low++;
//             } else {
//                 return new int[] { low + 1, high + 1 };
//             }
//         }
    }
}

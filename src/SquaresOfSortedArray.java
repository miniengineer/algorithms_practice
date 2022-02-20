// Link: https://leetcode.com/problems/squares-of-a-sorted-array/

// key is to remember that array is sorted, BUT it can contain negative numbers
// and square of a negative number can result in a greater value that square of right side positive number

// create an empty array with the size of input array
// use two pointers - start & end and keep adding greater square number starting from end
// increment or decrement start and end respectively


import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] nums = { -4,-1,0,3,10 };

        System.out.println(Arrays.toString(sortedSquares(nums)));
        // must be [0,1,9,16,100]
        // Explanation: After squaring, the array becomes [16,1,0,9,100].
        // After sorting, it becomes [0,1,9,16,100].
    }

    // Time Complexity is O(n) - where n is the number of elements in array
    //                           iterate and traverse array once
    // Space Complexity is O(n) - need additional space for result array
    public static int[] sortedSquares(int[] nums) {
        if (nums.length < 2) return null;

        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[nums.length];

        for (int i = end; i >= 0; i--) {
            int startSquare = nums[start] * nums[start];
            int endSquare = nums[end] * nums[end];

            if (startSquare > endSquare) {
                result[i] = startSquare;
                start++;
            } else {
                result[i] = endSquare;
                end--;
            }
        }

        return result;
    }
}

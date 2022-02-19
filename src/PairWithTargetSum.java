// Brute force approach is two nested loops
// count sum by combining one element at a time with inner loops element

import java.util.Arrays;

public class PairWithTargetSum {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 9, 11 };
        int target = 11;

        System.out.println(Arrays.toString(search(arr, target)));
        // must be [0, 2]
        // Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
    }

    // Time Complexity is O(n) - where n is the number of elements in array
    //                           we're using two pointers so we'll traverse array only once
    // Space Complexity is O(1) - no additional storage necessary if array size changes
    public static int[] search(int[] arr, int targetSum) {
        int pointerOne = 0;
        int pointerTwo = arr.length - 1;

        while (pointerOne < pointerTwo) {
            int currSum = arr[pointerOne] + arr[pointerTwo];

            if (currSum == targetSum) {
                break;
            } else if (currSum < targetSum) {
                pointerOne++;
            } else {
                pointerTwo--;
            }
        }

        return new int[] { pointerOne, pointerTwo };
    }
}

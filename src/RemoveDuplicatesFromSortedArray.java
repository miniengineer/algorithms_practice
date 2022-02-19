// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/

// eg. arr = [1,2,3,3,3,6,9,9], start with pointer i pointing to the first element
// pointer j pointing to the next one

// key to the solution is to start moving ONLY one pointer - j once both i & j will point to duplicate nums
// if pointers point to different nums -> reassign element after i to element j, move both pointers

//    1 2 3 3 3 6 9 9      i + 1 = j
//    i j                  i++, j++
//
//    1 2 3 3 3 6 9 9      i + 1 = j
//      i j                i++, j++
//
//    both point to a same number
//    1 2 3 3 3 6 9 9
//        i j             j++
//
//    both point to a same number
//    1 2 3 3 3 6 9 9
//        i   j           j++
//
//    1 2 3 3 3 6 9 9     i + 1 = j
//        i     j         i++, j++
//
//    1 2 3 6 3 6 9 9    i + 1 = j
//          i     j      i++, j++
//
//    1 2 3 6 9 6 9 9    i + 1 = j
//            i     j    i++, j++
//
//    1 2 3 6 9 9 9 9    finish
//            i       j

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3, 3, 6, 9, 9 };

        System.out.println(remove(arr));
        // must be 5
        // Explanation: The first four elements after removing the duplicates will be [1, 2, 3, 6, 9].
    }

    // Time Complexity is O(n) - where n is the number of elements in the array
    //                           traversing array only once

    // Space Complexity is O(1) - no additional space is required
    public static int remove(int[] arr) {
        int i = 0;

        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                arr[i + 1] = arr[j];
                i++;
            }
        }

        return i + 1;
    }
}

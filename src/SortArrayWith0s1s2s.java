// Link: https://leetcode.com/problems/sort-colors/

// A.k.a Dutch National Flag problem, a.k.a. sort colors
// you can't use built-in sort ;) it must be solved in place and linear time

// key is to use three pointers: low, middle and high
// at each step we'll check items under middle pointer and swap or change other pointers accordingly


import java.util.Arrays;

public class SortArrayWith0s1s2s {
    public static void main(String[] args) {
        int[] arr = { 2,0,2,1,1,0 };
        int[] arr2 = { 2,0,1 };

        sortColors(arr);
        System.out.println(Arrays.toString(arr));
        // must be [0,0,1,1,2,2]

        sortColors(arr2);
        System.out.println(Arrays.toString(arr2));
        // must be [0,1,2]
    }

    // Time Complexity is O(n) - we're traversing the array only once
    // Space Complexity is O(1) - we're not using any additional space, sorting happens in place
    public static void sortColors(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                // 0 is not at it's place
                // it must be under low pointer, so swap and move
                swap(low, mid, arr);
                low++;
                mid++;
            } else if (arr[mid] == 2) {
                // 2 is not at it's place
                // it must be under high, so swap
                // and move only high, cause we don't know element of high
                // which we swapped with
                swap(high, mid, arr);
                high--;
            } else {
                // we have 1 under mid pointer
                // everything's good, keep on movin
                mid++;
            }
        }
    }

    public static void swap(int idxA, int idxB, int[] arr) {
        int temp = arr[idxA];
        arr[idxA] = arr[idxB];
        arr[idxB] = temp;
    }
}

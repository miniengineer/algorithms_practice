// Link: https://leetcode.com/problems/merge-sorted-array/

// Tip
// use three pointers to iterate over two arrays simultaneously
// to achieve O(arr1 + arr2) time complexity

// Array, Two(three) Pointers

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr1 = { 1,2,3,0,0,0 };
        int[] arr2 = { 2,5,6 };
        int m = 3;
        int n = 3;

        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(arr1, arr2, m, n);
        // must be [1,2,2,3,5,6]
    }

    public void merge(int[] nums1, int[] nums2, int m, int n) {
        int pointer = m + n - 1;
        int i = m - 1; // -1
        int j = n - 1; // 0

        while (pointer >= 0) {
            // iterated over the whole nums2 array
            if (j < 0) break;

            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[pointer] = nums1[i];
                i--;
            } else {
                nums1[pointer] = nums2[j];
                j--;
            }

            pointer--;
        }

        System.out.println(Arrays.toString(nums1));
    }
}

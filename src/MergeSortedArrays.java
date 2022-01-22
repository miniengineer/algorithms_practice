// Link: https://leetcode.com/problems/merge-sorted-array/

public class MergeSortedArrays {
    // Solution with three pointers (p1, p2, p)
    // p points to the least element in nums1

    // iterate over nums1 from the last element
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (pointer >= 0) {
            // finished iterating over nums2 array
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
    }
}

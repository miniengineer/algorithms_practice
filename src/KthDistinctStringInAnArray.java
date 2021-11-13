//  Link: https://leetcode.com/contest/biweekly-contest-64/problems/kth-distinct-string-in-an-array/

//    A distinct string is a string that is present only once in an array.
//
//    Given an array of strings arr, and an integer k, return the kth distinct string present in arr.
//    If there are fewer than k distinct strings, return an empty string "".
//    Note that the strings are considered in the order in which they appear in the array.
//
//    Example 1:
//
//    Input: arr = ["d","b","c","b","c","a"], k = 2
//    Output: "a"
//    Explanation:
//    The only distinct strings in arr are "d" and "a".
//    "d" appears 1st, so it is the 1st distinct string.
//    "a" appears 2nd, so it is the 2nd distinct string.
//    Since k == 2, "a" is returned.
//
//    Example 2:
//    Input: arr = ["aaa","aa","a"], k = 1
//    Output: "aaa"
//    Explanation:
//    All strings in arr are distinct, so the 1st string "aaa" is returned.

import java.util.ArrayList;
import java.util.HashSet;

public class KthDistinctStringInAnArray {
    public static void main(String[] args) {
        String[] arr = { "aaa","aa","a" };
        int k = 1;

        System.out.println(kthDistinct(arr, k));
        // must be "aaa"
    }

    // brute force solution
    // Time complexity is O(n^2) - looping through the array + contains check of list
    // Space complexity is O(d) - depends on the number of duplicates
    public static String kthDistinct(String[] arr, int k) {
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> dups = new HashSet<>();

        for (String s : arr) {
            if (dups.contains(s) || list.contains(s)) {
                list.remove(s);

                if (!dups.contains(s)) {
                    dups.add(s);
                }
            } else {
                list.add(s);
            }
        }


        if (k > list.size()) {
            return "";
        } else {
            return list.get(k - 1);
        }
    }
}

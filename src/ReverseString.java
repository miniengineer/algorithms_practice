//Write a function that reverses a string. The input string is given as an array of characters s.
//
//    Example 1:
//
//    Input: s = ["h","e","l","l","o"]
//    Output: ["o","l","l","e","h"]
//    Example 2:
//
//    Input: s = ["H","a","n","n","a","h"]
//    Output: ["h","a","n","n","a","H"]


import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] str = "Minira".toCharArray();

        reverseString(str);
        // must be [a, r, i, n, i, M]
    }

    // Time complexity O(n)
    // Space complexity O(1)
    public static void reverseString(char[] s) {
        // ["h","e","l","l","o"]
        //   0   1   2   3   4

        // left and right pointers
        // while left != right, swap them
        // then increase left and decrease right
        int left = 0;
        int right = s.length - 1;

        // can not be left != right
        // for words with even number of chars
        // there won't be a moment when right = left

        while (left < right) {
            // swap
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }

        System.out.println(Arrays.toString(s));
    }
}

//    Link: https://leetcode.com/contest/weekly-contest-264/problems/next-greater-numerically-balanced-number/
//    An integer x is numerically balanced if for every digit d in the number x, there are exactly d occurrences of that digit in x.
//
//    Given an integer n, return the smallest numerically balanced number strictly greater than n.
//
//
//    Example 1:
//
//    Input: n = 1
//    Output: 22
//    Explanation:
//    22 is numerically balanced since:
//    - The digit 2 occurs 2 times.
//    It is also the smallest numerically balanced number strictly greater than 1.
//
//    Example 2:
//
//    Input: n = 1000
//    Output: 1333
//    Explanation:
//    1333 is numerically balanced since:
//    - The digit 1 occurs 1 time.
//    - The digit 3 occurs 3 times.
//    It is also the smallest numerically balanced number strictly greater than 1000.
//    Note that 1022 cannot be the answer because 0 appeared more than 0 times.
//
//    Example 3:
//
//    Input: n = 3000
//    Output: 3133
//    Explanation:
//    3133 is numerically balanced since:
//    - The digit 1 occurs 1 time.
//    - The digit 3 occurs 3 times.
//    It is also the smallest numerically balanced number strictly greater than 3000.
//
//
//    Constraints:
//
//    0 <= n <= 106


import java.util.Arrays;

public class NextGreaterNumericallyBalancedNumber {
    public static void main(String[] args) {
        int n = 3000;

        System.out.println(nextBeautifulNumber(n));
        // must be 3133
    }

    // Time complexity is O(n^2)
    // Space complexity is O(n)
    public static int nextBeautifulNumber(int n) {
        // n = 3000;
        // 3001
        // each time we increment -> check whether the number is balanced
        // to check whether it's balanced divide by 10, to get the digit
        // put it into array, where index is the digit and increment
        // in the end check whether all numbers in array == their indexes
        // 3001 / 10 = 1
        // 300 / 10 = 0
        // 30 / 10 = 0
        // 3 / 10 = 3

        // 3133
        n++;

        while (!isBalanced(n)) {
            n++;
        }

        return n;
    }


    public static boolean isBalanced(int num) {
        int[] arr = new int[10];
        int remainder;

        while (num > 0) {
            remainder = num % 10; // 1
            arr[remainder]++;

            num /= 10; // will be 300, not 300.1 cause type is int
        }

        for (int i = 0; i < arr.length; i++) {
            // i digit wasn't filled -> 0
            if (arr[i] == 0) continue;

            if ( arr[i] != i) {
                return false;
            }
        }

        return true;
    }

    // O(log n) solution
    // Since the greatest number we can get is 1,000,000
    // Put all possible beautiful numbers into array and use BinarySearch to retrieve the next beaut
    public static int nextBeautifulNumberFast(int n) {
        int[] beauts = {0, 1, 22, 122, 212, 221, 333, 1333, 3133, 3313, 3331, 4444, 14444, 22333, 23233, 23323, 23332, 32233, 32323, 32332, 33223, 33232, 33322, 41444, 44144, 44414, 44441, 55555, 122333, 123233, 123323, 123332, 132233, 132323, 132332, 133223, 133232, 133322, 155555, 212333, 213233, 213323, 213332, 221333, 223133, 223313, 223331, 224444, 231233, 231323, 231332, 232133, 232313, 232331, 233123, 233132, 233213, 233231, 233312, 233321, 242444, 244244, 244424, 244442, 312233, 312323, 312332, 313223, 313232, 313322, 321233, 321323, 321332, 322133, 322313, 322331, 323123, 323132, 323213, 323231, 323312, 323321, 331223, 331232, 331322, 332123, 332132, 332213, 332231, 332312, 332321, 333122, 333212, 333221, 422444, 424244, 424424, 424442, 442244, 442424, 442442, 444224, 444242, 444422, 515555, 551555, 555155, 555515, 555551, 666666, 1224444};
        int pos = Arrays.binarySearch(beauts, n);

        if(pos >= 0) {
            return beauts[pos+1];
        }

        return beauts[-pos-1];
    }
}

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


public class NextGreaterNumericallyBalancedNumber {
    public int nextBeautifulNumber(int n) {
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


    public boolean isBalanced(int num) {
        int[] arr = new int[10];
        int remainder;

        while (num > 0) {
            remainder = num % 10; // 1
            arr[remainder]++;

            num /= 10; // 300.1  300
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
}

//    Write a function:
//
//    class Solution { public int solution(int[] A); }
//
//    that, given an array A of N integers, returns the smallest positive integer (greater than 0)
//    that does not occur in A.
//
//    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
//
//    Given A = [1, 2, 3], the function should return 4.
//
//    Given A = [−1, −3], the function should return 1.
//
//    Write an efficient algorithm for the following assumptions:
//
//    N is an integer within the range [1..100,000];
//    each element of array A is an integer within the range [−1,000,000..1,000,000].

import java.util.HashSet;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] A = { 1, 3, 6, 4, 1, 2 };
        int[] A2 = { -1, -3 };
        int[] A3 = { 1, 2, 3 };

        System.out.println(findMissingPositive(A));
        // must be 5

        System.out.println(findMissingPositive(A2));
        // must be 1

        System.out.println(findMissingPositive(A3));
        // must be 4
    }

    // Time Complexity is O(n) - we would need to iterate over each elements in array twice
    // Space Complexity is O(n) - for HashSet that contains all positive elements of the array
    //                            worse case it will contain all elements
    public static int findMissingPositive(int[] A) {
        HashSet<Integer> allPositiveNums = new HashSet<>();
        int smallestPositiveSoFar = 1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0 ) continue;

            allPositiveNums.add(A[i]);
        }

        // array contains only negative numbers, no need to search further
        if (allPositiveNums.size() == 0) {
            return smallestPositiveSoFar;
        }

        while (true) {
            if (allPositiveNums.contains(smallestPositiveSoFar)) {
                smallestPositiveSoFar++;
            } else {
                break;
            }
        }

        return smallestPositiveSoFar;
    }
}

// You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
//
// numberOfBoxes is the number of boxes of type i.
// numberOfUnitsPerBox is the number of units in each box of the type i.
// You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck.
// You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

// Return the maximum total number of units that can be put on the truck.

//    Example 1:
//
//    Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
//    Output: 8
//    Explanation: There are:
//    - 1 box of the first type that contains 3 units.
//    - 2 boxes of the second type that contain 2 units each.
//    - 3 boxes of the third type that contain 1 unit each.
//    You can take all the boxes of the first and second types, and one box of the third type.
//    The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.

import java.util.Arrays;

public class MaximumUnitsOnTruck {
    public static void main(String[] args) {
        int[][] boxTypes = { {1,3},{2,2},{3,1} };
        int truckSize = 4;

        int[][] boxTypes2 = {{5, 10}, {2, 5}, {4, 7}, {3, 9} };
        int truckSize2 = 10;

        System.out.println(maximumUnits(boxTypes, truckSize));
        // must be 8

        System.out.println(maximumUnits(boxTypes2, truckSize2));
        // must be 91
    }

    // Time complexity O(n log n)
    // although looping is O(n) we have Arrays.sort

    // Space complexity O(1)
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int maximumTotalNumberOfUnits = 0;

        // need to choose based on number of units
        // first take boxes that contain the most units

        // while taking the units, remove boxes taken from the truckSize
        // add the # of units to the total units taken

        // hashmap? no guarantee that number of boxes or units is not the same
        // sort Array using the second element in the two dimensional array

        // works in Java 8
        // Arrays.sort(boxTypes, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] o1, int[] o2) {
        //         return Integer.compare(o2[1], o1[1]);
        //     }
        // });

        // works in Java 8 + faster + less verbose
        Arrays.sort(boxTypes, (int[] n1, int[] n2) -> n2[1] - n1[1]);

//        for (int[] boxType : boxTypes) {
//            while (boxType[0] > 0 && truckSize > 0) {
//                maximumTotalNumberOfUnits += boxType[1];
//
//                boxType[0]--;
//                truckSize--;
//            }
//        }

        // to avoid nested loops use Math.min(truckSize, box[1]
        // to decide how many boxes of this type we can take without going over the truck size limit

        for (int[] boxType : boxTypes) {
            int boxesToTake = Math.min(truckSize, boxType[0]);
            maximumTotalNumberOfUnits += boxesToTake * boxType[1];
            truckSize -= boxesToTake;

            if (truckSize == 0) break;
        }

        return maximumTotalNumberOfUnits;
    }
}

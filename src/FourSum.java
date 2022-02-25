import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[] { 1,0,-1,0,-2,2 }, 0));
        // must be [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

        System.out.println(fourSum(new int[] { 2, 2, 2, 2, 2 }, 8));
        // must be [[2,2,2,2]]
        // tricky one, won't pass if skipping duplicates logic is incorrect!
    }

    // Time Complexity is O(n^3) - we're sorting the array which is O(n logn), but we have three nested loops which is O(n^3)
    // Space Complexity is O(n) - yes, it's linear CAUSE WE'RE USING sorting!!! and in Java sorting for primitives is linear space
    public static List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(arr);

        for (int first = 0; first < arr.length - 3; first++) {
            // skip duplicates
            if (first > 0 && arr[first] == arr[first - 1]) continue;

            for (int second = first + 1; second < arr.length - 2; second++) {
                // skip duplicates
                if (second > first + 1 && arr[second] == arr[second - 1]) continue;

                // from here we can use two pointers as in ThreeSum or mimicking TwoSum
                int third = second + 1;
                int forth = arr.length - 1;

                while (forth > third) {
                    int currSum = arr[first] + arr[second] + arr[third] + arr[forth];
                    if (currSum == target) {
                        quadruplets.add(Arrays.asList(arr[first], arr[second], arr[third], arr[forth]));
                        third++;
                        forth--;

                        // skip duplicated elements for the remaining two pointers
                        // move the remaining pointers only if they don't overlap
                        while (third < forth && arr[third] == arr[third - 1]) {
                            third++;
                        }

                        while (forth > third && arr[forth] == arr[forth + 1]) {
                            forth--;
                        }

                    } else if (currSum < target) {
                        third++;
                    } else {
                        forth--;
                    }
                }

            }

        }

        return quadruplets;
    }
}

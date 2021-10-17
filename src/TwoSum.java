import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.

//Example 2:
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]

//Example 3:
//
//Input: nums = [3,3], target = 6
//Output: [0,1]

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = { 3,2,4 };
        int target = 6;

        int[] nums2 = { 3,3 };
        int target2 = 6;

        System.out.println(Arrays.toString(twoSum(nums, target)));
        // must be [1,2]

        System.out.println(Arrays.toString(twoSum(nums2, target2)));
        // must be [0,1]
    }

    // time complexity O(n)
    public static int[] twoSum(int[] nums, int target) {
        // to allow storing duplicated nums
        // key is index, value is num
        HashMap<Integer, ArrayList<Integer>> numsMap = new HashMap<>();

        // add all nums to numsMap
        // how to return two indices when hashmap can not contain duplicated keys?
        // use num as key, and store the indexes as an array

        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(nums[i])) {
                ArrayList<Integer> list = numsMap.get(nums[i]);
                list.add(i);
                numsMap.put(nums[i], list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                numsMap.put(nums[i], list);
            }
        }

        int[] result = new int[2];

        // loop through nums array
        // for each num look if numsMap has target - num
        // if yes, return their indices
        // if not go to the next num
        for (int i = 0; i < nums.length; i++) {
            int secondNum = target - nums[i];
            // time complexity of containsValue O(1)
            if (numsMap.containsKey(secondNum)) {
                ArrayList<Integer> list = numsMap.get(secondNum);

                // if two numbers are equal, the list should be of size 2
                // otherwise it's the same number

                if (nums[i] == secondNum) {
                    if (list.size() == 2) {
                        result[0] = i;
                        result[1] = list.get(1);

                        break;
                    }
                } else {
                    result[0] = i;
                    result[1] = list.get(0);

                    break;
                }
            }
        }

        // guaranteed that each input will have one solution
        return result;

    }

    public static int[] lessVerboseTwoSum(int[] nums, int target) {
        HashMap<Integer,Integer> numToIndexMap = new HashMap<Integer,Integer>();

        // since we know that there are exactly two numbers to return
        // we don't care if there are two duplicated nums
        // and the second nums index will overwrite the first
        // because when looping through the nums the first index is known -> j
        // and all we need to do is find and add the secondNum index
        for (int i = 0; i < nums.length; i++) {
            numToIndexMap.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            int secondNum = target - nums[j];

            // the second if statement is for cases like nums = [3,2,4], target = 6
            // the output must be [1,2], but if we don't have it the result would be [0,0]
            // as we have 3 in our hashmap
            // so if the index is the same then we're looking at the same number
            if (numToIndexMap.containsKey(secondNum) && numToIndexMap.get(secondNum) != j) {
                return new int[] { j, numToIndexMap.get(secondNum) };
            }
        }

        return null;

    }


}

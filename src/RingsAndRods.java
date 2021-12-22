//    Link: https://leetcode.com/problems/rings-and-rods/
//
//    There are n rings and each ring is either red, green, or blue. The rings are distributed across ten rods labeled from 0 to 9.
//
//    You are given a string rings of length 2n that describes the n rings that are placed onto the rods. Every two characters in rings forms a color-position pair that is used to describe each ring where:
//
//    The first character of the ith pair denotes the ith ring's color ('R', 'G', 'B').
//    The second character of the ith pair denotes the rod that the ith ring is placed on ('0' to '9').
//    For example, "R3G2B1" describes n == 3 rings: a red ring placed onto the rod labeled 3, a green ring placed onto the rod labeled 2, and a blue ring placed onto the rod labeled 1.
//
//    Return the number of rods that have all three colors of rings on them.
//
//    Example 2:
//    Input: rings = "B0R0G0R9R0B0G0"
//    Output: 1
//    Explanation:
//    - The rod labeled 0 holds 6 rings with all colors: red, green, and blue.
//    - The rod labeled 9 holds only a red ring.
//    Thus, the number of rods with all three colors is 1.
//
//    Example 3:
//
//    Input: rings = "G4"
//    Output: 0
//    Explanation:
//    Only one ring is given. Thus, no rods have all three colors.

import java.util.ArrayList;
import java.util.HashMap;

public class RingsAndRods {
    public static void main(String[] args) {
        String rings = "B0R0G0R9R0B0G0";

        System.out.println(countPoints(rings));
        // must be 1
    }

    // Time Complexity is O(n)
    // Space Complexity is O(n)
    public static int countPoints(String rings) {
        // we need at least three colors to fulfill the condition
        if (rings.length() < 6) return 0;

        HashMap<String, ArrayList<String>> rodNumToColor = new HashMap<>();
        int rodsWithThreeColorsCounter = 0;

        for (int i = 0; i < rings.length() - 1; i += 2) {
            String color = String.valueOf(rings.charAt(i));
            String rodNum = String.valueOf(rings.charAt(i + 1));

            ArrayList<String> list = rodNumToColor.getOrDefault(rodNum, new ArrayList<String>());
            if (!list.contains(color)) {
                list.add(color);

                if (list.size() == 3) rodsWithThreeColorsCounter++;
            }

            rodNumToColor.put(rodNum, list);
        }


        return rodsWithThreeColorsCounter;
    }
}

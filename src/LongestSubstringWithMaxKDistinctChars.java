// Link: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/

// Tips:  sliding window technique with HashMap to remember the frequency of a char
//        and to use the size of HM to decide whether to shrink the window or not

//        No need for additional currentSubstring variable, can be calculated using windowEnd and windowStart

import java.util.HashMap;

public class LongestSubstringWithMaxKDistinctChars {
    public static void main(String[] args) {
        String str ="cbbebi";
        int k = 3;

        System.out.println(lengthOfLongestSubstringKDistinct(str, k));
        // must be 5
        // Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
    }

    // Time complexity is O(n) - where n is the number of chars in string 'str'
    // Space complexity is O(k) - since we would need to store at most k sets of char and frequency in the HashMap
    public static int lengthOfLongestSubstringKDistinct(String str, int k) {
        int windowStart = 0;
        int longestSubstring = 0;
//        int currSubstring = 0;
        HashMap<Character, Integer> charToFrequency = new HashMap();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char currentChar = str.charAt(windowEnd);
            int currentCharFrequency = charToFrequency.getOrDefault(currentChar, 0);
            currentCharFrequency++;

            charToFrequency.put(currentChar, currentCharFrequency);
//            currSubstring++;

            while (charToFrequency.size() > k) {
                char charToShrink = str.charAt(windowStart);
                charToFrequency.put(charToShrink, charToFrequency.get(charToShrink) - 1);

                if (charToFrequency.get(charToShrink) ==  0) {
                    charToFrequency.remove(charToShrink);
                }

//                currSubstring--;
                windowStart++;
            }

//            longestSubstring = Math.max(longestSubstring, currSubstring);
            longestSubstring = Math.max(longestSubstring, windowEnd - windowStart + 1);

        }

        return longestSubstring;
    }
}

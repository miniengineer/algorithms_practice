// Link: https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/

// Tip: sliding window technique

import java.util.HashMap;

public class LongestSubstringAtMostTwoDistinctCharacters {
    public static void main(String[] args) {
        String str = "ccaabbb";

        System.out.println(lengthOfLongestSubstringTwoDistinct(str));
        // must be 5
        // Explanation: The substring is "aabbb" which its length is 5.
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int longestSubstrSoFar = 0;
        int windowStart = 0;

        HashMap<Character,Integer> charToFreq = new HashMap();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char currChar = s.charAt(windowEnd);
            charToFreq.put(currChar, charToFreq.getOrDefault(currChar, 0) + 1);

            while (charToFreq.size() > 2) {
                // shrink the window
                char charToRemove = s.charAt(windowStart);
                int charToRemoveCnt = charToFreq.get(charToRemove);

                if (charToRemoveCnt == 1) {
                    charToFreq.remove(charToRemove);
                } else {
                    charToFreq.put(charToRemove, charToRemoveCnt - 1);
                }

                windowStart++;
            }

            longestSubstrSoFar = Math.max(longestSubstrSoFar, windowEnd - windowStart + 1);
        }

        return longestSubstrSoFar;
    }
}

//    Link: https://leetcode.com/contest/weekly-contest-266/problems/count-vowel-substrings-of-a-string/
//
//    A substring is a contiguous (non-empty) sequence of characters within a string.
//
//    A vowel substring is a substring that only consists of vowels ('a', 'e', 'i', 'o', and 'u')
//    and has all five vowels present in it.
//    Given a string word, return the number of vowel substrings in word.
//
//
//    Example 1:
//
//    Input: word = "aeiouu"
//    Output: 2
//    Explanation: The vowel substrings of word are as follows (underlined):
//    - "aeiouu"
//    - "aeiouu"
//    Example 2:
//
//    Input: word = "unicornarihan"
//    Output: 0
//    Explanation: Not all 5 vowels are present, so there are no vowel substrings.
//    Example 3:
//
//    Input: word = "cuaieuouac"
//    Output: 7
//    Explanation: The vowel substrings of word are as follows (underlined):
//    - "cuaieuouac"
//    - "cuaieuouac"
//    - "cuaieuouac"
//    - "cuaieuouac"
//    - "cuaieuouac"
//    - "cuaieuouac"
//    - "cuaieuouac"
//    Example 4:
//
//    Input: word = "bbaeixoubb"
//    Output: 0
//    Explanation: The only substrings that contain all five vowels also contain consonants,
//    so there are no vowel substrings.

import java.util.HashMap;

public class CountVowelSubstringsOfAString {
    public static void main(String[] args) {
        String word = "cuaieuouac";
        String word2 = "abracadabra";

        System.out.println(countVowelSubstrings(word));
        // must be 7

        System.out.println(countVowelSubstrings(word2));
        // must be 0
    }

    // Time complexity O(n^2) - two nested for loops
    // Space complexity O(1) - hashmap is constant to 5 vowels
    public static int countVowelSubstrings(String word) {
        int totalSubstrings = 0;
        int vowelsCount = 0;

        // how to store vowels?
        // hashmap for now
        HashMap<String,Boolean> vowels = new HashMap<>();
        vowels.put("a", false);
        vowels.put("e", false);
        vowels.put("i", false);
        vowels.put("u", false);
        vowels.put("o", false);

        for (int i = 0; i < word.length(); i++) {
            String letterOne = String.valueOf(word.charAt(i));
            if (vowels.containsKey(letterOne)) {
                vowels.put(letterOne, true);
                vowelsCount++;

                for (int j = i + 1; j < word.length(); j++) {
                    String letterTwo = String.valueOf(word.charAt(j));
                    if (vowels.containsKey(letterTwo)) {
                        if (!vowels.get(letterTwo)) {
                            vowels.put(letterTwo, true);
                            vowelsCount++;
                        }

                        if (vowelsCount == 5) {
                            totalSubstrings++;
                        }
                    } else {
                        break;
                    }
                }

                vowelsCount = 0;

                vowels.put("a", false);
                vowels.put("e", false);
                vowels.put("i", false);
                vowels.put("u", false);
                vowels.put("o", false);
            }
        }


        return totalSubstrings;
    }
}

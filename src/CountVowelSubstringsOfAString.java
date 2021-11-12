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

import java.util.HashSet;
import java.util.Set;

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

        // One HashSet to store vowels
        // Another HashSet to keep count
        Set<Character> vowelSet = Set.of('a', 'e', 'i', 'o', 'u'), curr = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            Character letterOne = new Character(word.charAt(i));
            if (vowelSet.contains(letterOne)) {
                curr.add(letterOne);

                for (int j = i + 1; j < word.length(); j++) {
                    Character letterTwo = new Character(word.charAt(j));
                    if (vowelSet.contains(letterTwo)) {
                        if (!curr.contains(letterTwo)) {
                            curr.add(letterTwo);
                        }

                        if (vowelSet.size() == curr.size()) {
                            totalSubstrings++;
                        }
                    } else {
                        break;
                    }
                }

                curr.clear();

            }
        }


        return totalSubstrings;
    }
}

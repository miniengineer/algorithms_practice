import java.util.HashMap;

// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// Follow up: What if the inputs contain Unicode characters?
// How would you adapt your solution to such a case?
//
//    Example 1:
//
//    Input: s = "anagram", t = "nagaram"
//    Output: true
//    Example 2:
//
//    Input: s = "rat", t = "car"
//    Output: false


public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        String s2 = "minira", t2 = "mini";

        System.out.println(isAnagram(s, t));
        // must be "true"

        System.out.println(isAnagram(s2, t2));
        // must be "false"
    }

    // Time complexity is O(n)
    // Space complexity is O(1)
    public static boolean isAnagram(String s, String t) {
        // loop through first string
        // put letter => occurrence_number into a hash
        // case sensitive? - lowercase only
        // loop through second string
        // for each letter check if it's in the hash
        // if not return false

        // if loop is finished still check if the hash has any entries
        // cause first string could include more letters than the second
        // and it we don't check that the hash is empty we will get true anyways

        // if length is not the same, return false immediately
        if (s.length() != t.length()) {
            return false;
        }

        // hash table handles all unicode chars
        // if there wasn't follow up about unicode, then could use primitive array
        // much faster + O(1) space complexity
        // use extra space, but table's size stays constant
        // Since both s and t contain only letters from a-za−z, a simple counter table of size 26 is suffice.
        // int[] table = new int[26];
        // for (int i = 0; i < s.length(); i++) {
        //     table[s.charAt(i) - 'a']++;
        // }
        // for (int i = 0; i < t.length(); i++) {
        //     table[t.charAt(i) - 'a']--;
        //     if (table[t.charAt(i) - 'a'] < 0) {
        //         return false;
        //     }
        // }

        HashMap<Character,Integer> charsMap = new HashMap<>();

        // put everything into the hash
        for (int i = 0; i < s.length(); i++) {
            charsMap.put(s.charAt(i), charsMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int j = 0; j < t.length(); j++) {
            if (charsMap.containsKey(t.charAt(j))) {
                int currCharCount = charsMap.get(t.charAt(j));
                currCharCount--;

                if (currCharCount > 0) {
                    charsMap.put(t.charAt(j), currCharCount);
                } else {
                    charsMap.remove(t.charAt(j));
                }
            } else {
                return false;
            }
        }

        if (!charsMap.isEmpty()) return false;

        return true;
    }
}

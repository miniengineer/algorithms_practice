//Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//    Example 1:
//
//    Input: s = "A man, a plan, a canal: Panama"
//    Output: true
//    Explanation: "amanaplanacanalpanama" is a palindrome.
//    Example 2:
//
//    Input: s = "race a car"
//    Output: false
//    Explanation: "raceacar" is not a palindrome.

public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "ma_dam ";
        String str2 = "race a car";

        System.out.println(isPalindrome(str));
        // must be "true"

        System.out.println(isPalindrome(str2));
        // must be "false"
    }

    // Time complexity is O(n)
    // Space complexity is O(1) - no extra space required
    public static boolean isPalindrome(String s) {
        // "race a car"
        //  0123456789

        // "racaecar"
        //  01234567

        // Time complexity of replaceAll is O(n)
        s = s.replaceAll("[^a-zA-Z\\d]+","");

        int left = 0;
        int right = s.length() - 1; // 9

        // amanaplanacanalpanama
        // 0123456789101112

        while (left < right) {
            Character one = Character.toLowerCase(s.charAt(left));
            Character two = Character.toLowerCase(s.charAt(right));
            if (!one.equals(two)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

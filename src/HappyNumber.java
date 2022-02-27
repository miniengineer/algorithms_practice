// Link: https://leetcode.com/problems/happy-number/

// since the problem includes "cycle" keyword it's good candidate for slow and fast pointers technique!
// It could be solved using additional data structure, but that won't be constant space

// the idea is to move both pointers and stop once cycle is detected, since it's guaranteed
// the only thing that's left after that is to check whether the cycle starts at 1

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappyNumber(12));
        // must be false

        System.out.println(isHappyNumber(19));
        //    must be true
        //    Explanation:
        //    1^2 + 9^2 = 82
        //    8^2 + 2^2 = 68
        //    6^2 + 8^2 = 100
        //    1^2 + 0^2 + 0^2 = 1
    }

    // Time Complexity is O(log n)
    // Space Complexity is O(1)
    public static boolean isHappyNumber(int num) {
        int slow = num;
        int fast = num;

        do {
            slow = findSquare(slow);
            // move two steps ahead
            fast = findSquare(findSquare(fast));
        } while (slow != fast); // found cycle

        // happy number is only when cycle is on 1
        return slow == 1;
    }

    public static int findSquare(int num) {
        int sum = 0, digit;

        while (num > 0) {
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }
}

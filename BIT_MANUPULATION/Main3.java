package BIT_MANUPULATION;

public class Main3 {

    public static boolean isPowerOfFour(int n) {

        if (n <= 0) {
            return false;
        }

        return (n & (n - 1)) == 0 &&
               (n & 0x55555555) != 0;
    }

    public static void main(String[] args) {

        System.out.println(isPowerOfFour(16)); // true
        System.out.println(isPowerOfFour(5));  // false
        System.out.println(isPowerOfFour(1));  // true
        System.out.println(isPowerOfFour(64)); // true
        System.out.println(isPowerOfFour(8));  // false
    }
}





// Given an integer n, return true if it is a power of four. Otherwise, return false.

// An integer n is a power of four, if there exists an integer x such that n == 4x.

 

// Example 1:

// Input: n = 16
// Output: true

// Example 2:

// Input: n = 5
// Output: false

// Example 3:

// Input: n = 1
// Output: true 

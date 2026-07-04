package BIT_MANUPULATION;

public class Main1 {

    public static int divide(int dividend, int divisor) {

        // Handle overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to long to avoid overflow
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        long answer = 0;

        while (dvd >= dvs) {

            long temp = dvs;
            long multiple = 1;

            // Keep doubling until it becomes larger than dividend
            while ((temp << 1) <= dvd) {
                temp <<= 1;
                multiple <<= 1;
            }

            dvd -= temp;
            answer += multiple;
        }

        // Apply sign
        if (negative) {
            answer = -answer;
        }

        return (int) answer;
    }

    public static void main(String[] args) {

        System.out.println(divide(10, 3));   // 3
        System.out.println(divide(7, -3));   // -2
        System.out.println(divide(-15, 2));  // -7
        System.out.println(divide(-20, -5)); // 4
    }
}
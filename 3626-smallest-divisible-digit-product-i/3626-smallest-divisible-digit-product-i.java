

class Solution {
    public int smallestNumber(int n, int t) {
        for (int num = n; ; num++) {
            int product = 1;
            int temp = num;
            
            // compute product of digits
            while (temp > 0) {
                product *= temp % 10;
                temp /= 10;
            }
            
            // check divisibility
            if (product % t == 0) {
                return num;
            }
        }
    }
}
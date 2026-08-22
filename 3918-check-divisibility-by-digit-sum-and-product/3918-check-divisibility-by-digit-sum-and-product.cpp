class Solution {
public:
    bool checkDivisibility(int n) {
        int num = n;
        int digitSum = 0, digitProduct = 1;
        while (num > 0) {
            int d = num % 10;
            digitSum += d;
            digitProduct *= d;
            num /= 10;
        }
        return n % (digitSum + digitProduct) == 0;
        
    }
};


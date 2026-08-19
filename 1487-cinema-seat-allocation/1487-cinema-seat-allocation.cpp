
class Solution {
public:
    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {
        unordered_map<int, int> rowMask;
        for (auto& r : reservedSeats) {
            int row = r[0], seat = r[1];
            if (seat < 2 || seat > 9) continue; // seats 1 and 10 don't block any block
            int bit = seat - 2; // seats 2..9 -> bits 0..7
            rowMask[row] |= (1 << bit);
        }
        
        const int leftMask  = 0b00001111; // seats 2,3,4,5
        const int midMask   = 0b00111100; // seats 4,5,6,7
        const int rightMask = 0b11110000; // seats 6,7,8,9
        
        long long result = 2LL * (n - rowMask.size());
        
        for (auto& [row, mask] : rowMask) {
            bool canLeft  = (mask & leftMask) == 0;
            bool canMid   = (mask & midMask) == 0;
            bool canRight = (mask & rightMask) == 0;
            
            if (canLeft && canRight) {
                result += 2;
            } else if (canMid || canLeft || canRight) {
                result += 1;
            }
        }
        
        return (int)result;
    }
};
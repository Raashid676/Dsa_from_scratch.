class Solution {
public:
    long long lcm(long long a, long long b) {
        return a / __gcd(a, b) * b;
    }

    long long countUpTo(long long x, vector<int>& coins) {
        int n = coins.size();
        long long count = 0;
        // iterate over all non-empty subsets
        for (int mask = 1; mask < (1 << n); mask++) {
            long long l = 1;
            int bits = __builtin_popcount(mask);
            bool overflow = false;
            for (int i = 0; i < n; i++) {
                if (mask & (1 << i)) {
                    l = lcm(l, coins[i]);
                    if (l > x) { overflow = true; break; }
                }
            }
            if (overflow) continue;
            if (bits % 2 == 1)
                count += x / l;
            else
                count -= x / l;
        }
        return count;
    }

    long long findKthSmallest(vector<int>& coins, int k) {
        int minCoin = *min_element(coins.begin(), coins.end());
        long long lo = 1, hi = (long long)minCoin * k;

        while (lo < hi) {
            long long mid = lo + (hi - lo) / 2;
            if (countUpTo(mid, coins) >= k)
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }
};
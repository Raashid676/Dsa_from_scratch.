class Solution:
    def smallestUniqueSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        MOD = (1 << 61) - 1
        BASE = random.randint(10**6, MOD - 1)

        def isValid(k):
            power = pow(BASE, k - 1, MOD)          # weight of the leftmost element
            seen = defaultdict(int)
            h = 0
            for i in range(n):
                if i >= k:
                    h = (h - nums[i - k] * power) % MOD   # drop the leftmost element
                h = (h * BASE + nums[i]) % MOD            # shift left and add the new element
                if i >= k - 1:
                    seen[h] += 1
            return any(seen[h] == 1 for h in seen)

        lo, hi = 1, n
        while lo < hi:
            mid = (lo + hi) // 2
            if isValid(mid):
                hi = mid
            else:
                lo = mid + 1
        return lo
class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int l = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - l + 1);
                sum -= nums[l];
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
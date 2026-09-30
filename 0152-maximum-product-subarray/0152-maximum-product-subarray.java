class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int minEnding = nums[0];
        int maxEnding = nums[0];
        int res = nums[0];
        
        for(int i=1; i<n; i++){
            int v1 = nums[i];
            int v2 = minEnding * nums[i];
            int v3 = maxEnding * nums[i];

            maxEnding = Math.max(v1, Math.max(v2, v3));
            minEnding = Math.min(v1, Math.min(v2, v3));

            res = Math.max(res, Math.max(maxEnding, minEnding));
        }

        return res;
    }
}
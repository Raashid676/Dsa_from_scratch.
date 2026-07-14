class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        int left = 0;
        int right = 0;
        int maxLen = 0;
        int zerocnt = 0;
        
        for(right = 0; right <n; right++){
            if(nums[right] == 0){
                zerocnt++;
            }
            if(zerocnt > k){
                if(nums[left] == 0){
                    zerocnt--;
                }

                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
     
        
    }
}
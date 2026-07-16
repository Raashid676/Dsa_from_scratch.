class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return sB (nums, k) - sB(nums, k - 1);
      
        
    }

    private int sB(int[]nums, int k){
        int left = 0;
        int cnt = 0;
        int sum = 0;

        for(int right = 0; right < nums.length; right++){
            sum += nums[right] % 2;


            while(sum > k){
                sum -= nums[left] % 2;
                left++;
            }
            cnt += (right - left + 1);
        }
        return cnt;
    }
}
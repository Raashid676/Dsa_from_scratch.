class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = 0;
        int result =  Integer.MAX_VALUE;
       
        
        int sum = 0;
        while (high < n){
            sum += nums[high]; 

            while(sum >= target){
               int len = high - low + 1;  // len of n of currently working
               result = Math.min(result, len); // min of working elements 

               sum -= nums[low];
               low++;
            }
            high++;
        }
        if(result == Integer.MAX_VALUE) return 0;

        

        return result;
         
        
    }
}
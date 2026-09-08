class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int l = 0;
        int res = 1;
        int ex = 1;

        while(ex < n){
            if(nums[ex] == nums[ex - 1]){
                ex++;
                continue;
            }
            else{

                nums[l+1] = nums[ex];
                l++;
                res++;
                ex++;
            }
        }
       return res;
        
    }
}
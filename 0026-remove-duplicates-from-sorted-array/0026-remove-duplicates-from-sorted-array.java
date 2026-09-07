class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int l = 0;
        int res = 1;
        int h = 1;

        while(h < n){

            if(nums[h] == nums[h - 1]){
                h++;
                continue;
            }
            else{


                nums[l+1] = nums[h];
                l++;
                res++;
                h++;
            }
        }

        return res;
        
    }
}
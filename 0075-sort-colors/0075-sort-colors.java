class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high){

            // for zeros
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low++] = nums[mid];
                nums[mid++] = temp;
            }

            // for ones
            else if(nums[mid] == 1){
                mid++;
            }
            
            // for two's

            else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high--] = temp;
            }
            
        }
        
    }
}
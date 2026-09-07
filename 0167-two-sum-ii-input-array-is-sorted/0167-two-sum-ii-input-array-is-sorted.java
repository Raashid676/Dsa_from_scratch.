class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0;
        int j = n - 1;


        while(l < j){

            int sum = numbers[l] + numbers[j];

            if(sum == target){
                return new int []{l+1, j+1};
            }
            
            if(sum < target){
                l++;
            }

            else{
                j--;
            }
        }

        return new int []{-1, -1};
      
     
        
    }
}
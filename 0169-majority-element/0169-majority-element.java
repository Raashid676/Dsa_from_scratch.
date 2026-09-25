

class Solution {
    public int majorityElement(int[] nums) {
        int threshhold = nums.length / 2;

        HashMap< Integer, Integer> freq = new HashMap<>();
        for(int num: nums){
            int updatedFreq = freq.getOrDefault(num, 0) + 1;
            freq.put(num, updatedFreq);

            if(updatedFreq > threshhold){
                return num;
            }
        }

        return -1;
        
       
      
    }
}
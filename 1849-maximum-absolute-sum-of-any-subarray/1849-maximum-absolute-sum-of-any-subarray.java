class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int minPreSum = 0;
        int maxPreSum = 0;
        int preFixSum = 0;

        for(int num: nums){
            preFixSum += num;

            minPreSum = Math.min(minPreSum, preFixSum);
            maxPreSum = Math.max(maxPreSum, preFixSum);
        }


        return maxPreSum - minPreSum;
        
    }
}
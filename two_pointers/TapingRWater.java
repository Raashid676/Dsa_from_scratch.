package two_pointers;

public class TapingRWater {
     public int trap(int[] height) {
        int n = height.length;
        int totalW = 0;

        int leftMax = 0;
        int rightMax = 0;

        int st = 0;
        int end = n -1;

        while(st < end){
            leftMax = Math.max(leftMax, height[st]);
            rightMax = Math.max(rightMax, height[end]);


            if(leftMax < rightMax){
                totalW += leftMax - height[st];
                st++;
            }
            else {

                totalW += rightMax - height[end];
                end--;
            }
        }
        return totalW;
        
    }
    
}

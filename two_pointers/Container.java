package two_pointers;

public class Container {
      public int maxArea(int[] height) {
        int l=0;
        int r= height.length-1;
        int res = 0;

        while(l<r){
            int area = Math.min(height[l], height[r]) * (r - l);
            res = Math.max(area, res);

            if(height[l] < height[r]){
                l++;
            }
            else {
                r--;
            }
        }

        return res;
    }
    
}

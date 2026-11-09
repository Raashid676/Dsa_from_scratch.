package Arrays_NEETCODE;

import java.util.Arrays;

public class C_Prefix1 {

    class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);

        String First = strs[0];
        String Last = strs[strs.length -1];

        for(int i=0; i<Math.min(First.length(), Last.length()); i++){
            if(First.charAt(i) != Last.charAt(i)){
                return ans.toString();
            }

            ans.append(First.charAt(i));
        }
        return ans.toString();
    }
}
    
}

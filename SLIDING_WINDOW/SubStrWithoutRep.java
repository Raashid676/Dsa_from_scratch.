package SLIDING_WINDOW;

import java.util.HashSet;

public class SubStrWithoutRep {

      public int lengthOfLongestSubstring(String s){

        int maxLen = 0;

        for(int i=0; i<s.length(); i++){

            HashSet<Character> set = new HashSet<>();
            int count = 0;

            for(int j=i; j<s.length(); j++){

                if(set.contains(s.charAt(j))){
                    break;
                }

                set.add(s.charAt(j));
                count= count + 1;

                maxLen = Math.max(maxLen, count);
            }
        }


       return maxLen;
      
        
        
    }
}

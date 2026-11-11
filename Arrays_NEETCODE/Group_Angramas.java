package Arrays_NEETCODE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Angramas {
    class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for(String str: strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String SortedStr = new String(arr);

            List<String> group = res.getOrDefault(SortedStr, new ArrayList<>());
            group.add(str);
            res.put(SortedStr, group);




        }

        return new ArrayList<>(res.values());
        
    }
}
    
}

class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        int maxLen = 0;

        for(int i=0; i<n; i++){

            int [] freq = new int[26];

            for(int j = i; j<n; j++){
                freq[s.charAt(j) - 'a']++;
                boolean isValid = true;


                for(int f: freq){
                    if(f > 0 && f < k){
                        isValid = false;
                        break;
                    }
                }
                if(isValid){
                    maxLen = Math.max(maxLen, j-i + 1);
                }
            }

            
        }

        return maxLen;
       
    }
}
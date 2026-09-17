class Solution {
    public boolean isSubsequence(String s, String t) {
        int j = 0; // pointer for t, shared across outer loop iterations

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            boolean found = false;
            while(j < t.length()){
                char d = t.charAt(j);
                j++;
                if(c == d){
                    found = true;
                    break;
                }
            }

            if(!found){
                return false;
            }
        }

        return true;
    }
}
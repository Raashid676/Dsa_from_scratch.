

class Solution {
    public String minWindow(String s, String t) {
        int m=s.length();
        int n=t.length();
        int count=n;
        StringBuilder sb= new StringBuilder();
        if(m<n){
            return sb.toString();
        }
        int[] freq = new int[128];
        for (char c: t.toCharArray()){
            freq[c]++;
        }
        int i=0;
        int start=0;
        int minLength = Integer.MAX_VALUE;
        for(int j=0; j<m; j++){
            char c= s.charAt(j);
            if(freq[c]>0){
                count--;
            }
            freq[c]--;
            if(count==0){
                while(count==0){
                    if(j-i+1<minLength){
                        minLength = j - i + 1;
                        start= i;
                    } 
                    c= s.charAt(i);
                    freq[c]++;
                    if(freq[c]>0){
                        count++;
                    }
                    i++;
                }
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start+minLength);
    }
}
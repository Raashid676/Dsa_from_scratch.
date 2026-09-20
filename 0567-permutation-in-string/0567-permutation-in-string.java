class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m) return false;

        int [] s1_freq = new int [26];
        int [] s2_freq = new int [26];

        for(int i=0; i<n; i++){
            s1_freq[s1.charAt(i) - 'a']++;
        }

        int l = 0;
        int r = 0;

        while(r < m){                                  // fix 1: was l < r
            s2_freq[s2.charAt(r) - 'a']++;              // fix 2: was missing

            if(r - l + 1 > n){
                s2_freq[s2.charAt(l) - 'a']--;          // fix 3: was s1.charAt(l)
                l++;
            }

            if (Arrays.equals(s1_freq, s2_freq)) {
               return true;
            }

            r++;
        }

        return false;
    }
}
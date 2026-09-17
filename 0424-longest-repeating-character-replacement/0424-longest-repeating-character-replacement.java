class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int low = 0;
        int res = 0;
        int maxFreq = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for(int right = 0; right < n; right++){
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(c));

            // shrink window if (window size - maxFreq) > k
            while((right - low + 1) - maxFreq > k){
                char left = s.charAt(low);
                freq.put(left, freq.get(left) - 1);
                if(freq.get(left) == 0)
                    freq.remove(left);
                low++;
            }

            res = Math.max(res, right - low + 1);
        }

        return res;
    }
}
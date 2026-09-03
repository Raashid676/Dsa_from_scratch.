
class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[][] freq = new int[26][2];
        for(int i = 0; i<26; i++){
            freq[i][0] = -1;
            freq[i][1] = -1;
        }

        for(int i = 0; i<n; i++){
            int idx = s.charAt(i) - 'a';

            if(freq[idx][0] == -1) freq[idx][0] = i;
            freq[idx][1] = i;
        }

        List<int[]> intervals = new ArrayList<>();    

        for(int j = 0; j<26; j++){
            if(freq[j][0] == -1) continue;

            //single elements
            if(freq[j][0] == freq[j][1]){
                intervals.add(new int[]{freq[j][0], freq[j][1]});
                continue;
            }

            //Strings with diff char
            int start = freq[j][0];
            int end = freq[j][1];

            for(int i = start; i <= end; i++){
                int x = s.charAt(i) - 'a';

                if(freq[x][0] < start){
                    start = -1;
                    break;
                }

                if(freq[x][1] > end){
                    end = freq[x][1];
                }
            }

            if(start != -1){
                intervals.add(new int[]{start, end});
            }
        }

        //sort intervals
        intervals.sort((a, b) -> a[1] - b[1]);

        List<String> ans = new ArrayList<>();

        int prevEnd = -1;

        for(int[] interval : intervals) {
            if(interval[0] > prevEnd) {
                ans.add(s.substring(interval[0], interval[1] + 1));
                prevEnd = interval[1];
            }
        }

        return ans;
    }
}
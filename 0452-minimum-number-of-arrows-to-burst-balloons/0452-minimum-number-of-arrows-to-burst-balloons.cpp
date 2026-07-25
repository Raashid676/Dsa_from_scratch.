class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        int n = points.size();

        sort(begin(points), end(points));
        vector<int> prev = points[0];
        int cnt = 1;

        for(int i=1; i<n; i++){

            int currStpoint = points[i][0];
            int currEnpoint = points[i][1];

            int prevStpoint = prev [0];
            int prevEnpoint = prev [1];


            if(currStpoint > prevEnpoint){
                cnt++;
                prev = points[i];
            }else{

                prev[0] = max(prevStpoint,  currStpoint);
                prev[1] = min(prevEnpoint, currEnpoint);
            }
        }
        return cnt;
        
    }
};
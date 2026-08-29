
class Solution {
public:
    vector<int> lexicographicallySmallestArray(vector<int>& nums, int limit) {
        int n = nums.size();
        
        // Pair up each value with its original index
        vector<pair<int,int>> arr(n);
        for (int i = 0; i < n; i++) {
            arr[i] = {nums[i], i};
        }
        
        // Sort by value
        sort(arr.begin(), arr.end());
        
        vector<int> result(n);
        int i = 0;
        
        while (i < n) {
            int j = i;
            // Group consecutive elements where difference <= limit
            // (since sorted, only need to check adjacent difference)
            while (j + 1 < n && arr[j + 1].first - arr[j].first <= limit) {
                j++;
            }
            
            // Collect original indices in this group [i, j]
            vector<int> indices;
            for (int k = i; k <= j; k++) {
                indices.push_back(arr[k].second);
            }
            
            // Sort indices so we place smallest values at smallest indices
            sort(indices.begin(), indices.end());
            
            // Assign sorted values (arr[i..j].first, already sorted) 
            // to sorted indices
            for (int k = 0; k < indices.size(); k++) {
                result[indices[k]] = arr[i + k].first;
            }
            
            // Move to next group
            i = j + 1;
        }
        
        return result;
    }
};
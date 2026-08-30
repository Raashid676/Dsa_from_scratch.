class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
        int n = nums.size();
        int minIdx = 0, maxIdx = 0;

        // Find index of min and max
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIdx]) minIdx = i;
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }

        int a = min(minIdx, maxIdx); // earlier index
        int b = max(minIdx, maxIdx); // later index

        int removeFront = b + 1;              // remove both from front
        int removeBack  = n - a;               // remove both from back
        int removeBoth  = (a + 1) + (n - b);   // remove a from front, b from back

        return min({removeFront, removeBack, removeBoth});
    }
};
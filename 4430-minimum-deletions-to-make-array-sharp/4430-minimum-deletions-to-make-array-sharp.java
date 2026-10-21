
class Solution {
    public int minDeletions(int[] nums) {
        int deletions = 0;
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                deletions++;
            } else {
                prev = nums[i];
            }
        }

        return deletions;
    }
}
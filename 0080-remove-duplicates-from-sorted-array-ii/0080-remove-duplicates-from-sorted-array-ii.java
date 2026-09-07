


class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        if (n <= 2) return n;

        int l = 2;  // write pointer
        int r = 2;  // read/scan pointer

        while (r < n) {
            if (nums[r] != nums[l - 2]) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }

        return l;
    }
}
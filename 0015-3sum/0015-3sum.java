

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = n - 1;

            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];

                if (sum > 0) {
                    r--;
                }

                else if (sum < 0) {
                    l++;
                }

                else {

                    // Found a valid triplet
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    l++;
                    r--;

                    // Skip duplicate left values
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }

                    // Skip duplicate right values
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
            }
        }

        return ans;
    }
}
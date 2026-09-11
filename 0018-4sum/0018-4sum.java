class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate second elements
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int start = j + 1;
                int end = n - 1;
                while (start < end) {
                    long sum = (long) nums[i]+nums[j]+nums[start]+nums[end];

                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));

                        start++;
                        end--;
                        // Skip duplicate elements
                        while (start < end && nums[start] == nums[start - 1]) 
                            start++;
                        // Skip duplicate elements
                        while (start < end && nums[end] == nums[end + 1]) 
                            end--;
                    } else if (sum < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return ans;
    }
}
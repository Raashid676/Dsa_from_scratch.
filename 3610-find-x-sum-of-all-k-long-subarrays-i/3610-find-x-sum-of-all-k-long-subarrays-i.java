class Solution {
    public int[] findXSum(int[] nums, int k, int x) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int start = 0; start <= n - k; start++) {

            // Frequency array because nums[i] <= 50
            int[] freq = new int[51];

            // Count frequencies in current window
            for (int i = start; i < start + k; i++) {
                freq[nums[i]]++;
            }

            // Store (value, frequency)
            List<int[]> list = new ArrayList<>();

            for (int value = 1; value <= 50; value++) {
                if (freq[value] > 0) {
                    list.add(new int[]{value, freq[value]});
                }
            }

            // Sort:
            // Higher frequency first
            // If same frequency, bigger value first
            Collections.sort(list, (a, b) -> {
                if (a[1] != b[1]) {
                    return b[1] - a[1];
                }
                return b[0] - a[0];
            });

            int sum = 0;

            // Keep top x elements
            for (int i = 0; i < Math.min(x, list.size()); i++) {
                sum += list.get(i)[0] * list.get(i)[1];
            }

            ans[start] = sum;
        }

        return ans;
    }
}
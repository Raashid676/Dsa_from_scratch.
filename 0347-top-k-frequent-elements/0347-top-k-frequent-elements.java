class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Min Heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>(
                    (a, b) -> Integer.compare(a.getValue(), b.getValue())
                );

        // Keep only top k frequent elements
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];
        int i = 0;

        while (!pq.isEmpty()) {
            ans[i++] = pq.poll().getKey();
        }

        return ans;
    }
}
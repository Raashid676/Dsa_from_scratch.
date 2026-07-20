

class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> pq =  new PriorityQueue<>(Collections.reverseOrder());

               
        for (int[] row : matrix) {
            for (int num : row) {

                pq.offer(num);

                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }
}
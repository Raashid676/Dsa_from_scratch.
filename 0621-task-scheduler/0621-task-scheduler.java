class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int f : freq) {
            if (f > 0)
                pq.offer(f);
        }

        int time = 0;

        while (!pq.isEmpty()) {

            List<Integer> temp = new ArrayList<>();

            int k = n + 1;

            while (k > 0 && !pq.isEmpty()) {

                int cnt = pq.poll() - 1;

                if (cnt > 0)
                    temp.add(cnt);

                time++;
                k--;
            }

            for (int x : temp)
                pq.offer(x);

            if (pq.isEmpty())
                break;

            time += k;
        }

        return time;
    }
}
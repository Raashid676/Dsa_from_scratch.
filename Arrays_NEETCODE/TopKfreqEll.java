package Arrays_NEETCODE;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKfreqEll {
    class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        //countFreqOF each ell
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //push min heap maintain sizek
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int element = entry.getKey();
            int frequency = entry.getValue();

            pq.offer(new int []{frequency, element});
            if (pq.size() > k){
                pq.poll();
            }
        }

        //pick all top elements

        int[] result = new int [k];
        int idx = 0;

        while(!pq.isEmpty()){
            result[idx++] = pq.poll()[1];
        }

        return result;
        
    }
}
    
}

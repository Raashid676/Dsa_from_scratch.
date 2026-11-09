import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Servers {
    

class Solution {
    private record State(int time, int id) {}; 
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
       
        TreeSet<Integer> available = new TreeSet<>(); 

        for(int i = 0; i < k; i++) available.add(i); 
        PriorityQueue<State> busy = new PriorityQueue<>((a, b) -> 
        Integer.compare(a.time, b.time)); 

        int cnt[] = new int[k]; 
        int mx = 0; 
        for(int i = 0; i < arrival.length; i++) {
            while(!busy.isEmpty() && busy.peek().time <= arrival[i]) {
               
                int id = busy.poll().id; // remove 
                available.add(id);  // add 
            }

            if(available.isEmpty()) continue; // drop the request 

            Integer serverId = available.ceiling(i % k); 
            if(serverId == null) serverId = available.first(); 
            // find the next available server for the current 
            cnt[serverId]++; 
            mx = Math.max(mx, cnt[serverId]); 
            busy.add(new State(arrival[i] + load[i], serverId)); 
            available.remove(serverId); // remove from available list 
        }
        List<Integer> ans = new ArrayList<>(); 
        for(int i = 0; i < k; i++) if(cnt[i] == mx) ans.add(i); 
        return ans; 
    }
}
}

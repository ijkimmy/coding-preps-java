/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

import java.util.Queue;
import java.util.LinkedList;

// 15m
public class leetcode_md_362_hitcounter {
    final int min5 = 300;
    Queue<Integer> counter;

    public leetcode_md_362_hitcounter() {
        counter = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        counter.offer(timestamp);
        clean(timestamp);
    }
    
    public int getHits(int timestamp) {
        clean(timestamp);
        return counter.size();
    }

    public void clean(int timestamp){
        while(counter.size() > 0 && (timestamp - counter.peek()) >= min5)
            counter.poll();
    }
}

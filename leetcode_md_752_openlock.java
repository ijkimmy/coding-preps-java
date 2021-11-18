import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
public class leetcode_md_752_openlock {

    // 57m
    public int openLock(String[] deadends, String target) {
        // bfs, time: O(d + n^2 * a^n) where a is # of digits(10) and n is # of wheels(4), space: O(a^n +d)
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        q.offer(null);

        HashSet<String> dead = new HashSet<>();
        for(String d: deadends){
            dead.add(d);
        }
        if(!dead.add("0000"))
            return -1;

        int depth = 0;
        while(!q.isEmpty()){
            String curr = q.poll();
            if(curr == null){
                ++depth;
                if(q.peek() != null)
                    q.offer(null);
            } else if(curr.equals(target)){
                return depth;
            } else {
                for(int i=0; i<curr.length(); ++i){
                    for(int add=-1; add<=1; add+=2){
                        int num = (curr.charAt(i)-'0' + add + 10) % 10;
                        String next = curr.substring(0, i) + String.valueOf(num) + curr.substring(i+1);
                        if(!dead.contains(next)){
                            dead.add(next);
                            q.offer(next);
                        }
                    }
                }
            }
        }

        return -1;
    }
}

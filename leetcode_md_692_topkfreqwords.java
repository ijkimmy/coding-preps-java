import java.util.List;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ArrayList;
public class leetcode_md_692_topkfreqwords {
    
    // 28m
    public List<String> topKFrequent(String[] words, int k) {
        // map & minheap, time: O(nlogk), space: O(n)
        HashMap<String, Integer> cntmap = new HashMap<>();
        for(String word: words){
            cntmap.put(word, cntmap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> minheap = new PriorityQueue<>((a,b) -> {
            int cnta = cntmap.get(a), cntb = cntmap.get(b);
            if(cnta != cntb){
                return cnta - cntb;
            }
            
            return b.compareTo(a);
        });

        for(String word: cntmap.keySet()){
            minheap.offer(word);
            if(minheap.size() > k){
                minheap.poll();
            }
        }

        List<String> retval = new ArrayList<>();
        while(!minheap.isEmpty()){
            retval.add(0, minheap.poll());
        }

        return retval;
    }
}

import java.util.HashMap;
// import java.util.PriorityQueue;
import java.util.List;
import java.util.LinkedList;
public class leetcode_md_347_topkfreq {

    // 24m
    public int[] topKFrequent(int[] nums, int k) {
        // // minheap, time: O(nlogk), space: O(n)
        // HashMap<Integer, Integer> cntmap = new HashMap<>();
        // for(int num: nums){
        //     cntmap.put(num, cntmap.getOrDefault(num, 0) + 1);
        // }

        // PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> cntmap.get(a) - cntmap.get(b));
        // for(int num: cntmap.keySet()){
        //     q.offer(num);

        //     if(q.size() > k)
        //         q.poll();
        // }

        // int i=0; 
        // int[] retval = new int[k];
        // while(!q.isEmpty()){
        //     retval[i++] = q.poll();
        // }

        // return retval;



        // bucket sort, time: O(n), space: O(n)
        int max = 0;
        HashMap<Integer, Integer> cntmap = new HashMap<>();
        for(int num: nums){
            int cnt = cntmap.getOrDefault(num, 0) + 1;
            cntmap.put(num, cnt);
            max = max<cnt ? cnt : max;
        }

        List<Integer>[] bucket = new List[max+1];
        for(int num: cntmap.keySet()){
            int cnt = cntmap.get(num);
            if(bucket[cnt] == null){
                bucket[cnt] = new LinkedList<>();
            }
            bucket[cnt].add(num);
        }

        int retidx = 0;
        int[] retval = new int[k];
        for(int idx=max; idx>=0 && retidx<k; --idx){
            if(bucket[idx] == null)
                continue;
            
            for(int num: bucket[idx]){
                retval[retidx++] = num;
            }
        }

        return retval;
    }
}

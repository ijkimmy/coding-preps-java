// import java.util.PriorityQueue;
public class leetcode_md_1094_carpooling {

    // 35m
    public boolean carPooling(int[][] trips, int capacity) {
        // // sorting, time: O(nlogn), space: O(n)
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
        //     int comp = a[0]-b[0];
        //     if(comp != 0) return comp;
        //     return a[1]-b[1];
        // });
        // for(int[] trip: trips){
        //     pq.offer(new int[]{trip[1], trip[0]});
        //     pq.offer(new int[]{trip[2], -trip[0]});
        // }

        // int numpass = 0;
        // while(!pq.isEmpty()){
        //     numpass += pq.poll()[1];
        //     if(numpass > capacity) return false;
        // }
        // return true;



        // use int[1001] as boundary of from-to is 0~1000, time: O(max(n,m)), space: O(m), where m=1001
        final int boundary = 1001;
        int[] range = new int[boundary];
        for(int[] trip: trips){
            range[trip[1]] += trip[0];
            range[trip[2]] -= trip[0];
        }

        for(int i=0; i<range.length; ++i){
            capacity -= range[i];
            if(0 < capacity) return false;
        }
        
        return true;
    }
}

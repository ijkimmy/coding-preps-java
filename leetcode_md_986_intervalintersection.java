// import java.util.PriorityQueue;
import java.util.LinkedList;
public class leetcode_md_986_intervalintersection {

    // 33m
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // // priority queue implementation, time: O((n+m)log(n+m)), space: O(n+m)
        // if(firstList.length == 0 || secondList.length == 0) return new int[0][0];

        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        // for(int[] l: firstList)
        //     pq.offer(l);
        // for(int[] l: secondList)
        //     pq.offer(l);

        // int[] prev = pq.poll();
        // LinkedList<int[]> retval = new LinkedList<>();
        // while(!pq.isEmpty()){
        //     int[] curr = pq.poll();

        //     int start = Math.max(prev[0], curr[0]);
        //     int end = Math.min(prev[1], curr[1]);
            
        //     if(start <= end){
        //         retval.add(new int[] { start, end });
        //     }

        //     prev = curr[1] > prev[1] ? curr : prev;
        // }

        // return retval.toArray(new int[0][]);


        // linear solution, time: O(n+m), space: O(n+m) <- return value
        if(firstList.length == 0 || secondList.length == 0) return new int[0][0];

        int idx1 = 0, idx2 = 0;
        LinkedList<int[]> retval = new LinkedList<>();
        while(idx1 < firstList.length && idx2 < secondList.length){
            int start = Math.max(firstList[idx1][0], secondList[idx2][0]);
            int end = Math.min(firstList[idx1][1], secondList[idx2][1]);

            if(start <= end){
                retval.add(new int[] { start, end });
            }

            if(firstList[idx1][1] < secondList[idx2][1])
                ++idx1;
            else
                ++idx2;
        }

        return retval.toArray(new int[0][]);
    }
}

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
public class leetcode_md_1057_campusbikes {

    // 54m
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        // // priority queue, time: O(mnlogmn), space: O(mn)
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
        //     int mcomp = a[0] - b[0];
        //     if(mcomp!=0) return mcomp;
        //     int wcomp = a[1] - b[1];
        //     if(wcomp!=0) return wcomp;
        //     return a[2]- b[2];
        // });

        // for(int i=0; i<workers.length; ++i){
        //     for(int j=0; j<bikes.length; ++j){
        //         int mdist = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
        //         pq.offer(new int[] { mdist, i, j });
        //     }
        // }

        // int[] retval = new int[workers.length];
        // Arrays.fill(retval, -1);
        // HashSet<Integer> taken = new HashSet<>();
        // while(!pq.isEmpty() && taken.size() < workers.length){
        //     int[] curr = pq.poll();
        //     if(retval[curr[1]] == -1 && !taken.contains(curr[2])){
        //         retval[curr[1]] = curr[2];
        //         taken.add(curr[2]);
        //     }
        // }

        // return retval;



        // bucket sort, time: O(mn), space: O(mn)
        // use the fact that 0<=x_i, y_i<1000, mindist = 1, maxdist = 999+999 = 1998
        final int drange = 2000;
        List<int[]>[] bucket = new List[drange];

        for(int i=0; i<workers.length; ++i){
            for(int j=0; j<bikes.length; ++j){
                int mdist = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                if(bucket[mdist] == null) bucket[mdist] = new ArrayList<>();
                bucket[mdist].add(new int[] { i, j });
            }
        }

        HashSet<Integer> taken = new HashSet<>();
        int[] retval = new int[workers.length];
        Arrays.fill(retval, -1);
        for(int d=0; d<drange; ++d){
            if(bucket[d] == null) continue;
            for(int[] pair: bucket[d]){
                if(retval[pair[0]] == -1 && !taken.contains(pair[1])){
                    retval[pair[0]] = pair[1];
                    taken.add(pair[1]);
                }
                if(taken.size()==workers.length)
                    return retval;
            }
        }

        return retval;
    }
}
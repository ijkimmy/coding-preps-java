import java.util.Arrays;
// import java.util.PriorityQueue;
public class leetcode_md_973_kclosestorigin {

    // 56m
    public int[][] kClosest(int[][] points, int k) {
        // brute force, time: O(nlogn), space: O(1)
        // Arrays.sort(points, (a,b)->(a[0]*a[0] + a[1]*a[1])-(b[0]*b[0] + b[1]*b[1])); 
        // return Arrays.copyOf(points, k);


        // max heap solution, time: O(nlogk), space:O(k)
        // if(k==points.length) return points;

        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->
        //     (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])  // euclidean dist, decreasing for poll()
        // );
        // for(int[] pt: points){
        //     pq.offer(pt);
        //     if(pq.size() > k)
        //         pq.poll();
        // }

        // int[][] retval = new int[k][2];
        // while(k>0 && !pq.isEmpty())
        //     retval[--k] = pq.poll();

        // return retval;


        // quick sort, time: O(n), space: O(1)
        if(k==points.length) return points;

        int lo = 0, hi = points.length-1;
        while(lo <= hi){
            int pivot = quicksort(points, lo, hi);
            if(pivot == k) break;
            else if(pivot < k) lo = pivot+1;
            else hi = pivot-1;
        }

        return Arrays.copyOf(points, k);
    }

    public int quicksort(int[][] arr, int lo, int hi){
        int[] pivot = arr[lo];
        int pdist = dist(pivot);
        while(lo < hi){
            while(lo<hi && dist(arr[hi]) >= pdist) --hi;
            arr[lo] = arr[hi];
            while(lo<hi && dist(arr[lo]) <= pdist) ++lo;
            arr[hi] = arr[lo]; 
        }
        arr[lo] = pivot;
        return lo;
    }

    public int dist(int[] pt){
        return pt[0]*pt[0] + pt[1]*pt[1];
    }
}

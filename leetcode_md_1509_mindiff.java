import java.util.Arrays;
// import java.util.PriorityQueue;
public class leetcode_md_1509_mindiff {

    // 67m
    public int minDifference(int[] nums) {
        // // partial sorting, time: O(nlogk), space: O(k)
        // final int kplus1 = 4;
        // if(nums.length <= kplus1) return 0;

        // PriorityQueue<Integer> minq = new PriorityQueue<>((a,b) -> b-a);
        // PriorityQueue<Integer> maxq = new PriorityQueue<>((a,b) -> a-b);
        // for(int num: nums){
        //     minq.offer(num); if(minq.size() > 4) minq.poll();
        //     maxq.offer(num); if(maxq.size() > 4) maxq.poll();
        // }

        // int idx = 0;
        // int[] diff = new int[kplus1];
        // while(!minq.isEmpty() && !maxq.isEmpty()){
        //     diff[idx++] += minq.poll();
        //     diff[kplus1-idx] += maxq.poll();
        // }

        // int min = diff[0];
        // for(int d: diff){
        //     min = min > d ? d : min;
        // }

        // return min;



        // sorting, time: O(nlogn), space: O(logn)
        // somehow this solution outperforms in terms of time
        int n = nums.length;
        if(n <= 4) return 0;

        Arrays.sort(nums);

        int l = 0, r = n - 4, min = nums[r] - nums[l];
        while(r < n-1){
            min = Math.min(min, nums[++r] - nums[++l]);
        }

        return min;
    }
}

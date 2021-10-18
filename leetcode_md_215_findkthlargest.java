// import java.util.PriorityQueue;
public class leetcode_md_215_findkthlargest {

    // 48m
    public int findKthLargest(int[] nums, int k) {
        // // min heap, time: O(nlogk), space: O(k)
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        // for(int n: nums){
        //     pq.offer(n);
        //     if(pq.size() > k)
        //         pq.poll();
        // }

        // return pq.poll();



        // quick sort, time: O(n)-avg and O(n^2)-wrtc, space: O(1)
        if(nums.length == 1) return nums[0];

        k = nums.length - k;
        int lo = 0, hi = nums.length-1;
        while(lo < hi){
            int pivot = quicksort(lo, hi, nums);
            if(pivot == k) return nums[pivot];
            else if(k > pivot) lo = pivot+1;
            else hi = pivot-1;
        }

        return nums[k];
    }

    public int quicksort(int lo, int hi, int[] nums){
        int pivot = nums[lo];
        while(lo < hi){
            while(lo<hi && nums[hi] >= pivot) hi--;
            nums[lo] = nums[hi];
            while(lo<hi && nums[lo] <= pivot) lo++;
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }
}

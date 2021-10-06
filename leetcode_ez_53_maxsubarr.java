public class leetcode_ez_53_maxsubarr {

    // 38m
    public int maxSubArray(int[] nums) {
        // // Dynamic Programming, time: O(N), space: O(1) 
        // int curr = nums[0], best = nums[0];
        // for(int i=1; i<nums.length; ++i){
        //     curr = Math.max(nums[i], curr+nums[i]);
        //     best = Math.max(curr, best);
        // }
        // return best;

        // Divide and Conquer, time: O(NlogN), space: O(logN)
        return divide(nums, 0, nums.length-1);
    }

    public int divide(int[] arr, int left, int right){
        if(left > right) return Integer.MIN_VALUE;

        int mid = left + (right - left)/2;
        int lsub = 0, rsub = 0, curr = 0;
        for(int i=mid-1; i>=left; --i){
            curr += arr[i];
            lsub = Math.max(lsub, curr);
        }
        curr = 0;
        for(int i=mid+1; i<=right; ++i){
            curr += arr[i];
            rsub = Math.max(rsub, curr);
        }

        int max = lsub + arr[mid] + rsub;

        // here, max is the case where arr[mid] is included in max sub arr
        // divide(arr, left, mid-1): max sub arr happening left of arr[mid]
        // divide(arr, mid+1, right): max sub arr happening right of arr[mid]
        return Math.max(max, Math.max(divide(arr, left, mid-1), divide(arr, mid+1, right)));
    }
}

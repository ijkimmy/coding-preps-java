// import java.util.Arrays;

public class leetcode_ez_628_maxproduct3num {

    // 36m
    public int maximumProduct(int[] nums) {
        // // sorting, time: O(nlogn), space: O(logn) < sorting space
        // Arrays.sort(nums);

        // int n = nums.length;
        // return nums[n-1] * Math.max(nums[n-2] * nums[n-3], nums[0] * nums[1]);


        // linear scan, time: O(n), space: O(1)
        int min0 = Integer.MAX_VALUE, min1 = Integer.MAX_VALUE;
        int max0 = Integer.MIN_VALUE, max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; ++i){
            if(nums[i] <= min0){
                min1 = min0;
                min0 = nums[i];
            }
            else if(nums[i] <= min1)
                min1 = nums[i];
            
            if(nums[i] >= max0){
                max2 = max1;
                max1 = max0;
                max0 = nums[i];
            } 
            else if(nums[i] >= max1){
                max2 = max1;
                max1 = nums[i];
            }
            else if(nums[i] >= max2)
                max2 = nums[i];
        }

        return Math.max(min0*min1*max0, max0*max1*max2); // here max0 multiplication must be inside
    } 
}

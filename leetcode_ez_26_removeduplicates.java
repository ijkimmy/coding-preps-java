import java.util.Arrays;

public class leetcode_ez_26_removeduplicates {

    // 32m
    public int removeDuplicates(int[] nums) {
        // // linear scanning solution, time: O(N)
        // if(nums.length < 2) return nums.length;
        // if(nums[0] == nums[nums.length-1]) return 1;
        // int uniqidx = 1, num = nums[0];
        // for(int i=1; i<nums.length; ++i){
        //     if(num != nums[i]){
        //         if(uniqidx != i)
        //             nums[uniqidx] = nums[i];
        //         ++uniqidx;
        //     }
        //     num = nums[i];
        // }
        // return uniqidx;


        // binary search solution
        // this solution is only better when range of values in nums is strictly less than length of array
        if(nums.length < 2) return nums.length;

        int min = nums[0], max = nums[nums.length-1], arridx = 1;
        if(min == max) return nums.length;
        for(int i=min+1; i<=max; ++i){
            int searchkey = Arrays.binarySearch(nums, i);
            if(searchkey > 0 && nums[searchkey] == i){
                nums[arridx++] = i;
            }
        }
        return arridx;
    }
}

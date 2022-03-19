import java.util.Arrays;
public class leetcode_md_1877_minpairsum {

    // 12m
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        
        int max = -1;
        for(int i=0; i<nums.length; ++i){
            int sum = nums[i] + nums[nums.length-i-1];
            if(max < sum) max = sum;
        }
        return max;
    }
}
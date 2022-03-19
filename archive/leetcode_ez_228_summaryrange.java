import java.util.List;
import java.util.LinkedList;
public class leetcode_ez_228_summaryrange {

    // 26m
    public List<String> summaryRanges(int[] nums) {
        List<String> retval = new LinkedList<>();
        if(nums.length == 0) return retval;
        if(nums.length == 1) {
            retval.add(String.valueOf(nums[0]));
            return retval;
        }

        int prev = nums[0], pidx = 0;
        for(int i=1; i<nums.length; ++i){
            long diff = nums[i] - prev;
            if(diff > 1){
                if(i - pidx == 1)
                    retval.add(String.valueOf(nums[pidx]));
                else
                    retval.add(nums[pidx] + "->" + nums[i-1]);
                
                pidx = i;
            }

            prev = nums[i];
        }

        if(pidx == nums.length-1)
            retval.add(String.valueOf(nums[pidx]));
        else
            retval.add(nums[pidx] + "->" + nums[nums.length-1]);

        return retval;
    }
}

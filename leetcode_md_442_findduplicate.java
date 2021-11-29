import java.util.List;
import java.util.LinkedList;
public class leetcode_md_442_findduplicate {

    // 45m
    public List<Integer> findDuplicates(int[] nums) {
        // mark visited, time: O(n), space: O(1)
        List<Integer> retval = new LinkedList<>();
        
        for(int num: nums){
            int idx = Math.abs(num)-1;
            if(nums[idx] < 0){
                retval.add(idx+1);
            }
            nums[idx] *= -1;
        }

        return retval;
    }
}

import java.util.List;
import java.util.LinkedList;
public class leetcode_md_78_subsetsarr {
    
    // 28m
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> retval = new LinkedList<>();
        for(int i=0; i<=nums.length; ++i){
            permute(nums, retval, new LinkedList<>(), i, 0);
        }
        return retval;
    }

    public void permute(int[] nums, List<List<Integer>> retval, List<Integer> lst, int len, int start){
        if(len == 0){
            retval.add(new LinkedList<Integer>(lst));
            return;
        }

        for(int i=start; i<nums.length; ++i){
            lst.add(nums[i]);
            permute(nums, retval, lst, len-1, i+1);
            lst.remove(lst.size()-1);
        }
    }
}

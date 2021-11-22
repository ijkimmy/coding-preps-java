import java.util.List;
import java.util.LinkedList;
public class leetcode_md_46_permutation {

    // 26m
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> retval = new LinkedList<>();
        helper(nums, retval, new LinkedList<>(), new boolean[nums.length]);
        return retval;
    }

    public void helper(int[] nums, List<List<Integer>> retval, List<Integer> lst, boolean[] used){
        if(lst.size() == nums.length){
            retval.add(new LinkedList<>(lst));
            return;
        }

        for(int i=0; i<nums.length; ++i){
            if(!used[i]){
                lst.add(nums[i]);
                used[i] = true;
                helper(nums, retval, lst, used);
                lst.remove(lst.size()-1);
                used[i] = false;
            }
        }
    }
}

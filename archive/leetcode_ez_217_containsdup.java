import java.util.HashSet;
public class leetcode_ez_217_containsdup {

    // 5m
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            if(!set.add(num)) return true;
        }
        return false;
    }
}

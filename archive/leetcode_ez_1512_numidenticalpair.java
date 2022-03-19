import java.util.HashMap;
public class leetcode_ez_1512_numidenticalpair {

    // 13m 
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        
        int retval = 0;
        for(int key: map.keySet()){
            int val = map.get(key);
            if(val > 1){
                retval += val * (val-1) / 2;
            }
        }

        return retval;
    }
}

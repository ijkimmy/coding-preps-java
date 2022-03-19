import java.util.HashMap;
import java.util.LinkedList;
public class leetcode_ez_350_intersect2arr {

    // 20m
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n1: nums1)
            map.put(n1, map.getOrDefault(n1, 0)+1);
        
        LinkedList<Integer> lretval = new LinkedList<>();
        for(int n2: nums2){
            if(map.containsKey(n2) && map.get(n2) > 0){
                lretval.add(n2);
                map.put(n2, map.get(n2)-1);
            }
        }

        int idx = 0;
        int[] retval = new int[lretval.size()];
        for(int val: lretval)
            retval[idx++] = val;
        
        return retval;
    }
}

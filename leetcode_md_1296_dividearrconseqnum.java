import java.util.TreeMap;
public class leetcode_md_1296_dividearrconseqnum {

    // 35m
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length; 
        if(n % k != 0)
            return false;
        if(n == k) 
            return true;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for(int num: map.keySet()){
            if(map.get(num) > 0) {
                for(int i=4; i>=0; --i){
                    if(map.getOrDefault(num+i, 0) < map.get(num)) return false;
                    map.put(num+i, map.get(num+i) - map.get(num));
                }                
            }
        }

        return true;
    }
}

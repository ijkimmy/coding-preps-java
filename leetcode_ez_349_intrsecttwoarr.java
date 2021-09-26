import java.util.HashSet;
public class leetcode_ez_349_intrsecttwoarr {

    // 15m
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> retval = new HashSet<>();

        for(int n1: nums1)
            set.add(n1);

        for(int n2: nums2){
            if(set.contains(n2))
                retval.add(n2);
        }

        int idx = 0;
        int[] ans = new int[retval.size()];
        for(int n: retval){
            ans[idx++] = n;
        }
        
        return ans;
    }
}

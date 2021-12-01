import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
public class leetcode_md_1272_removeintervals {

    // 58m
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        // single pass, time: O(n), space: O(1);
        List<List<Integer>> retval = new LinkedList<>();

        int ra = toBeRemoved[0], rb = toBeRemoved[1];
        for(int i=0; i<intervals.length; ++i){
            int a = intervals[i][0], b = intervals[i][1];

            if(rb <= a || ra >= b){
                retval.add(Arrays.asList(a, b));
            } else {
                if(a < ra){
                    retval.add(Arrays.asList(a, ra));
                }
                if(rb < b){
                    retval.add(Arrays.asList(rb, b));
                }
            }
        }

        return retval;
    }
}

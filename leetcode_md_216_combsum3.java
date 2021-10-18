import java.util.List;
import java.util.LinkedList;
public class leetcode_md_216_combsum3 {

    // 36m
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> retval = new LinkedList<>();
        if(n>45) return retval;
        permute(k, n, new LinkedList<>(), retval, 1);
        return retval;
    }

    public void permute(int k, int n, List<Integer> lst, List<List<Integer>> retval, int idx) {
        if(lst.size() == k){
            if(n == 0)
                retval.add(new LinkedList<>(lst));
            return;
        }
        if(n < 0) return;

        for(int i=idx; i<10; ++i){
            lst.add(i);
            permute(k, n-i, lst, retval, i+1);
            lst.remove(lst.size()-1);
        }
    }
}

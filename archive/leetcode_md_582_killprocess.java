import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
public class leetcode_md_582_killprocess {

    // 20m
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // map & dfs, time: O(n), space: O(n)
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0; i<pid.size(); ++i){
            int id = pid.get(i), idp = ppid.get(i);
            if(idp == 0)
                continue;
            if(!adj.containsKey(idp))
                adj.put(idp, new ArrayList<>());
            adj.get(idp).add(id);
        }

        List<Integer> retval = new LinkedList<>();
        dfs(adj, kill, retval);

        return retval;
    }

    public void dfs(HashMap<Integer, List<Integer>> adj, int curr, List<Integer> retval){
        retval.add(curr);

        if(!adj.containsKey(curr))
            return;
        for(int neighbor: adj.get(curr)){
            dfs(adj, neighbor, retval);
        }
    }
}

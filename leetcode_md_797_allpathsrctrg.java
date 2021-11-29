import java.util.List;
import java.util.LinkedList;
public class leetcode_md_797_allpathsrctrg {

    // 16m
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        g = graph;
        lst = new LinkedList<>();

        List<Integer> path = new LinkedList<>();
        path.add(0);
        
        dfs(0, path);
        return lst;
    }

    int[][] g;
    List<List<Integer>> lst;
    public void dfs(int curr, List<Integer> path){
        if(curr == g.length-1){
            lst.add(new LinkedList<>(path));
            return;
        }

        for(int next: g[curr]){
            path.add(next);
            dfs(next, path);
            path.remove(path.size()-1);
        }
    }
}

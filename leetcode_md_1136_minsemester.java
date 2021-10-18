import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
public class leetcode_md_1136_minsemester {

    // 83m
    public int minimumSemesters(int n, int[][] relations) {
        // // dfs, time: O(V+E), space: O(V+E)
        // HashMap<Integer, List<Integer>> g = new HashMap<>();
        // for(int[] r: relations){
        //     if(!g.containsKey(r[0])) g.put(r[0], new LinkedList<>());
        //     g.get(r[0]).add(r[1]);
        // }

        // int max = 0;
        // int[] visited = new int[n+1];
        // for(int i=1; i<=n; ++i){
        //     int path = dfs(g, i, visited);
        //     if(path == -1) return -1;
        //     max = path > max ? path : max;
        // }

        // return max; 



        // bfs, time: O(V+E), space: O(V+E)
        int[] deg = new int[n+1];
        HashMap<Integer, List<Integer>> g = new HashMap<>();
        for(int[] r: relations){
            if(!g.containsKey(r[0])) g.put(r[0], new LinkedList<>());
            g.get(r[0]).add(r[1]);
            ++deg[r[1]];
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; ++i)
            if(deg[i] == 0) q.offer(i);
        
        int semester = 0;
        while(!q.isEmpty()){
            for(int iter=q.size(); iter>0; --iter){
                int curr = q.poll();
                --n;
                if(!g.containsKey(curr)) continue;
                for(int next: g.get(curr))
                    if(--deg[next] == 0)
                        q.offer(next);
            }
            ++semester;
        }

        return n==0? semester: -1;
    }

    public int dfs(HashMap<Integer, List<Integer>> g, int pos, int[] v){
        if(v[pos] != 0) return v[pos];

        v[pos] = -1;
        int maxpath = 1;
        if(g.containsKey(pos)){
            for(int neighbor: g.get(pos)){
                int p = dfs(g, neighbor, v);
                if(p == -1) return -1;
                maxpath = Math.max(maxpath, p+1);
            }
        }
        v[pos] = maxpath;

        return maxpath;
    }

}

// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.Queue;
import java.util.List;
public class leetcode_md_1376_numofmin {

    // 45m
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // // bfs, time: O(n), space: O(n)
        // List<Integer>[] tree = new List[n];
        // for(int i=0; i<n; ++i){
        //     if(i==headID) continue;
        //     if(tree[manager[i]] == null) tree[manager[i]] = new ArrayList<>();
        //     tree[manager[i]].add(i);
        // }

        // int maxtime = 0;
        // Queue<int[]> q = new LinkedList<>();
        // q.offer(new int[] { headID, 0 });
        // while(!q.isEmpty()){
        //     int[] curr = q.poll();
        //     maxtime = maxtime < curr[1] ? curr[1] : maxtime;

        //     if(tree[curr[0]] == null) continue;
        //     for(int id: tree[curr[0]]){
        //         q.offer(new int[] { id, curr[1] + informTime[curr[0]]});
        //     }
        // }
        // return maxtime;



        // // top-down dfs, time: O(n), space: O(n)
        // List<Integer>[] tree = new List[n];
        // for(int i=0; i<n; ++i){
        //     if(i==headID) continue;
        //     if(tree[manager[i]] == null) tree[manager[i]] = new ArrayList<>();
        //     tree[manager[i]].add(i);
        // }

        // return topdowndfs(tree, headID, informTime);



        // bottom-up dfs, time: O(n), space: O(1)
        int max = 0;
        for(int i=0; i<n; ++i)
            max = Math.max(max, bottomupdfs(manager, informTime, i));
        return max;
    }

    public int bottomupdfs(int[] m, int[] t, int i){
        if(m[i] != -1){
            t[i] += bottomupdfs(m, t, m[i]);
            m[i] = -1;
        }
        return t[i];
    }

    public int topdowndfs(List<Integer>[] g, int id, int[] time){
        if(g[id] == null) return 0;

        int max = 0;
        for(int next: g[id]){
            max = Math.max(max, topdowndfs(g, next, time));
        }
        max += time[id];

        return max;
    }
}

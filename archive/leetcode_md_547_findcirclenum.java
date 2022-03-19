// import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
public class leetcode_md_547_findcirclenum {
    
    // 35m
    public int findCircleNum(int[][] isConnected) {
        // // union-find, time: O(n^3), space: O(n)
        // int n = isConnected.length;
        // prov = new int[n];
        // for(int i=0; i<n; ++i) prov[i] = i;

        // for(int i=0; i<n; ++i){
        //     for(int j=i+1; j<n; ++j){
        //         if(isConnected[i][j] == 1){
        //             union(i, j);
        //         }
        //     }
        // }

        // HashSet<Integer> set = new HashSet<>();
        // for(int i=0; i<n; ++i)
        //     set.add(find(i));
        // return set.size();



        // // dfs, time: O(n^2), space: O(n)
        // int retval = 0;
        // int n = isConnected.length;
        // boolean[] visited = new boolean[n];
        // for(int i=0; i<n; ++i){
        //     if(!visited[i]) {
        //         dfs(i, visited, isConnected);
        //         ++retval;
        //     }
        // }
        // return retval;



        // bfs, time: O(n^2), space: O(n)
        int retval = 0;
        int n = isConnected.length; 
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; ++i){
            if(!visited[i]){
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while(!q.isEmpty()){
                    int curr = q.poll();
                    visited[curr] = true;
                    for(int j=0; i<isConnected[curr].length; ++j){
                        if(!visited[j] && isConnected[curr][j] == 1)
                            q.offer(j);
                    }
                }
                ++retval;
            }
        }

        return retval;
    }

    public void dfs(int curr, boolean[] v, int[][] g){
        v[curr] = true;
        for(int i=0; i<g[curr].length; ++i){
            if(!v[i] && g[curr][i] == 1)
                dfs(i, v, g);
        }
    }

    int[] prov;

    public void union(int x, int y){
        x = find(x);
        y = find(y);
        prov[y] = x;
    }

    public int find(int x){
        if(prov[x] != x)
            prov[x] = find(prov[x]);
        return prov[x];
    }
}

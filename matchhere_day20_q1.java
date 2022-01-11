import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
public class matchhere_day20_q1 {
    public static void main(String[] args){
        // BJ 1260
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String[] nmv = bf.readLine().split(" ");
            int n = Integer.parseInt(nmv[0]), m = Integer.parseInt(nmv[1]), v = Integer.parseInt(nmv[2]);

            int[][] g = new int[n+1][n+1];
            for(int i=0; i<m; ++i){
                String[] tokens = bf.readLine().split(" ");

                int v0 = Integer.parseInt(tokens[0]), v1 = Integer.parseInt(tokens[1]);
                g[v0][v1] = g[v1][v0] = 1;
            }
            bf.close();

            dfs(g, v, new boolean[n+1]);
            System.out.println();
            bfs(g, v);

        } catch(IOException e){
            System.out.print(e);
        }
    }

    public static void dfs(int[][] g, int v, boolean[] visited){
        System.out.print(v + " ");

        visited[v] = true;
        for(int i=0; i<g[v].length; ++i){
            if(g[v][i] == 1 && !visited[i]){
                dfs(g, i, visited);
            }
        }
    }

    public static void bfs(int[][] g, int v){
        boolean[] visited = new boolean[g.length+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;

        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr + " ");

            for(int i=0; i<g[curr].length; ++i){
                if(g[curr][i] == 1 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}

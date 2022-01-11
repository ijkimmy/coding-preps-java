import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
public class matchhere_day21_q1 {
    public static void main(String[] args){
        // BJ 1753
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String[] ve = bf.readLine().split(" ");
            int v = Integer.parseInt(ve[0]), e = Integer.parseInt(ve[1]);
            int k = Integer.parseInt(bf.readLine());

            PriorityQueue<Node>[] adj = new PriorityQueue[v+1];
            for(int i=1; i<=v; ++i)
                adj[i] = new PriorityQueue<>();

            for(int i=0; i<e; ++i){
                String[] edge = bf.readLine().split(" ");
                int from = Integer.parseInt(edge[0]), to = Integer.parseInt(edge[1]), w = Integer.parseInt(edge[2]);
                
                adj[from].offer(new Node(to, w));
            }
            bf.close();

            int[] mindist = new int[v+1];
            Arrays.fill(mindist, -1);
            mindist[k] = 0;

            while(!adj[k].isEmpty()){
                Node curr = adj[k].poll();

                if(mindist[curr.dst] != -1)
                    continue;
                mindist[curr.dst] = curr.weight;

                for(Node adjnode : adj[curr.dst]){
                    adj[k].offer(new Node(adjnode.dst, curr.weight + adjnode.weight));
                }
            }

            for(int i=1; i<mindist.length; ++i){
                if(mindist[i] == -1)
                    System.out.println("INF");
                else
                    System.out.println(mindist[i]);
            }
        } catch(IOException e){
            System.out.print(e);
        }
    }

    static class Node implements Comparable<Node>{
        int dst, weight;
        public Node(int dst, int weight){
            this.dst = dst;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other){
            return this.weight - other.weight;
        }
    }
}


/*
import java.io.*;
public class matchhere_day21_q1 {
    public static void main(String[] args){
        // BJ 1753
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String[] ve = bf.readLine().split(" ");
            int v = Integer.parseInt(ve[0]), e = Integer.parseInt(ve[1]);
            int k = Integer.parseInt(bf.readLine());

            int[][] g = new int[v+1][v+1];
            for(int i=0; i<e; ++i){
                String[] edge = bf.readLine().split(" ");
                int from = Integer.parseInt(edge[0]), to = Integer.parseInt(edge[1]), w = Integer.parseInt(edge[2]);
                
                g[from][to] = w;
            }

            int[] mindist = new int[g.length];
            dijkstra(g, k, mindist);

            for(int i=1; i<mindist.length; ++i){
                if(mindist[i] == Integer.MAX_VALUE)
                    System.out.println("INF");
                else
                    System.out.println(mindist[i]);
            }
        } catch(IOException e){
            System.out.print(e);
        }
    }

    public static void dijkstra(int[][] g, int src, int[] mindist){
        boolean[] visited = new boolean[g.length];

        for(int i=1; i<g.length; ++i){
            mindist[i] = Integer.MAX_VALUE;
        }
        mindist[src] = 0;

        for(int i=1; i<g.length; ++i){
            int u = findmindist(mindist, visited);
            visited[u] = true;

            for(int adj=1; adj<g[u].length; ++adj){
                // 1. has path
                // 2. not yet visited
                // 3. sum of mindist to u and edge(u, adj) is less than mindist to adj (avoid overflow in advance)
                if(g[u][adj] != 0 && !visited[adj] && mindist[u] != Integer.MAX_VALUE && mindist[u] + g[u][adj] < mindist[adj]){
                    mindist[adj] = mindist[u] + g[u][adj];
                }
            }
        }
    }

    public static int findmindist(int[] mindist, boolean[] visited){
        int min = Integer.MAX_VALUE, minidx = -1;
        for(int i=1; i<mindist.length; ++i){
            if(!visited[i] && mindist[i] <= min){
                min = mindist[i];
                minidx = i;
            }
        }

        return minidx;
    }
}

*/
import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Arrays;
public class matchhere_day21_q2 {
    public static void main(String[] args){
        // BJ 1916
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());
            int m = Integer.parseInt(bf.readLine());

            PriorityQueue<Node>[] adjQ = new PriorityQueue[n+1];
            for(int i=1; i<=n; ++i)
                adjQ[i] = new PriorityQueue<>();

            StringTokenizer st;
            for(int i=0; i<m; ++i){
                st = new StringTokenizer(bf.readLine());
                int src = Integer.parseInt(st.nextToken());
                int dst = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                adjQ[src].offer(new Node(dst, cost));
            }

            st = new StringTokenizer(bf.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            bf.close();

            int[] mindist = new int[n+1];
            Arrays.fill(mindist, -1);
            mindist[src] = 0;

            while(!adjQ[src].isEmpty()){
                Node curr = adjQ[src].poll();

                if(mindist[curr.dst] != -1)
                    continue;
                mindist[curr.dst] = curr.weight;
                
                for(Node adjnode : adjQ[curr.dst]){
                    adjQ[src].offer(new Node(adjnode.dst, curr.weight + adjnode.weight));
                }
            }

            System.out.print(mindist[dst]);
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

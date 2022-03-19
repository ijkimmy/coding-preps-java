import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
public class matchhere_day24_q1 {
    public static void main(String[] args){
        // 1197
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int vsize = Integer.parseInt(st.nextToken()), esize = Integer.parseInt(st.nextToken());
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2]-b[2]);
            for(int i=0; i<esize; ++i){
                st = new StringTokenizer(br.readLine());
                int v0 = Integer.parseInt(st.nextToken());
                int v1 = Integer.parseInt(st.nextToken());
                int e  = Integer.parseInt(st.nextToken());
                pq.offer(new int[] {v0, v1, e});
            }

            int weight = 0;
            UnionFind uf = new UnionFind(vsize+1);
            while(!pq.isEmpty() && uf.size < vsize-1){
                int[] edge = pq.poll();

                if(uf.union(edge[0], edge[1])){
                    weight += edge[2];
                }
            }

            System.out.print(weight);
        } catch(IOException e){
            System.out.print(e);
        }
    }

    static class UnionFind{
        int[] vertices;
        int size;

        public UnionFind(int n){
            vertices = new int[n];

            for(int i=1; i<n; ++i)
                vertices[i] = i;
        }

        public boolean union(int x, int y){
            int fx = find(x);
            int fy = find(y);

            if(fx == fy)
                return false;
            
            vertices[fx] = fy;
            ++size;
            return true;
        }

        public int find(int x){
            if(x != vertices[x]){
                vertices[x] = find(vertices[x]);
            }
            return vertices[x];
        }
    }
}

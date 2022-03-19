import java.io.*;
import java.util.PriorityQueue;
public class matchhere_day16_q2 {
    public static void main(String[] args){
        // BJ 1931
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> {
                int comp = a[0]-b[0];
                if(comp == 0)
                    comp = a[1]-b[1];
                return comp;
            });
            for(int i=0; i<n; ++i){
                String[] tokens = bf.readLine().split(" ");
                pq.offer(new int[] { Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]) });
            }
            bf.close();

            int earliestend = pq.poll()[1], maxcnt = 1;
            while(!pq.isEmpty()){
                int[] curr = pq.poll();

                if(earliestend <= curr[0]){
                    ++maxcnt;
                    earliestend = curr[1];
                } else if(earliestend > curr[1]){
                    earliestend = curr[1];
                }
            }

            System.out.print(maxcnt);
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

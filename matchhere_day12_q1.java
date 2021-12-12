import java.io.*;
import java.util.PriorityQueue;
public class matchhere_day12_q1 {
    public static void main(String[] args){
        // BJ 10814
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());

            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
                int comp = a[0] - b[0];
                if(comp == 0)
                    comp = a[1] - b[1];
                return comp;
            });

            String[] lst = new String[n];
            for(int i=0; i<n; ++i){
                lst[i] = bf.readLine();

                String[] token = lst[i].split(" ");
                int age = Integer.parseInt(token[0]);
                pq.offer(new int[] { age, i });
            }
            bf.close();

            while(!pq.isEmpty()){
                System.out.println(lst[pq.poll()[1]]);
            }
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

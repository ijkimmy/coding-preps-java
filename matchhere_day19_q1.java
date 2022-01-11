import java.io.*;
import java.util.PriorityQueue;
public class matchhere_day19_q1 {
    public static void main(String[] args){
        // BJ 11279
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());

            PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b)->b-a);
            for(int i=0; i<n; ++i){
                int oper = Integer.parseInt(bf.readLine());
                if(oper == 0){
                    if(maxheap.isEmpty())
                        System.out.println("0");
                    else 
                        System.out.println(maxheap.poll());
                } else
                    maxheap.offer(oper);
            }
            bf.close();
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

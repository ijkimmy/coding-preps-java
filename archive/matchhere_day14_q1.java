import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
public class matchhere_day14_q1 {
    
    public static void main(String[] args){
        // BJ 2164
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());
            bf.close();

            Queue<Integer> q = new LinkedList<>();
            for(int i=1; i<=n; ++i)
                q.offer(i);
            
            boolean take = false;
            while(q.size() > 1){
                if(!take)
                    q.poll();
                else
                    q.offer(q.poll());
                take = !take;
            }

            System.out.print(q.poll());
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

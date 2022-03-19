import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class matchhere_day14_q2 {
    public static void main(String[] args){
        // BJ 1021
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String[] nm = bf.readLine().split(" ");
            int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);

            Queue<Integer> q = new LinkedList<>();
            for(int i=1; i<=n; ++i)
                q.offer(i);
            
            int move = 0;
            StringTokenizer st = new StringTokenizer(bf.readLine());
            bf.close();
            for(int i=0; i<m; ++i){
                int get = Integer.parseInt(st.nextToken());
                
                int cnt = 0;
                while(q.peek() != get){
                    q.offer(q.poll());
                    ++cnt;
                }
                move += Math.min(cnt, q.size()-cnt);
                q.poll();
            }
            
            System.out.print(move);
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

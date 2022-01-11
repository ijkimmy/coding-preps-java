import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
public class matchhere_day22_q2 {
    public static void main(String[] args){
        // BJ 1806
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            int sum = 0, minlen = Integer.MAX_VALUE;
            Queue<Integer> q = new LinkedList<>();
            st = new StringTokenizer(bf.readLine());
            bf.close();
            for(int i=0; i<n; ++i){
                int val = Integer.parseInt(st.nextToken());
                sum += val;
                q.offer(val);

                if(sum >= s){
                    while(!q.isEmpty() && sum-q.peek() >= s){
                        sum -= q.poll();
                    }
                    minlen = Math.min(minlen, q.size());
                }
            }

            System.out.print(minlen==Integer.MAX_VALUE ? 0 : minlen);
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

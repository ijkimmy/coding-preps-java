import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;
public class matchhere_day16_q1 {
    public static void main(String[] args){
        // BJ 13305
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());

            int[] dist = new int[n-1];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i=0; i<n-1; ++i){
                dist[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(bf.readLine());
            bf.close();
            
            int mincost = Integer.MAX_VALUE;
            BigInteger totcost = BigInteger.ZERO;
            for(int i=0; i<n-1; ++i){
                int cost = Integer.parseInt(st.nextToken());

                mincost = mincost>cost ? cost : mincost;
                long toadd = (long)mincost * dist[i];
                totcost = totcost.add(BigInteger.valueOf(toadd));
            }
            System.out.print(totcost);
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

import java.io.*;
import java.util.StringTokenizer;
public class matchhere_day2_q2 {
    public static void main(String[] args){
        // BJ 10871
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String[] nxs = bf.readLine().split(" ");
            int n = Integer.parseInt(nxs[0]), x = Integer.parseInt(nxs[1]);
            
            StringTokenizer st = new StringTokenizer(bf.readLine());
            bf.close();
            for(int i=0; i<n; ++i){
                int val = Integer.parseInt(st.nextToken());
                if(val < x){
                    System.out.print(val + " ");
                }
            }
        } catch(IOException e){
            System.out.print(e);
        }    
    }
}

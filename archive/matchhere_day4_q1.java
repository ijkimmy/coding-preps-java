import java.io.*;
import java.util.StringTokenizer;
public class matchhere_day4_q1 {
    public static void main(String[] args){
        // BJ 10818
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());

            StringTokenizer st = new StringTokenizer(bf.readLine());
            bf.close();
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for(int i=0; i<n; ++i){
                int val = Integer.parseInt(st.nextToken());
                min = min>val ? val : min;
                max = max<val ? val : max;
            }
            System.out.print(min + " " + max);
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

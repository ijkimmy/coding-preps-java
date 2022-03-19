import java.io.*;
import java.util.StringTokenizer;
import java.util.HashSet;
public class matchhere_day22_q1 {
    public static void main(String[] args){
        // BJ 3273
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());

            int numpairs = 0;
            HashSet<Integer> set = new HashSet<>();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            
            int sum = Integer.parseInt(bf.readLine());
            bf.close();
            for(int i=0; i<n; ++i){
                int val = Integer.parseInt(st.nextToken());
                if(set.contains(val))
                    ++numpairs;
                set.add(sum-val);
            }
            
            System.out.print(numpairs);
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

import java.io.*;
import java.util.Arrays;
public class matchhere_day8_q1 {
    public static void main(String[] args){
        // BJ 1929
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String[] inputs = bf.readLine().split(" ");
            bf.close();

            int m = Integer.parseInt(inputs[0]), n = Integer.parseInt(inputs[1]);
            boolean[] prime = new boolean[n+1];
            Arrays.fill(prime, true);
            for(int i=2; i<=n; ++i){
                if(!prime[i])
                    continue;
                
                if(i>=m) System.out.println(i);

                for(int j=i+i; j<=n; j+=i){
                    prime[j] = false;
                }
            }
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

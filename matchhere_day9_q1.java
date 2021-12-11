import java.io.*;
import java.util.Arrays;
public class matchhere_day9_q1 {
    public static void main(String[] args){
        // BJ 9020
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int ncase = Integer.parseInt(bf.readLine());

            int max = 0;
            int[] nums = new int[ncase];
            for(int i=0; i<ncase; ++i){
                nums[i] = Integer.parseInt(bf.readLine());
                max = max<nums[i] ? nums[i] : max;
            }
            bf.close();

            boolean[] prime = new boolean[max+1];
            Arrays.fill(prime, true);
            for(int i=2; i<=max; ++i){
                if(!prime[i])
                    continue;
                for(int j=i+i; j<=max; j+=i){
                    prime[j] = false;
                }
            }

            for(int i=0; i<ncase; ++i){
                int val0 = nums[i]/2, val1 = val0;
                while(!prime[val0] || !prime[val1]) {
                    --val0; ++val1;
                }
                System.out.println(val0 + " " + val1);
            }
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

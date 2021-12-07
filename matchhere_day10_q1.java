import java.io.*;
public class matchhere_day10_q1 {
    public static void main(String[] args){
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());

            final int maxf = 21;
            int[] fib = new int[maxf];
            fib[0] = 0; fib[1] = 1;
            for(int i=2; i<=n; ++i){
                fib[i] = fib[i-1] + fib[i-2];
            }
            System.out.print(fib[n]);
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

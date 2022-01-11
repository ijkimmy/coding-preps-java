import java.io.*;
public class matchhere_day17_q1 {
    public static void main(String[] args){
        //BJ 1003
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int numtest = Integer.parseInt(bf.readLine());

            int maxval = 0;
            int[] ns = new int[numtest];
            for(int i=0; i<numtest; ++i){
                ns[i] = Integer.parseInt(bf.readLine());
                maxval = maxval<ns[i] ? ns[i] : maxval;
            }
            bf.close();

            int[][] fib = new int[maxval+1][2];
            fib[0][0] = 1; fib[1][1] = 1;
            for(int i=2; i<fib.length; ++i){
                fib[i][0] = fib[i-1][0] + fib[i-2][0];
                fib[i][1] = fib[i-1][1] + fib[i-2][1];
            }

            for(int i=0; i<ns.length; ++i){
                System.out.println(fib[ns[i]][0] + " "  + fib[ns[i]][1]);
            }
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

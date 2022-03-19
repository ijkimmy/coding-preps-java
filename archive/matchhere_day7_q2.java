import java.io.*;
public class matchhere_day7_q2 {
    public static void main(String[] args){
        // BJ 2839
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());
            bf.close();

            int min = -1;
            for(int q=n/5; q>=0; --q){
                int leftover = n-5*q;
                if(leftover%3 == 0){
                    min = q + leftover/3;
                    break;
                }
            }

            System.out.print(min);
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

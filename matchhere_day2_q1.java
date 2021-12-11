import java.io.*;
public class matchhere_day2_q1 {
    public static void main(String[] args){
        // BJ 2439
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());
            bf.close();

            for(int i=1; i<=n; ++i){
                for(int j=1; j<=n; ++j){
                    if(n-j < i) System.out.print("*");
                    else System.out.print(" ");
                }
                System.out.println();
            }
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

import java.io.*;
public class matchhere_day3_q1 {
    public static void main(String[] args){
        // BJ 1110
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());
            bf.close();

            int cycle = 0, num = n;
            do{
                num = (num%10 * 10) + (num/10 + num%10) % 10;
                ++cycle;
            } while(num != n);

            System.out.print(cycle);
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

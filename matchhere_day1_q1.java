import java.io.*;
public class matchhere_day1_q1 {
    public static void main(String[] args){
        // BJ 2753
        // Scanner sc = new Scanner(System.in);      // buffered reader is much more faster than scanner
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int yr = Integer.parseInt(bf.readLine());
            bf.close();
            
            int val = (yr%400==0 || (yr%4==0 && yr%100!=0)) ? 1 : 0;
            System.out.print(val);
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

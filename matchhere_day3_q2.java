import java.io.*;
public class matchhere_day3_q2 {
    public static void main(String[] args){
        // BJ 10951
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while((line = bf.readLine()) != null){
                int a = line.charAt(0)-'0', b = line.charAt(2)-'0';
                System.out.println(a+b);
            }
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

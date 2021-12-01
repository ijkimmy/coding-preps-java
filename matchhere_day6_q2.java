import java.io.*;
public class matchhere_day6_q2 {
    public static void main(String[] args){
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String[] words = bf.readLine().trim().split(" ");
            bf.close();
            System.out.print(words[0].length()==0 ? 0 : words.length); 
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

import java.io.*;
import java.util.HashMap;
public class matchhere_day6_q1 {
    public static void main(String[] args){
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String input = bf.readLine();
            bf.close();

            int max = 0;
            HashMap<Character, Integer> cnts = new HashMap<>();
            for(int i=0; i<input.length(); ++i){
                char key = Character.toUpperCase(input.charAt(i));
                int val = cnts.getOrDefault(key, 0) + 1;
                max = Math.max(max, val);
                cnts.put(key, val);
            }

            char retval = 0, maxcnt = 0;
            for(char ch: cnts.keySet()){
                if(cnts.get(ch) == max){
                    retval = ch;
                    ++maxcnt;
                }
            }
        
            System.out.print(maxcnt>1 ? "?" : retval);
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

import java.io.*;
public class matchhere_day1_q2 {
    public static void main(String[] args){
        // BJ 14681
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int x = Integer.parseInt(bf.readLine());
            int y = Integer.parseInt(bf.readLine());
            bf.close();

            int retval = 0;
            if(x>0 && y>0)
                retval = 1;
            else if(y>0)
                retval = 2;
            else if(x>0)
                retval = 4;
            else 
                retval = 3;
            System.out.print(retval);
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

import java.io.*;
public class matchhere_day7_q1 {
    public static void main(String[] args){
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String[] inputs = bf.readLine().split(" ");
            
            int a = Integer.parseInt(inputs[0]), b = Integer.parseInt(inputs[1]), v = Integer.parseInt(inputs[2]);
            int retval = (int)Math.ceil((double)(v-a)/(a-b)) + 1;
            System.out.print(retval);
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

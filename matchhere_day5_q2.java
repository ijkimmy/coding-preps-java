import java.io.*;
public class matchhere_day5_q2 {
    public static void main(String[] args){
        // BJ 1065
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());
            bf.close();

            int retval = 0;
            for(int i=1; i<=n; ++i){
                if(i<10){
                    ++retval;
                } else {
                    int num = i/10, prev = i%10, diff = prev - num%10;
                    while(num > 0){
                        int curr = num%10;
                        if(prev - curr != diff)
                            break;
                        prev = curr;
                        num /= 10;
                    }

                    retval += num==0 ? 1 : 0;
                }
            }
            System.out.print(retval);
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

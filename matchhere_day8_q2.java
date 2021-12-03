import java.io.*;
public class matchhere_day8_q2 {
    public static void main(String[] args){
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());
            for(int i=0; i<n; ++i){
                String[] xy = bf.readLine().split(" ");
                int x = Integer.parseInt(xy[0]), y = Integer.parseInt(xy[1]), dist = y-x;
                if(dist <= 2){
                    System.out.println(dist);
                } else {
                    int sqrtd = (int)Math.sqrt(dist);
                    int d2 = sqrtd * sqrtd;
                    if(dist == d2){
                        System.out.println(2*sqrtd-1);
                    } else if(dist <= d2+sqrtd){
                        System.out.println(2*sqrtd);
                    } else {
                        System.out.println(2*sqrtd+1);
                    }
                }
            }
            bf.close();
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

import java.io.*;
public class matchhere_day11_q2 {
    public static void main(String[] args){
        // BJ 1436
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());

            func(n);
        } catch(IOException e){
            System.out.print(e);
        }
    }

    public static void func(int n){
        int pre = -1, post = -1, div = 0;
        for(int i=0; i<n; ++i){
            ++pre;
            if(pre%10 == 6){
                div = 1;
                while((pre/div) > 0 && (pre/div)%10 == 6){
                    div *= 10;
                }

                while(i<n && post+1<div){
                    ++i; ++post;
                }
                
                if(i==n){
                    pre /= div;
                    int retval = ((pre*1000) + 666) * div + post;
                    System.out.println(retval);
                    return;
                }
                post = -1;
                ++pre;
            }
        }
        
        System.out.println((pre==0?"":pre) + "666" + (post==-1?"":post));
    }
}

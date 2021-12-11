import java.io.*;
import java.util.StringTokenizer;
public class matchhere_day11_q1 {
    public static void main(String[] args){
        // BJ 2798
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine());
            int[] cards = new int[n];
            for(int i=0; i<n; ++i){
                cards[i] = Integer.parseInt(st.nextToken());
            }

            int retval = 0, mindiff = Integer.MAX_VALUE;
            for(int i=0; i<n; ++i){
                for(int j=i+1; j<n; ++j){
                    for(int k=j+1; k<n; ++k){
                        int sum = cards[i] + cards[j] + cards[k];
                        int diff = m - sum;
                        if(diff >= 0 && diff < mindiff){
                            mindiff = diff;
                            retval = sum;
                        }
                    }
                }
            }

            System.out.print(retval);
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

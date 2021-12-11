import java.io.*;
import java.util.StringTokenizer;
public class matchhere_day4_q2 {
    public static void main(String[] args){
        // BJ 4344
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int ncase = Integer.parseInt(bf.readLine());
            for(int i=0; i<ncase; ++i){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int nscore = Integer.parseInt(st.nextToken()), sum = 0;
                int[] scores = new int[nscore];
                for(int sidx=0; sidx<nscore; ++sidx){
                    scores[sidx] = Integer.parseInt(st.nextToken());
                    sum += scores[sidx];
                }

                int over = 0, avg = sum/nscore;
                for(int sidx=0; sidx<nscore; ++sidx){
                    over += scores[sidx]>avg ? 1 : 0;
                }

                System.out.printf("%.3f", (double)over/nscore*100);
                System.out.println("%");
            }
            bf.close();
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

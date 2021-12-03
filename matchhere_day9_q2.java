import java.io.*;
import java.util.StringTokenizer;
public class matchhere_day9_q2 {
    public static void main(String[] args){
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int ncase = Integer.parseInt(bf.readLine());

            for(int i=0; i<ncase; ++i){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()), r1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken()), r2 = Integer.parseInt(st.nextToken());
                int x12 = x1-x2, y12 = y1-y2;
                int dist2 = x12*x12 + y12*y12;
                int radd = r1+r2, radd2 = radd*radd;
                int rsub = r1-r2, rsub2 = rsub*rsub;

                if(dist2 < radd2 && dist2 > rsub2){
                    System.out.println(2);
                } else if(dist2 == radd2 || (dist2!=0 && dist2 == rsub2)){
                    System.out.println(1);
                } else if(dist2 == 0 && r1 == r2){
                    System.out.println(-1);
                } else {
                    System.out.println(0);
                }
            }
            bf.close();
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

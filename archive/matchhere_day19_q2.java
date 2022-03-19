import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class matchhere_day19_q2 {
    public static void main(String[] args){
        // BJ 1655
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());

            List<Integer> lst = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<n; ++i){
                int toadd = Integer.parseInt(bf.readLine());
                int idx = Collections.binarySearch(lst, toadd);
                if(idx < 0)
                    idx = -idx - 1;
                lst.add(idx, toadd);
                sb.append(lst.get((lst.size()-1)/2) + "\n");
            }
            bf.close();

            System.out.print(sb);
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

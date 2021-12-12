import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class matchhere_day12_q2 {
    public static void main(String[] args){
        // BJ 18870
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            bf.close();

            int[] vals = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            List<Integer> distinct = new ArrayList<>();
            for(int i=0; i<n; ++i){
                int val = Integer.parseInt(st.nextToken());
                vals[i] = val;
                if(!map.containsKey(val)){
                    distinct.add(val);
                    map.put(val, -1);
                }
            }

            Collections.sort(distinct);

            int i=0;
            for(int val: distinct)
                map.put(val, i++);

            StringBuilder sb = new StringBuilder();
            for(i=0; i<n; ++i){
                sb.append(map.get(vals[i]) + " ");      // if directly sys.out, it gets timeout
            }

            System.out.print(sb);
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

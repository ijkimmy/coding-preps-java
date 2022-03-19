import java.io.*;
import java.util.List;
import java.util.LinkedList;
import java.util.HashSet;
public class matchhere_day15_q1 {
    public static void main(String[] args){
        // BJ 15649
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String[] nm = bf.readLine().split(" ");
            int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);

            StringBuilder sb = new StringBuilder();
            permute(n, m, new LinkedList<>(), new HashSet<>(), sb);
            System.out.print(sb);
        } catch(IOException e){
            System.out.print(e);
        }
    }

    public static void permute(int n, int size, List<Integer> lst, HashSet<Integer> included, StringBuilder sb){
        if(lst.size() == size){
            for(int val: lst)
                sb.append(val + " ");
            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; ++i){
            if(!included.contains(i)){
                included.add(i);
                lst.add(i);
                permute(n, size, lst, included, sb);
                included.remove(i);
                lst.remove(lst.size()-1);
            }
        }
    }
}

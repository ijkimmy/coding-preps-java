import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;
public class matchhere_day18_q2 {
    public static void main(String[] args){
        // BJ 10830
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String[] nm = bf.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            long p = Long.parseLong(nm[1]);

            int[][] mat = new int[n][n];
            for(int i=0; i<n; ++i){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for(int j=0; j<n; ++j){
                    mat[i][j] = Integer.parseInt(st.nextToken()) % 1000;
                }
            }
            bf.close();

            HashMap<Long, int[][]> map = new HashMap<>();
            map.put(1L, mat);
            int[][] retval = pow(mat, p, map);

            for(int i=0; i<retval.length; ++i){
                for(int j=0; j<retval[i].length; ++j){
                    System.out.print(retval[i][j] + " ");
                }
                System.out.println();
            }
        } catch(IOException e){
            System.out.print(e);
        }
    }

    public static int[][] pow(int[][] mat, long p, HashMap<Long, int[][]> map){
        if(map.containsKey(p)){
            return map.get(p);
        }

        int[][] halfp = pow(mat, p/2, map);
        int[][] remainder = pow(mat, p-p/2, map);

        int[][] matp = mult(halfp, remainder);
        map.put(p, matp);

        return matp;
    }

    public static int[][] mult(int[][] a, int[][] b){
        int len = a.length;
        int[][] retval = new int[len][len];
        for(int r=0; r<len; ++r){
            for(int c=0; c<len; ++c){
                int product = 0;
                for(int i=0; i<len; ++i){
                    product += a[r][i] * b[i][c];
                }
                retval[r][c] = product % 1000;
            }
        }

        return retval;
    }
}

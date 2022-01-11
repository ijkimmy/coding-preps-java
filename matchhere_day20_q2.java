import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
public class matchhere_day20_q2 {
    public static void main(String[] args){
        // BJ 7576
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String[] mn = bf.readLine().split(" ");
            int m = Integer.parseInt(mn[0]), n = Integer.parseInt(mn[1]);

            int num0s = 0;
            int[][] box = new int[n][m];
            Queue<int[]> q = new LinkedList<>();
            for(int r=0; r<n; ++r){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for(int c=0; c<m; ++c){
                    box[r][c] = Integer.parseInt(st.nextToken());
                    if(box[r][c] == 1)
                        q.offer(new int[] { r, c, 0 });
                    else if(box[r][c] == 0)
                        ++num0s;
                }
            }
            bf.close();

            int maxdepth = 0;
            int[] dir = { 0, 1, 0, -1, 0 };
            while(!q.isEmpty()){
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];

                for(int i=1; i<dir.length; ++i){
                    int nextr = r+dir[i-1], nextc = c+dir[i];
                    if(0<=nextr && nextr<n && 0<=nextc && nextc<m && box[nextr][nextc] == 0){
                        --num0s;
                        box[nextr][nextc] = 1;

                        int depth = curr[2] + 1;
                        q.offer(new int[] { nextr, nextc, depth });
                        maxdepth = maxdepth<depth ? depth : maxdepth;
                    }
                }
            }

            System.out.print(num0s==0 ? maxdepth : -1);
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

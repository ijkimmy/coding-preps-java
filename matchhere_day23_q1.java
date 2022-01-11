import java.io.*;
import java.util.StringTokenizer;
public class matchhere_day23_q1 {
    public static void main(String[] args){
        // BJ 2263
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());
            
            in = new int[n];
            inidx = new int[n+1];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i=0; i<n; ++i){
                in[i] = Integer.parseInt(st.nextToken());
                inidx[in[i]] = i;   // store index of inorder element 
            }

            post = new int[n];
            st = new StringTokenizer(bf.readLine());
            for(int i=0; i<n; ++i){
                post[i] = Integer.parseInt(st.nextToken());
            }
            bf.close();
            
            preorder(0, n-1, 0, n-1);
        } catch(IOException e){
            System.out.print(e);
        }
    }

    static int[] post, in, inidx;

    // preorder     root-left -right
    // inorder      left-root -right
    // postorder    left-right-root
    public static void preorder(int istart, int iend, int pstart, int pend){
        if(istart > iend || pstart > pend)
            return;
        
        int root = post[pend--];
        System.out.print(root + " ");

        int rpos = inidx[root];

        // left side
        preorder(istart, rpos-1, pstart, pstart + (rpos-istart) - 1);
        // rightside
        preorder(rpos+1, iend, pstart + (rpos-istart), pend);
    }
}

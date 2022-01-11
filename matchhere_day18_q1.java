import java.io.*;
public class matchhere_day18_q1 {
    public static void main(String[] args){
        // BJ 1992
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());

            int[][] img = new int[n][n];
            for(int r=0; r<n; ++r){
                String line = bf.readLine();
                for(int c=0; c<line.length(); ++c){
                    if(line.charAt(c) == '1'){
                        img[r][c] = 1;
                    }
                }
            }
            bf.close();

            String output = Quadtree(img, n, 0, 0);
            System.out.print(output);
        } catch(IOException e){
            System.out.print(e);
        }
    }

    public static String Quadtree(int[][] img, int n, int r, int c){
        if(n==1){
            return String.valueOf(img[r][c]);
        }

        int half = n/2;
        String lu = Quadtree(img, half, r, c);
        String ru = Quadtree(img, half, r, c+half);
        String ld = Quadtree(img, half, r+half, c);
        String rd = Quadtree(img, half, r+half, c+half);

        if(lu.length() == 1 && lu.equals(ru) && ru.equals(ld) && ld.equals(rd)){
            return lu;
        }

        return "(" + lu + ru + ld + rd + ")";
    }
}

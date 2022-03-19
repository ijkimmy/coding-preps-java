import java.io.*;
public class matchhere_day17_q2 {
    public static void main(String[] args){
        // BJ 2579
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());

            int[] scores = new int[n];
            for(int i=0; i<n; ++i){
                scores[i] = Integer.parseInt(bf.readLine());
            }
            bf.close();

            int[][] dp = new int[n][3];
            dp[0][1] = scores[0];
            for(int i=1; i<n; ++i){
                dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]);
                dp[i][1] = dp[i-1][0] + scores[i];
                dp[i][2] = dp[i-1][1] + scores[i];
            }

            int maxscore = Math.max(dp[n-1][1], dp[n-1][2]);
            System.out.print(maxscore);
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

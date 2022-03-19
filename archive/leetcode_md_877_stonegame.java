import java.util.Arrays;
public class leetcode_md_877_stonegame {

    // 113m
    public boolean stoneGame(int[] piles) {
        // // Bottom-up dynamic programming, time&space: O(n^2)
        // int n = piles.length;
        // int[][] dp = new int[n][n];
        // for(int d=0; d<n; ++d){
        //     for(int i=0; i+d<n; ++i){
        //         if(d == 0){
        //             dp[i][i] = piles[i];
        //             continue;
        //         }
        //         dp[i][i+d] = Math.max(piles[i] - dp[i+1][i+d], piles[i+d] - dp[i][i+d-1]);
        //     }
        // }
        // return dp[0][n-1] > 0;


        // Bottom-up dynamic programming, time:O(n^2), space: O(n)
        int n = piles.length;
        int[] dp = Arrays.copyOf(piles, n);
        for(int d=1; d<n; ++d){
            for(int i=0; i+d<n; ++i){
                dp[i] = Math.max(piles[i] - dp[i+1], piles[i+d] - dp[i]);
            }
        }

        return dp[0] > 0;
    }
}

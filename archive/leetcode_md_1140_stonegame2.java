import java.util.Arrays;
public class leetcode_md_1140_stonegame2 {

    // 51m
    public int stoneGameII(int[] piles) {
        // top-down dp, time: O(n^3), space: O(n^2)
        int n = piles.length;
        int[] sum = Arrays.copyOf(piles, n);
        for(int i=n-2; i>=0; --i) sum[i] += sum[i-1];
        return dp(0, 1, sum, new int[n][n]);
    }

    public int dp(int pos, int m, int[] sum, int[][] memo){
        if(sum.length - pos <= 2*m){
            return sum[pos];
        }

        if(memo[pos][m] != 0) return memo[pos][m];

        int maxtake = 0;
        for(int i=1; i<=2*m; ++i){
            maxtake = Math.max(maxtake, sum[pos] - dp(pos+i, Math.max(m, i), sum, memo));
        }
        memo[pos][m] = maxtake;

        return memo[pos][m];
    }
}

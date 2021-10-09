public class leetcode_md_1884_twoeggdrop {

    // 100m
    public int twoEggDrop(int n) {
        // // partitioning (math)
        // int floor = 1;
        // while(n-floor > 0)
        //     n -= floor++;
        // return floor;


        // dynamic programming
        int egg = 2;
        return drop(n, egg, new int[n+1][egg+1]);
    }

    public int drop(int floor, int egg, int[][] dp){
        if(floor <= 1 || egg == 1) return floor;
        if(dp[floor][egg]!=0) return dp[floor][egg];

        int min = Integer.MAX_VALUE;
        for(int i=1; i<=floor; ++i){
            min = Math.min(min, 1 + Math.max(drop(floor-i, egg, dp), drop(i-1, egg-1, dp)));
        }
        dp[floor][egg] = min;

        return dp[floor][egg];
    }
}

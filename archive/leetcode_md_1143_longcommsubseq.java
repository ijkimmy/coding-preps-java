// import java.util.Arrays;
public class leetcode_md_1143_longcommsubseq {

    // 59m
    public int longestCommonSubsequence(String text1, String text2) {
        // // top-down recursive with memo, time: O(mn), space: O(mn)
        // int[][] memo = new int[text1.length()][text2.length()];
        // for(int[] arr: memo)
        //     Arrays.fill(arr, -1);
        // return dp(memo, text1, text2, 0, 0);


        // // bottom-up dp, time: O(mn), space: O(mn)
        // int n = text1.length(), m = text2.length();
        // int[][] memo = new int[n+1][m+1];
        // for(int i=n-1; i>=0; --i){
        //     for(int j=m-1; j>=0; --j){
        //         if(text1.charAt(i) == text2.charAt(j))
        //             memo[i][j] = 1 + memo[i+1][j+1];
        //         else
        //             memo[i][j] = Math.max(memo[i+1][j], memo[i][j+1]);
        //     }
        // }

        // return memo[0][0];



        // bottom-up dp w/ space opt, time: O(mn), space: O(max(m,n))
        if(text1.length() < text2.length()){
            String tmp = text1;
            text1 = text2;
            text2 = tmp;
        }

        int n = text1.length();
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
        for(int i=text2.length()-1; i>=0; --i){
            for(int j=n-1; j>=0; --j){
                if(text1.charAt(j) == text2.charAt(i))
                    curr[j] = 1 + prev[j+1];
                else   
                    curr[j] = Math.max(curr[j+1], prev[j]);
            }
            int[] tmp = prev;
            prev = curr;
            curr = tmp;
        }

        return prev[0];
    }

    public int dp(int[][] memo, String t1, String t2, int i1, int i2){
        if(i1 >= t1.length() || i2 >= t2.length()) return 0;
        if(memo[i1][i2] != -1) return memo[i1][i2];

        if(t1.charAt(i1) == t2.charAt(i2))
            memo[i1][i2] = 1 + dp(memo, t1, t2, i1+1, i2+1);
        else
            memo[i1][i2] = Math.max(dp(memo, t1, t2, i1+1, i2), dp(memo, t1, t2, i1, i2+1));
        
        return memo[i1][i2];
    }
}

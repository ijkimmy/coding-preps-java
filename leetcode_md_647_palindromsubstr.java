public class leetcode_md_647_palindromsubstr {
    public int countSubstrings(String s) {
        // // brute force, time: O(n^3), space: O(1)
        // int slen = s.length(), cnt = slen;
        // for(int len=2; len<=slen; ++len){
        //     for(int at=0; at+len<=slen; ++at){
        //         boolean ispalin = true;
        //         for(int i=0; i<len/2; ++i){
        //             if(s.charAt(at+i) != s.charAt(at+len-i-1)){
        //                 ispalin = false;
        //                 break;
        //             }
        //         }
        //         cnt += ispalin ? 1 : 0;
        //     }
        // }

        // return cnt;



        // // dynamic programming, time: O(n^2), space: O(n^2)
        // int slen = s.length();
        // boolean[][] dp = new boolean[slen][slen];

        // int retval = slen;
        // dp[0][0] = true;
        // for(int i=1; i<slen; ++i){
        //     dp[i][i] = true;
        //     if(s.charAt(i-1) == s.charAt(i)){
        //         dp[i-1][i] = true;
        //         ++retval;
        //     }
        // }

        // for(int len=3; len<=slen; ++len){
        //     for(int start=0; start+len-1<slen; ++start){
        //         int end = start+len-1;
        //         dp[start][end] = dp[start+1][end-1] && s.charAt(start)==s.charAt(end);
        //         retval += dp[start][end] ? 1 : 0;
        //     }
        // }

        // return retval;



        // expand circle, time: O(n^2), space: O(1)
        int retval = 0;
        for(int i=0; i<s.length(); ++i){
            retval += expand(s, i, i);      // odd length palin centered at i
            retval += expand(s, i, i+1);    // even length palin centered at i,i+1
        }

        return retval;
    }

    public int expand(String s, int left, int right){
        int retval = 0;

        while(0 <= left && right <s.length()){
            if(s.charAt(left) != s.charAt(right))
                break;
            
            ++retval; --left; ++right;
        }

        return retval;
    }
}

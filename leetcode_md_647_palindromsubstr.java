public class leetcode_md_647_palindromsubstr {
    public int countSubstrings(String s) {
        // brute force, time: O(n^3), space: O(1)
        int slen = s.length(), cnt = slen;
        for(int len=2; len<=slen; ++len){
            for(int at=0; at+len<=slen; ++at){
                boolean ispalin = true;
                for(int i=0; i<len/2; ++i){
                    if(s.charAt(at+i) != s.charAt(at+len-i-1)){
                        ispalin = false;
                        break;
                    }
                }
                cnt += ispalin ? 1 : 0;
            }
        }

        return cnt;




        // dynamic programming



        // expand circle
    }
}

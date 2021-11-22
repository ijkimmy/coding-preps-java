public class leetcode_ez_680_validpalindrome2 {

    // 35m
    public boolean validPalindrome(String s) {
        int len = s.length();
        for(int i=0; i<len/2; ++i){
            if(s.charAt(i) != s.charAt(len-i-1)){
                return helper(s, i, len-i-2) || helper(s, i+1, len-i-1);
            }
        }
        return true;
    }

    public boolean helper(String s, int l, int r){
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}

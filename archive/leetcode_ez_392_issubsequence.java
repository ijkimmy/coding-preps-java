public class leetcode_ez_392_issubsequence {

    // 10m
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;
        
        int sidx = 0, tidx = 0;
        while(sidx<s.length() && tidx<t.length()){
            if(s.charAt(sidx) == t.charAt(tidx++))
                ++sidx;
        }

        return sidx==s.length();
    }
}

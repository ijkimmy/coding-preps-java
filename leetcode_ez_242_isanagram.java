public class leetcode_ez_242_isanagram {
    
    // 11m
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        final int numchars = 26;
        int[] cntchar = new int[numchars];
        for(int i=0; i<s.length(); ++i){
            int sidx = s.charAt(i) - 'a'; ++cntchar[sidx];
            int tidx = t.charAt(i) - 'a'; --cntchar[tidx];
        }

        for(int cnt: cntchar)
            if(cnt != 0) 
                return false;
        
        return true;
    }
}

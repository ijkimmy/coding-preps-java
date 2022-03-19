public class leetcode_ez_844_backspacecompare {

    // 50m
    public boolean backspaceCompare(String s, String t) {
        if(s.length() > t.length()){    // s.length() < t.length()
            String tmp = s;
            s = t;
            t = tmp;
        }
        
        int sidx = next(s, s.length()-1), tidx = next(t, t.length()-1);
        
        while(sidx != -1 && tidx != -1){
            
            if(s.charAt(sidx) != t.charAt(tidx)) return false;
            
            sidx = next(s, --sidx); tidx = next(t, --tidx);
        }

        if(sidx == tidx) return true; // both -1

        return false;
    }

    public int next(String str, int idx){
        if(idx < 0 || idx >= str.length()) return -1;
        
        int toskip = 0;
        while(idx >= 0) {
            char c = str.charAt(idx);
            if(c == '#')
                ++toskip;
            else if(toskip > 0)
                --toskip;
            else
                break;
            
            --idx;
        }
        
        return idx;
    }
}

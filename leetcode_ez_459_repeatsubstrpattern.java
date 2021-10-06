public class leetcode_ez_459_repeatsubstrpattern {

    // 18m
    public boolean repeatedSubstringPattern(String s) {
        int slen = s.length();
        for(int sublen=slen/2; sublen>0; --sublen){
            if(slen % sublen == 0){
                boolean match = true;
                for(int i=0; i<slen/sublen; ++i){
                    for(int j=0; j<sublen; ++j){
                        if(s.charAt(sublen*i + j) != s.charAt(j)){
                            match = false;
                            break;
                        }
                    }
                    if(!match) break;
                }
                if(match) return true;
            }
        }

        return false;
    }
}

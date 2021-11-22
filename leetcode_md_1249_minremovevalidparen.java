public class leetcode_md_1249_minremovevalidparen {

    // 26m
    public String minRemoveToMakeValid(String s) {
        int open = 0, valid = 0;
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i) == '(') ++open;
            else if(s.charAt(i) == ')' && open > 0){
                ++valid; --open;
            }
        }

        open = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); ++i){
            char c = s.charAt(i);
            if(c == '('){
                if(valid == 0) continue;
                --valid; ++open;
            } else if(c == ')'){
                if(open == 0) continue;
                --open;
            } 
            sb.append(c);
        }

        return sb.toString();
    }
}

public class leetcode_md_856_scoreparenthesis {

    // 40m
    public int scoreOfParentheses(String s) {
        int retval = 0, pow = 0;
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i) == '(')
                ++pow;
            else {
                --pow;
                if(s.charAt(i-1) == '(')
                    retval += 1 << pow;
            }
        }

        return retval;
    }
}

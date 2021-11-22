import java.util.List;
import java.util.LinkedList;
// import java.util.HashSet;
public class leetcode_md_22_generateparen {

    // 44m
    public List<String> generateParenthesis(int n) {
        // // brute force - generating all possible parens, time&space: O(2^(2n)*n)
        // HashSet<String> set = new HashSet<>();
        // permute("()", n-1, set);
        // List<String> retval = new LinkedList<>();
        // for(String s: set)
        //     retval.add(s);
        // return retval;

        
        // closure number - recursive, time&space: O(4^n / sqrt(n)) => Catalan number
        // List<String> retval = new LinkedList<>();
        // if(n==0){
        //     retval.add("");
        // } else {
        //     for(int i=0; i<n; ++i){
        //         for(String left: generateParenthesis(i)){
        //             for(String right: generateParenthesis(n-i-1)){
        //                 retval.add("(" + left + ")" + right);
        //             }
        //         }
        //     }
        // }
        // return retval;


        // back tracking, time&space: O(4^n / sqrt(n)) => Catalan number
        List<String> retval = new LinkedList<>();
        permute(new StringBuilder(), 0, 0, n, retval);
        return retval;
    }

    public void permute(StringBuilder sb, int opened, int closed, int n, List<String> lst){
        if(sb.length() == 2*n){
            lst.add(sb.toString());
            return;
        }

        if(opened < n){
            sb.append("(");
            permute(sb, opened+1, closed, n, lst);
            sb.setLength(sb.length()-1);
        }

        if(opened > closed){
            sb.append(")");
            permute(sb, opened, closed+1, n, lst);
            sb.setLength(sb.length()-1);
        }
    }

    // // brute force back tracking
    // public void permute(String s, int len, HashSet<String> set){
    //     if(len == 0){
    //         set.add(new String(s));
    //         return;
    //     }

    //     for(int i=0; i<s.length(); ++i){
    //         String s2 = s.substring(0, i) + "()" + s.substring(i);
    //         permute(s2, len-1, set);
    //     }
    // }
}

import java.util.Stack;
public class leetcode_ez_20_validparenthesis {

    // 20m
    public boolean isValid(String s) {
        Stack<Character> opened = new Stack<>();
        opened.push(' ');
        for(char c: s.toCharArray()){
            if(c=='(' || c=='{' || c=='[')
                opened.push(c);
            else{
                char prev = opened.pop();
                switch(prev){
                    case '(': if(c!=')') return false; break;
                    case '{': if(c!='}') return false; break;
                    case '[': if(c!=']') return false; break;
                    default: return false;
                }
            }
        }
        return opened.size()==1;
    }
}

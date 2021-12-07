import java.util.Stack;
public class leetcode_md_1910_removeoccurrence {

    // 120m
    public String removeOccurrences(String s, String part) {
        //kmp substring match of part, time: O(n+m), space: O(n+m)
        int slen = s.length(), plen = part.length();
        int[] kmp = new int[plen];
        for(int i=1, j=0; i<plen; ++i){
            if(part.charAt(i) == part.charAt(j)){
                kmp[i] = ++j;
            } else if(j != 0){
                j = kmp[j-1];
                --i;
            }
        }

        int[] idx = new int[slen];
        Stack<Character> stack = new Stack<>();
        for(int i=0, j=0; i<slen; ++i){
            stack.push(s.charAt(i));

            if(stack.peek() == part.charAt(j)){
                idx[stack.size()] = ++j;

                if(j == plen){
                    while(j > 0){
                        stack.pop();
                        --j;
                    }

                    j = stack.isEmpty() ? 0 : idx[stack.size()];
                }
            } else {
                if(j != 0){
                    i--;
                    stack.pop();
                    j = kmp[j-1];
                } else {
                    idx[stack.size()] = j;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}

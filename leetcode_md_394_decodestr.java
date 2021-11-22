// import java.util.Stack;
public class leetcode_md_394_decodestr {

    // 50m
    public String decodeString(String s) {
        // // 1 stack, time: O(n*max(#of[])^#ofnested[]), space: sum of all that in time
        // Stack<Character> stack = new Stack<>();
        // stack.push('-');
        // for(int i=0; i<s.length(); ++i){
        //     char c = s.charAt(i);
        //     if(c == ']'){
        //         StringBuilder sb = new StringBuilder();
        //         while(stack.peek() != '['){
        //             sb.append(stack.pop());
        //         }
        //         stack.pop();
        //         String repeat = sb.reverse().toString();
        //         sb.setLength(0);
        //         while(Character.isDigit(stack.peek())){
        //             sb.append(stack.pop());
        //         }
        //         int val = Integer.parseInt(sb.reverse().toString());
                
        //         String repeated = repeat.repeat(val);
        //         for(int j=0; j<repeated.length(); ++j)
        //             stack.push(repeated.charAt(j));
        //     } else {
        //         stack.push(c);
        //     }
        // }

        // StringBuilder retval = new StringBuilder();
        // while(stack.peek() != '-'){
        //     retval.append(stack.pop());
        // }

        // return retval.reverse().toString();



        // // 2 stack, time: O(len(retval)), size: O(n)
        // Stack<Integer> counts = new Stack<>();
        // Stack<StringBuilder> sbs = new Stack<>();

        // int digit = 0;
        // StringBuilder sb = new StringBuilder();
        // for(int i=0; i<s.length(); ++i){
        //     char c = s.charAt(i);
        //     if(Character.isDigit(c)){
        //         digit = digit*10 + c-'0';
        //     } else if(c == '['){
        //         counts.push(digit);
        //         sbs.push(sb);
        //         digit = 0;
        //         sb = new StringBuilder(); // .setLength(0); does not work! must init new obj
        //     } else if(c == ']'){
        //         StringBuilder prev = sbs.pop();
        //         for(int cnt = counts.pop(); cnt > 0; --cnt){
        //             prev.append(sb);
        //         }
        //         sb = prev;
        //     } else {
        //         sb.append(c);
        //     }
        // }

        // return sb.toString();



        // recursion, time: O(len(retval)), space: O(n)
        String retval = "";
        while(idx < s.length() && s.charAt(idx) != ']'){
            if(!Character.isDigit(s.charAt(idx))){
                retval += s.charAt(idx++);
            } else {
                int digit = 0;
                while(idx < s.length() && Character.isDigit(s.charAt(idx))){
                    digit = digit*10 + s.charAt(idx++)-'0';
                }
                ++idx; // '['
                String torepeat = decodeString(s);
                ++idx; // ']'
                retval += torepeat.repeat(digit);
            }
        }

        return retval;
    }

    int idx = 0;
}

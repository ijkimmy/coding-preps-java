import java.io.*;
import java.util.Stack;
public class matchhere_day13_q2 {
    public static void main(String[] args){
        // BJ 4949
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            Stack<Character> stack = new Stack<>();
            stack.push('#');

            String str;
            StringBuilder sb = new StringBuilder();
            while(!(str = bf.readLine()).equals(".")){
                for(int i=0; i<str.length(); ++i){
                    char c = str.charAt(i);
                    switch(c){
                        case '(':
                        case '[':
                            stack.push(c);
                            break;
                        case ')':
                            if(stack.peek() == '(')
                                stack.pop();
                            else 
                                stack.push(c);
                            break;
                        case ']':
                            if(stack.peek() == '[')
                                stack.pop();
                            else
                                stack.push(c);
                            break;
                        case '.':
                            sb.append(stack.size()==1 ? "yes\n" : "no\n");
                            stack = new Stack<>();
                            stack.push('#');
                            break;
                    }
                }
            }

            System.out.print(sb);
            bf.close();
        }catch(IOException e){
            System.out.print(e);
        }
    }
}

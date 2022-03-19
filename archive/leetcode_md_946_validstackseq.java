import java.util.Stack;
public class leetcode_md_946_validstackseq {

    // 19m
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int popidx = 0;
        Stack<Integer> stack = new Stack<>();
        for(int push: pushed){
            stack.push(push);
            while(!stack.isEmpty() && stack.peek() == popped[popidx]){
                stack.pop(); ++popidx;
            }
        }

        return stack.isEmpty();
    }
}

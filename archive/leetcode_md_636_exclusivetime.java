import java.util.List;
import java.util.Stack;
public class leetcode_md_636_exclusivetime {

    // 62m
    public int[] exclusiveTime(int n, List<String> logs) {
        // stack, time: O(l), space: O(l)
        int[] retval = new int[n];
        Stack<int[]> callstack = new Stack<>();
        for(String log: logs){
            String[] elem = log.split(":");
            int id = Integer.parseInt(elem[0]);
            int ts = Integer.parseInt(elem[2]);
            if(elem[1].equals("start")){
                if(!callstack.isEmpty()){
                    int previd = callstack.peek()[0];
                    int prevtime = callstack.peek()[1];
                    retval[previd] += ts - prevtime;
                }
                callstack.push(new int[] { id, ts });
            } else { // end
                int[] prev = callstack.pop();
                retval[prev[0]] += ts - prev[1] + 1;
                if(!callstack.isEmpty())
                    callstack.peek()[1] = ts+1;
            }
        }

        return retval;
    }
}

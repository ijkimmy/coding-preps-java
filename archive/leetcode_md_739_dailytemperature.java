// import java.util.Stack;
public class leetcode_md_739_dailytemperature {

    // 45m
    public int[] dailyTemperatures(int[] temperatures) {
        // // brute force, time: O(n^2), space: O(1)
        // int n = temperatures.length;
        // int[] retval = new int[n];
        // for(int i=0; i<n; ++i){
        //     for(int j=i+1; j<n; j++){
        //         if(temperatures[j] > temperatures[i]){
        //             retval[i] = j;
        //             break;
        //         }
        //     }
        // }
        // return retval;


        // monotonic stack, time: O(n), space: O(n)
        // int[] retval = new int[temperatures.length];
        // Stack<Integer> stack = new Stack<>();

        // for(int i=0; i<temperatures.length; ++i){
        //     while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
        //         int prev = stack.pop();
        //         retval[prev] = i-prev;
        //     }

        //     stack.push(i);
        // }

        // return retval;


        // optimal solution, time: O(n), space: O(1)
        int[] retval = new int[temperatures.length];

        int max = 0;
        for(int i=temperatures.length-1; i>=0; --i){
            if(max <= temperatures[i]){
                max = temperatures[i];
                continue;
            }

            int day = 1;
            while(temperatures[i+day] <= temperatures[i]){
                day += retval[i+day];
            }
            retval[i] = day;
        }

        return retval;
    }
}

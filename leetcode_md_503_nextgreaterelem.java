import java.util.Arrays;
import java.util.Stack;
public class leetcode_md_503_nextgreaterelem {

    // 40m
    public int[] nextGreaterElements(int[] nums) {
        // // brute force, time: O(n^2), space: O(1) w/o retval
        // int n = nums.length;
        // int[] retval = new int[n];
        // Arrays.fill(retval, Integer.MIN_VALUE);
        // for(int i=0; i<n; ++i){
        //     for(int j=i+1; j<n+i; ++j){
        //         int idxj = j%n;
        //         if(nums[i] < nums[idxj]){
        //             retval[i] = nums[idxj];
        //             break;
        //         } else if (nums[i] < retval[idxj]){
        //             retval[i] = retval[idxj];
        //             break;
        //         }
        //     }
        //     retval[i] = retval[i] == Integer.MIN_VALUE ? -1 : retval[i];
        // }

        // return retval;



        // monotonic stack, time: O(n), space: O(n)
        int n = nums.length;
        int[] retval = new int[n];
        Arrays.fill(retval, -1);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1; i<n; ++i){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                retval[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        for(int i=0; i<n; ++i){
            while(nums[stack.peek()] < nums[i]){
                retval[stack.pop()] = nums[i];
            }

            if(stack.size() == 1){
                retval[stack.pop()] = -1;
                break;
            }
        }

        return retval;
    }
}
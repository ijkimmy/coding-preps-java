import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;
public class matchhere_day13_q1 {
    public static void main(String[] args){
        // BJ 17298
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            bf.close();

            int[] arr = new int[n];
            Stack<Integer> stack = new Stack<>();
            for(int i=0; i<n; ++i){
                arr[i] = Integer.parseInt(st.nextToken());

                while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                    arr[stack.pop()] = arr[i];
                }
                stack.push(i);
            }

            arr[n-1] = -1;
            while(!stack.isEmpty()){
                arr[stack.pop()] = -1;
            }

            StringBuilder sb = new StringBuilder();
            for(int val: arr){
                sb.append(val + " ");
            }

            System.out.print(sb);
        } catch(IOException e){
            System.out.print(e);
        }
    }
}

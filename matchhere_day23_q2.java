import java.io.*;
import java.util.List;
import java.util.ArrayList;
public class matchhere_day23_q2 {
    public static void main(String[] args){
        // BJ 5639
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            String line;
             while((line = bf.readLine()) != null){
            // while((line = bf.readLine()).length() > 0){
                lst.add(Integer.parseInt(line));
            }
            bf.close();

            postorder(0, lst.size()-1);
        } catch(IOException e){
            System.out.print(e);
        }

    }

    static List<Integer> lst = new ArrayList<>();

    public static void postorder(int start, int end){
        if(start > end)
            return;

        int idx = start+1, rootval = lst.get(start);
        while(idx <= end && lst.get(idx) < rootval)
            ++idx;
        
        postorder(start+1, idx-1);
        postorder(idx, end);

        System.out.println(rootval);
    }
}



// import java.io.*;
// import java.util.Stack;
// public class matchhere_day23_q2 {
//     // solution 1
//     public static void main(String[] args){
//         // BJ 5639
//         try{
//             BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

//             Stack<Node> stack = new Stack<>();
            
//             Node root = new Node();
//             String line;
//             while((line = bf.readLine()) != null){
//             // while((line = bf.readLine()).length() > 0){
//                 Node node = new Node();
//                 node.val = Integer.parseInt(line);

//                 if(stack.isEmpty()){ 
//                     stack.push(node);
//                     root = node;
//                     continue;
//                 }

//                 if(node.val < stack.peek().val){
//                     stack.peek().left = node;
//                     stack.push(node);
//                 } else {
//                     Node prev = stack.pop();

//                     while(!stack.isEmpty() && stack.peek().val < node.val){
//                         prev = stack.pop();
//                     }

//                     prev.right = node;
//                     stack.push(node);
//                 }
//             }
//             bf.close();

//             postorder(root);
//         } catch(IOException e){
//             System.out.print(e);
//         }

//     }

//     static class Node{
//         int val;
//         Node left;
//         Node right;

//         public Node() {}
//     }

//     public static void postorder(Node root){
//         if(root == null)
//             return;

//         postorder(root.left);
//         postorder(root.right);

//         System.out.print(root.val + " ");
//     }
// }

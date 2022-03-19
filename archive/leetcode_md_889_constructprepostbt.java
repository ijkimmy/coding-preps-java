/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// import java.util.Deque;
// import java.util.ArrayDeque;
public class leetcode_md_889_constructprepostbt {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 89m
    int pre = 0, post = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // // iterative solution, O(n)
        // Deque<TreeNode> dq = new ArrayDeque<>();
        // dq.offer(new TreeNode(preorder[0]));
        // for(pre=1, post=0; pre<preorder.length; ++pre){
        //     TreeNode node = new TreeNode(preorder[pre]);
        //     while(dq.getLast().val == postorder[post]){
        //         dq.pollLast(); post++;
        //     }
        //     if(dq.getLast().left == null) dq.getLast().left = node;
        //     else dq.getLast().right = node;
            
        //     dq.offer(node);
        // }
        // return dq.getFirst();

        // recursive solution, O(n)
        TreeNode root = new TreeNode(preorder[pre++]);
        if(root.val != postorder[post]){
            root.left = constructFromPrePost(preorder, postorder);
        }
        if(root.val != postorder[post]){
            root.right = constructFromPrePost(preorder, postorder);
        }
        post++;

        return root;
    }
}

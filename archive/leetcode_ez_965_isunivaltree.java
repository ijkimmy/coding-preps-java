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
import java.util.Queue;
import java.util.LinkedList;
class leetcode_ez_965_isunivaltree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 7m
    public boolean isUnivalTree(TreeNode root) {
        if(root==null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int val = root.val;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(val != node.val) return false;
            
            if(node.left != null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);
        }
        return true;
    }
}
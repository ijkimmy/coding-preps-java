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

public class leetcode_ez_226_inverttree {
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

    // 11m
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            
            TreeNode tmp = node.right;
            node.right = node.left;
            node.left = tmp;

            if(node.left != null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);
        }

        return root;
    }    
}



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

import java.util.List;
import java.util.HashSet;
import java.util.LinkedList;
public class leetcode_md_1110_deletenodes {
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

    // 47m
    // using global variables like this may be dangerous 
    // but it does make some constant speed ups in leetcode submissions
    List<TreeNode> retval = new LinkedList<>();
    HashSet<Integer> delete = new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(to_delete.length == 0) return retval;

        for(int d: to_delete)
            delete.add(d);
        
        if(delete(root) != null) retval.add(root);
        
        return retval;
    }

    public TreeNode delete(TreeNode root){
        if(root == null) return root;
        
        TreeNode left = delete(root.left); root.left = left;
        TreeNode right = delete(root.right); root.right = right;
        
        if(delete.contains(root.val)){
            if(left != null) retval.add(left);
            if(right != null) retval.add(right);
            return null;
        }

        return root;
    }
}

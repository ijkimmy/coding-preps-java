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
import java.util.LinkedList;
public class leetcode_md_366_findleaves {
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

    // 48m
    List<List<Integer>> retval;
    public List<List<Integer>> findLeaves(TreeNode root) {
        retval = new LinkedList<>();
        
        height(root);
        
        return retval;
    }

    public int height(TreeNode root){
        if(root == null) return -1;

        int height =  Math.max(height(root.left), height(root.right)) + 1;
        if(height == retval.size()){
            retval.add(new LinkedList<>());
        }
        retval.get(height).add(root.val);

        return height;
    }
}

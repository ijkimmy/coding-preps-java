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

public class leetcode_md_814_prunetree {
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


    // 21m
    public TreeNode pruneTree(TreeNode root) {
        return prune(root)? root: null;
    }

    public boolean prune(TreeNode root){
        if(root == null) return false;

        boolean left = prune(root.left); 
        boolean right = prune(root.right);

        if(!left) root.left = null;
        if(!right) root.right = null;

        return left || right || root.val == 1;
    }
}

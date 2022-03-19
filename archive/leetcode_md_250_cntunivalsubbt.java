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

public class leetcode_md_250_cntunivalsubbt {
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


    // 10m
    public int countUnivalSubtrees(TreeNode root) {
        // recursive, time: O(n), space: O(n)
        isunival(root);
        return univalcnt;
    }

    int univalcnt = 0;

    public boolean isunival(TreeNode root){
        if(root == null) return true;

        boolean unil = isunival(root.left);
        boolean unir = isunival(root.right);

        int left = root.left == null ? root.val : root.left.val;
        int right = root.right == null ? root.val : root.right.val;

        if(unil && unir && root.val == left && root.val == right){
            ++univalcnt;
            return true;
        }

        return false;
    }
}

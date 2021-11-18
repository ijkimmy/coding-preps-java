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

public class leetcode_md_114_flattenbt {
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


    // 67m
    public void flatten(TreeNode root) {
        // recursive, time: O(n), space: O(n)
        // helper(root);



        // iterative, time: O(n), space: O(1)
        while(root != null){
            if(root.left != null){
                TreeNode rightmost = root.left;
                while(rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                rightmost.right = root.right;
                root.right = root.left;
                root.left = null;
            }

            root = root.right;
        }
    }

    public TreeNode helper(TreeNode root){
        if(root == null || (root.left == null && root.right == null)) return root;

        TreeNode lefttail = helper(root.left);
        TreeNode righttail = helper(root.right);

        if(root.left != null){
            lefttail.right = root.right;
            root.right = root.left;
            root.left = null;    
        }

        return righttail == null ? lefttail : righttail;
    }
}

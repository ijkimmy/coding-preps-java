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

public class leetcode_md_776_splitbst {
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

    public TreeNode[] splitBST(TreeNode root, int target) {
        if(root == null) return new TreeNode[] { null, null };

        TreeNode[] retval;
        if(root.val <= target){
            retval = splitBST(root.right, target);
            root.right = retval[0];
            retval[0] = root;
        } else {
            retval = splitBST(root.left, target);
            root.left = retval[1];
            retval[1] = root;
        }

        return retval;
    }
}

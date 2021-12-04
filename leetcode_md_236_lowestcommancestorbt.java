/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class leetcode_md_236_lowestcommancestorbt {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 31m
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // recursive bottom up, time: O(n), space: O(n) if skewed
        findNode(root, p, q);
        return retval;
    }

    TreeNode retval;
    public boolean findNode(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;

        boolean left = findNode(root.left, p, q);
        boolean right = findNode(root.right, p, q);

        if(left && right){
            retval = retval==null ? root : retval;
            return true;
        } else if(left || right){
            if(root == p || root == q)
                retval = root;
            return true;
        }

        return root==p || root==q;
    }
}

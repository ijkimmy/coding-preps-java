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

public class leetcode_md_1325_removeleafnodebt {
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


    // 11m
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // bottom-up recursion, time: O(n), space: O(height)
        if(root == null) return root;

        root.left = removeLeafNodes(root.left, target); 
        root.right = removeLeafNodes(root.right, target); 
        
        if(root.left == null && root.right == null && root.val == target){
            return null;
        }

        return root;
    }

}

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

public class leetcode_md_337_robbt {
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

    // 40m
    public int rob(TreeNode root) {
        // greedy, time: O(n), space: O(1)
        int[] maxval = sum(root);
        return Math.max(maxval[0], maxval[1]);
    }

    public int[] sum(TreeNode node){
        if(node == null) return new int[] { 0, 0 };

        int[] left = sum(node.left);
        int[] right = sum(node.right);

        int take = node.val + left[1] + right[1];
        int nottake = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[] { take, nottake };
    }
}

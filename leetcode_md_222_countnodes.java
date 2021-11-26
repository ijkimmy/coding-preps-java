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

public class leetcode_md_222_countnodes {
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


    // 50m
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        TreeNode node = root;

        int level = -1;
        while(node != null){
            node = node.left;
            ++level;
        }

        int left = 1, max = (int)Math.pow(2, level), right = max;
        while(left <= right){
            int mid = left + (right - left)/2;

            node = root;
            if(hasleaf(mid, max, level, node)){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return (max-1) + left;
    }

    public boolean hasleaf(int idx, int max, int level, TreeNode root){
        int left = 1;
        for(int l=0; l<level; ++l){
            int mid = left + (max - left)/2;

            if(idx > mid){
                left = mid+1;
                root = root.right;
            } else {
                max = mid;
                root = root.left;
            }
        }

        return root!=null;
    }
}

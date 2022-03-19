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

public class leetcode_ez_270_cloestvaluebst {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 35m
    public int closestValue(TreeNode root, double target) {
        double mindiff = Double.MAX_VALUE;
        int retval = -1;
        while(root!=null){
            double diff = Math.abs(target-root.val);
            
            if(diff < mindiff){
                mindiff = diff;
                retval = root.val;
            }

            // debugging purpose
            // int leftval = root.left == null ? 0 : root.left.val;
            // int rightval = root.right == null? 0 : root.right.val;

            if(root.val == target) 
                return root.val;
            else if(root.val < target) 
                root = root.right;
            else 
                root = root.left;
        }

        return retval;





        // double diff = Double.MAX_VALUE; 
        // int prevval = -1;
        // while(Math.abs(root.val - target) <= diff){
        //     diff = Math.abs(root.val - target);
        //     prevval = root.val;
        //     if(root.val < target)
        //         root = root.right;
        //     else
        //         root = root.left;
        // }
        // return prevval;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class leetcode_ez_235_lowestcommancestor {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    // 24m
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // // recursive solution
        // if(p.val > q.val) {     // make p < q
        //     TreeNode tmp = p;
        //     p = q;
        //     q = tmp;
        // }

        // if(root.val < p.val)
        //     return lowestCommonAncestor(root.right, p, q);
        // else if(root.val > q.val)
        //     return lowestCommonAncestor(root.left, p, q);
        // else
        //     return root;


        // iterative solution
        if(p.val > q.val) {     // make p < q
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }

        while(root!=null){
            if(root.val < p.val)
                root = root.right;
            else if(root.val > q.val)
                root = root.left;
            else break;
        }

        return root;
    }
}

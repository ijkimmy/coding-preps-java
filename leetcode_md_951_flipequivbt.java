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

import java.util.LinkedList;
public class leetcode_md_951_flipequivbt {
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


    // 28m
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // // recursive solution, time: O(n), space; O(h)
        // if(root1 == null && root2 == null) return true;
        // else if(root1 == null || root2 == null || root1.val != root2.val) return false;

        // return  (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
        //         (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));



        // iterative solution - canonical traversal
        LinkedList<Integer> l1 = new LinkedList<>(); dfs(root1, l1);
        LinkedList<Integer> l2 = new LinkedList<>(); dfs(root2, l2);
        
        return l1.equals(l2);
    }

    public void dfs(TreeNode n, LinkedList<Integer> l){
        if(n!=null){
            l.add(n.val);

            int left = n.left==null? -1: n.left.val;
            int right = n.right==null? -1: n.right.val;

            if(left < right){
                dfs(n.left, l);
                dfs(n.right, l);
            } else {
                dfs(n.right, l);
                dfs(n.left, l);
            }

            l.add(null);
        }
    }
}

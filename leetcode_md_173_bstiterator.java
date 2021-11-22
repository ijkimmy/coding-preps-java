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

import java.util.Stack;
public class leetcode_md_173_bstiterator {
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

    Stack<TreeNode> parents;
    TreeNode pt;


    // 39m
    public leetcode_md_173_bstiterator(TreeNode root) {
        parents = new Stack<>();
        
        pt = root;
        getmin();
        pt = new TreeNode(-1, null, pt);
    }

    public void getmin(){
        while(pt.left != null){
            parents.push(pt);
            pt = pt.left;
        }
    }
    
    public int next() {
        if(pt.right != null){
            pt = pt.right;
            getmin();
        } else {
            if(parents.isEmpty()) return -1;
            pt = parents.pop();
        }

        return pt.val;
    }
    
    public boolean hasNext() {
        return pt.right != null || !parents.isEmpty();
    }
}

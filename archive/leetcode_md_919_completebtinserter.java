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

import java.util.Queue;
import java.util.LinkedList;
public class leetcode_md_919_completebtinserter {
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

    Queue<TreeNode> parent;
    // Queue<TreeNode> leaf;
    TreeNode root;

    public leetcode_md_919_completebtinserter(TreeNode root) {
        parent = new LinkedList<>();
        this.root = root;

        Queue<TreeNode> traverse = new LinkedList<>();
        traverse.offer(root);
        while(!traverse.isEmpty()){
            TreeNode node = traverse.poll();
            if(node.left == null || node.right == null)
                parent.offer(node);
            if(node.left != null)
                traverse.offer(node.left);
            if(node.right != null)
                traverse.offer(node.right);
        }
    }

    public int insert(int val) {
        TreeNode p = parent.peek();
        TreeNode node = new TreeNode(val);
        
        if(p.left == null){
            p.left = node;
        } else {
            p.right = node;
            parent.poll();
        }

        parent.offer(node);

        return p.val;
    }

    // 36m
    // public leetcode_md_919_completebtinserter(TreeNode root) {
    //     parent = new LinkedList<>();
    //     leaf = new LinkedList<>();
    //     this.root = root;

    //     parent.offer(root);
    //     boolean islast = false;
    //     while(!islast){
    //         while(!parent.isEmpty()){
    //             TreeNode node = parent.peek();
    //             if(node.left == null) { islast = true; break; }
    //             leaf.offer(node.left);
    //             if(node.right == null) { islast = true; break; }
    //             leaf.offer(node.right);
    //             parent.poll();
    //         }

    //         if(!islast) {
    //             parent = leaf;
    //             leaf = new LinkedList<>();
    //         }
    //     }
    // }
    
    // public int insert(int val) {
    //     if(parent.isEmpty()){
    //         parent = leaf;
    //         leaf = new LinkedList<>();
    //     }

    //     TreeNode p = parent.peek();
    //     TreeNode node = new TreeNode(val);
    //     leaf.offer(node);

    //     if(p.left == null){
    //         p.left = node;
    //     } else {
    //         p.right = node;
    //         parent.poll();
    //     }

    //     return p.val;
    // }
    
    public TreeNode get_root() {
        return root;
    }
}

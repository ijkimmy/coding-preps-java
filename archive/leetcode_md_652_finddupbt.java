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

import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
public class leetcode_md_652_finddupbt {
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


    // 52m
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> retval= new LinkedList<>();
        traverse(root, new HashMap<>(), retval);
        return retval;
    }

    public String traverse(TreeNode root, HashMap<String, Integer> subtrees, List<TreeNode> lst){
        if(root == null) return "x";

        String left = traverse(root.left, subtrees, lst);
        String right = traverse(root.right, subtrees, lst);

        String curr = root.val + "," + left + "," + right;
        if(subtrees.getOrDefault(curr, 0) == 1)
            lst.add(root);
        subtrees.put(curr, subtrees.getOrDefault(curr, 0) + 1);

        return curr;
    }
}

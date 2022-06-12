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
class Solution {
    boolean vaildateBST(TreeNode root, Long R_MIN, Long R_MAX) {
        if(root == null) return true;
        Long value = (long) root.val;
        if(value >= R_MAX || value <= R_MIN) return false;
        
        return vaildateBST(root.left, R_MIN, value) && vaildateBST(root.right, value, R_MAX);
    }
    
    public boolean isValidBST(TreeNode root) {
        
        return vaildateBST(root, Long.MIN_VALUE,  Long.MAX_VALUE );
    }
}
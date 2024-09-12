/**
*
* Time Complexity: O(N) 
* Where N is the length of ListNode
* Space Complixity: O(NM) 
* M and N space of the two recursion value
*
**/
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
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }else {
        int leftHeight = maxDepth(root.left);        
        int rightHeight = maxDepth(root.right);

        return java.lang.Math.max(leftHeight, rightHeight) + 1;
    }
}
}
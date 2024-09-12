/**
*
* Time Complexity: O(N^2) 
* Where N is the length of ListNode
* Space Complixity: O(NM) 
* M and N space of the two
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
    TreeNode createBST(int[] nums, int L, int R) {
        if(L > R) return null;
        int M = L + (R - L) / 2;
        
        TreeNode current = new TreeNode(nums[M]);
        current.left = createBST(nums, L, M - 1);
        current.right = createBST(nums, M+1, R);
        
        return current;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length -1);
    }
}
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

     private static int value = 0;
     private static int count = 0;


    void  runInorder(TreeNode root, int k) {
        if(root == null) return;

        // System.out.println(k);
        // System.out.println(root.val);

        runInorder(root.left, k);
        // System.out.println(root.val);
        //System.out.println(root.val);
        count--;
        if(count == 0) {
            System.out.println("Sabbir");
            System.out.println(root.val);

            value = root.val;
            return;
        }
        runInorder(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        runInorder(root, k);

        // return this.value;
        return value;
    }
}
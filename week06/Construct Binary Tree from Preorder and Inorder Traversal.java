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
    public static int pos = 0;
    
    public TreeNode generateTree(int[] preorder, int[] inorder, int L, int R, int pos, HashMap<Integer, Integer> preorderListMap) {
        if(pos > preorder.length || L > R) return null;
        
        TreeNode newNode = new TreeNode(preorder[pos++]);
        int M = preorderListMap.get(newNode.val);
        newNode.left = generateTree(preorder, inorder, L, M-1, pos, preorderListMap);        
        newNode.right = generateTree(preorder, inorder, M + 1, R, pos, preorderListMap);

        return newNode;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> preorderListMap = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < inorder.length; ++i) {
             preorderListMap.put(inorder[i], i);
        }
        
        return generateTree(preorder, inorder, 0, preorder.length-1, pos, preorderListMap);
    }
}
/**
*
* Time Complexity: O(N)
* Where N is the maximum length of two ListNode
* Space Complixity: O(1)
*
**/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
          int carry = 0;
         ListNode  prev = null;
         ListNode temp = null;
            int sum = 0;
			
        while(l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            sum = carry + x + y;
            
            carry = ( sum >= 10 ) ? 1 : 0;
            
            sum = sum % 10;
            
            temp  = new ListNode(sum);
            
            if (result == null) {
                result = temp;
            }  else {
                prev.next = temp; 
            }
            
             prev = temp; 
            
            if(l1 !=  null)
            {
                l1 = l1.next;
            }
            if(l2 != null)
            {
                l2 = l2.next;
            }
    }
        
        if(carry > 0) {
            temp.next = new ListNode(carry); 
        }
        
        return result;
}
}
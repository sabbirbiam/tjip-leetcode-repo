/**
*
* Time Complexity: O(N)
* Where N is the length of ListNode
* Space Complixity: O(1)
*
*
**/
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        
        return p;
    }
}
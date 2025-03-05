//sort nodes of a linked list

class Solution {
    public ListNode sortList(ListNode head) {
        // Base cases
        if (head == null || head.next == null) {
            return head;
        }
        
        // Find the middle of the list
        ListNode mid = findMiddle(head);
        ListNode rightHalf = mid.next;
        mid.next = null; 
        
        ListNode left = sortList(head);
        ListNode right = sortList(rightHalf);
        
        // Merge the sorted halves
        return mergeLists(left, right);
    }
    
    // Find the middle node of the list
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    // Merge two sorted lists
    private ListNode mergeLists(ListNode l1, ListNode l2) {
        // Dummy node to simplify merging
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        // Attach remaining nodes
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        
        return dummy.next;
    }
}
// Reverse Nodes in k-Group

// https://leetcode.com/problems/reverse-nodes-in-k-group/description/

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || length(head) < k) {
            return head;
        }
        
        ListNode nextGroupHead = head;
        for (int i = 0; i < k; i++) {
            nextGroupHead = nextGroupHead.next;
        }
        
        ListNode newHead = reverseGroup(head, k);
        head.next = reverseKGroup(nextGroupHead, k);
        
        return newHead;
    }
    
    private ListNode reverseGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int count = 0;
        
        while (count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        
        if (count < k) {
            return reverseGroup(prev, count);
        }
        
        return prev;
    }
    
    private int length(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}
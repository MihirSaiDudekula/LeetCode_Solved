// 148. Sort List
// Solved
// Medium
// Topics
// Companies
// Given the head of a linked list, return the list after sorting it in ascending order.
// Example 1:


// Input: head = [4,2,1,3]
// Output: [1,2,3,4]
// Example 2:


// Input: head = [-1,5,3,4,0]
// Output: [-1,0,3,4,5]
// Example 3:

// Input: head = []
// Output: []
 

// Constraints:

// The number of nodes in the list is in the range [0, 5 * 104].
// -105 <= Node.val <= 105
 

// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // Step 1: Find the middle of the linked list
        ListNode middle = findMiddle(head);
        
        // Split the list into two halves
        ListNode nextToMiddle = middle.next;
        middle.next = null;
        
        // Recursively sort the two halves
        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(nextToMiddle);
        
        // Merge the sorted halves
        return merge(leftSorted, rightSorted);
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        while (left != null && right != null) {
            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        
        // Attach the remaining nodes of left or right list
        if (left != null) {
            current.next = left;
        }
        if (right != null) {
            current.next = right;
        }
        
        return dummy.next;
    }
    
    private ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return prev; // Return the node just before the middle node
    }
}

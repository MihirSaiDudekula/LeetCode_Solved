// Remove Nth Node From End of List

// Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

// Example 1:


// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]
// Example 2:

// Input: head = [1], n = 1
// Output: []
// Example 3:

// Input: head = [1,2], n = 1
// Output: [1]
 

// Constraints:

// The number of nodes in the list is sz.
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
 

// Follow up: Could you do this in one pass?

//OPTIMISED APPROACH

// Initialize two pointers, let's call them first and second, and set both to point to the head of the linked list.
// Move the second pointer to the nth node from the beginning of the list. This will create a gap of n nodes between the first and second pointers.
// Move both first and second pointers simultaneously until the second pointer reaches the end of the list (i.e., the next node after the last node).
// Now, the first pointer is pointing to the node that is just before the node you want to remove. So, remove the next node after the first pointer.

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode temp = head;
        ListNode ptr = head;
        ListNode prev = null;


        for(int i=0;i<n-1;i++)
        {
            temp = temp.next;
        }

        while(temp.next!=null)
        {
            temp = temp.next;
            prev = ptr;
            ptr = ptr.next;            
        }

        if(ptr==head)
        {
            head = ptr.next;
            ptr = null;
        }
        else
        {
            prev.next = ptr.next;
            ptr.next = null;
            ptr = null;

        }
        

        return head;
    }
}


//COMPLEXITY
// Since both pointers move at the same pace and only traverse the list once, this takes O(N) time
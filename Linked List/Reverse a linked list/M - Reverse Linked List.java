// Reverse Linked List

// Given the head of a singly linked list, reverse the list, and return the reversed list.

// Example 1:


// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]
// Example 2:


// Input: head = [1,2]
// Output: [2,1]
// Example 3:

// Input: head = []
// Output: []
 

// Constraints:

// The number of nodes in the list is the range [0, 5000].
// -5000 <= Node.val <= 5000

//APPROACH

// 3 pointers, before current after. at every step, after is cur.next and cur.next is before and travese. in the end before is the head 


class Solution {
    public ListNode reverseList(ListNode head) 
    {
    	ListNode bef = null;
    	ListNode cur = head;
    	ListNode aft = null;

    	while(cur!=null)
    	{
    	    aft = cur.next;
    	    cur.next = bef;
    	    bef = cur;
    	    cur = aft;
    	}
    	head = bef;
    	return head;
    }
}

//complexity
// The time complexity of this solution is O(n) where n is the number of nodes in the linked list. This is because we iterate through each node in the linked list once to reverse it.

// The space complexity is O(1) because we are using a constant amount of extra space regardless of the size of the input linked list. We are only using a few extra pointers to keep track of the nodes during the reversal process.

public ListNode reverseList(ListNode head) {
       ListNode a = null;
       ListNode b = head;

       if(head==null || head.next==null)
       {
        return head;
       }
       ListNode c = head.next;

       while(b.next!=null)
       {
        b.next=a;
        a=b;
        b=c;
        c=c.next;
       }

        b.next = a;
        return b;
    }


public ListNode reverseList(ListNode head) {
    ListNode prev = null, curr = head;

    while (curr != null) {
        ListNode nextTemp = curr.next;  
        curr.next = prev;               
        prev = curr;                    
        curr = nextTemp;
    }

    return prev;
}
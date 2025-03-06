// 61. Rotate List
// Solved
// Medium
// Topics
// Companies
// Given the head of a linked list, rotate the list to the right by k places.

 

// Example 1:


// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]
// Example 2:


// Input: head = [0,1,2], k = 4
// Output: [2,0,1]
 

// Constraints:

// The number of nodes in the list is in the range [0, 500].
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109


class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0)
        {
            return head;
        }
        if(head==null||head.next==null)
        {
            return head;
        }
        int len = listLength(head);
        if(k>len)
        {
            k=k%len;
        }
        ListNode temp = head;
        ListNode rev = reverseList(head);
        int count = k;
        while(count>0)
        {
            ListNode c = rev;
            temp.next = c;
            rev = rev.next;
            c.next = null;
            temp = temp.next;
            count--;
        }

        ListNode ans = reverseList(rev);
        return ans;
    }
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    public static int listLength(ListNode head)
    {
        ListNode temp = head;
        int length = 1;
        while(temp.next!=null)
        {
            temp=temp.next;
            length++;
        }
        return length;
    }
}
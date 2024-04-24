// 876. Middle of the Linked List

// Given the head of a singly linked list, return the middle node of the linked list.

// If there are two middle nodes, return the second middle node.

 

// Example 1:


// Input: head = [1,2,3,4,5]
// Output: [3,4,5]
// Explanation: The middle node of the list is node 3.
// Example 2:


// Input: head = [1,2,3,4,5,6]
// Output: [4,5,6]
// Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 

// Constraints:

// The number of nodes in the list is in the range [1, 100].
// 1 <= Node.val <= 100

// APPROACH
// locate the mid element, first by traversing the LL and calculating size 
// then computing mid and traversing to mid

class Solution {
    public ListNode middleNode(ListNode head)
    {
        ListNode temp = head;
        int lsize = 0;
        while(temp!=null)
        {
            lsize++;
            temp=temp.next;            
        }

        int mid = -1;

        if(lsize%2!=0)
        {
            mid = (lsize+1)/2;            
        }
        else
        {
            mid = (lsize/2)+1;
        }

        ListNode ptr = head;
        for(int i=1;i<=mid-1;i++)
        {
            ptr = ptr.next;
        }

        return ptr;   
    }
}

// complexity of your code:

// 1. **Counting the number of nodes: O(n)

// 2. **Calculating the middle index:involves basic arithmetic operations (addition, division),  O(1).

// 3. **Traversing to the middle node:In the worst case, this loop will iterate through approximately n/2 nodes. Therefore, the time complexity of this loop is O(n/2), which simplifies to O(n).

// Overall, the time complexityis O(n)


//OR

//DIFF APPROACH

// The "fast and slow pointer" technique is commonly used to find the middle node of a linked list. Here's how it works:

// You have two pointers, let's call them fast and slow, both initially pointing to the head of the linked list.
// In each iteration, the fast pointer moves two steps forward, while the slow pointer moves one step forward.
// By doing this, the fast pointer will reach the end of the list (or become null if the list has an even number of nodes) when the slow pointer is halfway through the list. This is because the fast pointer is moving twice as fast as the slow pointer.
// At this point, the slow pointer will be pointing to the middle node of the linked list.
// If the linked list has an even number of nodes, there are two middle nodes. In this case, the slow pointer will be pointing to the second middle node.


class Solution {
    public ListNode middleNode(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;

        if(head.next==null)
        {
            return head;
        }
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
            fast=fast.next;
        }

        return slow;   

    }
}

// This approach has a time complexity of O(n/2) or simply O(n), where n is the number of nodes in the linked list, because both pointers traverse the list once. However, it only requires a single pass through the list.




// Insert in a Sorted List


// Given a linked list sorted in ascending order and an integer called data, insert data in the linked list such that the list remains sorted.

// Example 1:

// Input:
// LinkedList: 25->36->47->58->69->80
// data: 19
// Output: 
// 19 25 36 47 58 69 80
// Explanation:
// After inserting 19 the sorted linked list will look like the one in the output.
// Example 2:

// Input:
// LinkedList: 50->100
// data: 75
// Output: 
// 50 75 100
// Explanation:
// After inserting 75 the sorted linked list will look like the one in the output.
// Your Task:
// The task is to complete the function sortedInsert() which should insert the element in sorted Linked List and return the head of the linked list

// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(1).

// Constraints:
// 1 <= N <= 104
// -99999 <= A[i] <= 99999, for each valid i


// APPROACH
// linear search the linked list until we find a greater element
// make checks for insertions for beginning , middle and end

class Solution {
    Node sortedInsert(Node head1, int key) {
        // Add your code here.
        Node prev = null;
        Node temp = head1;
        Node nn = new Node(key);
        if(head1==null)
        {
            nn = head1;
            return head1;
        }
        while(temp!=null && temp.data<key)
        {
            prev=temp;
            temp=temp.next;
        }
        if(temp==head1)
        {
            nn.next = temp;
            head1 = nn;
        }
        else if(temp==null)
        {
            prev.next=nn;
        }
        else
        {
            nn.next = prev.next;
            prev.next = nn;
        }
        return head1;
    }
}


//COMPLEXITY
// Traversing the linked list to find the correct position to insert the new node: In the worst case, you might have to traverse the entire linked list. This would take O(n) time, where n is the number of nodes in the linked list.
// Inserting the new node: Once you find the correct position to insert the new node, the insertion operation itself is constant time since it involves only pointer manipulation.
// Therefore, the overall time complexity of the code is O(n), where n is the number of nodes in the linked list.



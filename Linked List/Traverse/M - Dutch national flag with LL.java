// Problem statement
// Given a linked list of 'N' nodes, where each node has an integer value that can be 0, 1, or 2. You need to sort the linked list in non-decreasing order and the return the head of the sorted list.



// Example:
// Given linked list is 1 -> 0 -> 2 -> 1 -> 2. 
// The sorted list for the given linked list will be 0 -> 1 -> 1 -> 2 -> 2.

/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
    
     Node()
     {
         this.data = 0;
         this.next = null;
     }
    
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
    
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 }

 *****************************************************************/

public class Solution
{
    public static Node sortList(Node head) {
        // Write your code here
        Node dummy1 = new Node(-1);
        Node d1 = dummy1;
        Node dummy2 = new Node(-2);
        Node d2 = dummy2;
        Node dummy3 = new Node(-3);
        Node d3 = dummy3;
        Node ptr = head;
        while(ptr!=null)
        {
            if(ptr.data==0)
            {
                d1.next = ptr;
                d1=d1.next;
                ptr=d1.next;
                d1.next=null;
            }
            else if(ptr.data==1)
            {
                d2.next = ptr;
                d2=d2.next;
                ptr=d2.next;
                d2.next=null;
            }
            else if(ptr.data==2)
            {
                d3.next = ptr;
                d3=d3.next;
                ptr=d3.next;
                d3.next=null;
            }
        }

        dummy1=dummy1.next;
        dummy2=dummy2.next;
        dummy3=dummy3.next;

        d1.next = dummy2;
        d2.next = dummy3;
        return dummy1;
    }
}
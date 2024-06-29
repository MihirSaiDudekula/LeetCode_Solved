// Sort a linked list of 0s, 1s and 2s
// Difficulty: EasyAccuracy: 60.75%Submissions: 176K+Points: 2
// Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.

// Example 1:

// Input:
// N = 8
// value[] = {1,2,2,1,2,0,2,2}
// Output: 0 1 1 2 2 2 2 2
// Explanation: All the 0s are segregated
// to the left end of the linked list,
// 2s to the right end of the list, and
// 1s in between.
// Example 2:

// Input:
// N = 4
// value[] = {2,2,0,1}
// Output: 0 1 2 2
// Explanation: After arranging all the
// 0s,1s and 2s in the given format,
// the output will be 0 1 2 2.
// Your Task:
// The task is to complete the function segregate() which segregates the nodes in the linked list as asked in the problem statement and returns the head of the modified linked list. The printing is done automatically by the driver code.

// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(N).

// Constraints:
// 1 <= N <= 106

class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        Node zHead = null;
        Node oHead = null;
        Node tHead = null;
        
        Node z = null;
        Node o = null;
        Node t = null;
        
        Node start = head;
        Node curr = null;
        
        while (start != null) {
            curr = start;
            start = curr.next;
            curr.next = null;
            
            if (curr.data == 0) {
                if (z == null) {
                    z = curr;
                    zHead = z;
                } else {
                    z.next = curr;
                    z = z.next;
                }
            } else if (curr.data == 1) {
                if (o == null) {
                    o = curr;
                    oHead = o;
                } else {
                    o.next = curr;
                    o = o.next;
                }
            } else if (curr.data == 2) {
                if (t == null) {
                    t = curr;
                    tHead = t;
                } else {
                    t.next = curr;
                    t = t.next;
                }
            }
        }
        
        if (zHead == null) {
            //no zero, only 1 and 2's
            if (oHead == null) {
                //only twos
                return tHead;
            } else {
                //ones and twos
                o.next = tHead;
                return oHead;
            }
        } else {
            z.next = oHead;
            if (oHead == null) {
                // no ones
                z.next = tHead;
                //only zeroes or zeroes and twos
                return zHead;
            } else {
                o.next = tHead;
                return zHead;
            }
        }
    }
}
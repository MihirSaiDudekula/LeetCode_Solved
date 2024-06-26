// 142. Linked List Cycle II
// Solved
// Medium
// Topics
// Companies
// Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

// Do not modify the linked list.

// Example 1:


// Input: head = [3,2,0,-4], pos = 1
// Output: tail connects to node index 1
// Explanation: There is a cycle in the linked list, where tail connects to the second node.

//MATHS
/*
slow moves 1 step at a time, fast moves 2 steps at a time.

when slow and fast meet each other, they must be on the cycle

x denotes the distance to be coveres before reaching the starting of the circle/cycle

y denotes the distance from the start of the cycle to where slow and fast meet

C denotes the length of the cycle

when they meet, slow traveled (x + y) steps while fast traveled 2 * (x + y) steps, and the extra distance (x + y) must be a multiple of the circle length C,because fast pointer reaches slow exactly after making N laps of the circle - imagine a car race 

note that x, y, C are all lengths or the number of steps need to move.

head, slow, fast are pointers.

now, after we confirm the existence of a loop
if head moves x steps and arrives at the start of the cycle.

so we have x + y = N * C, 

let slow continue to travel from y and after x more steps, slow will return to the start of the cycle.

At the same time, according to the definition of x, head will also reach the start of the cycle after moving x steps.
so if head and slow start to move at the same time, they will meet at the start of the cycle, that is the answer.
Time  Complexity: O(N)
Space Complexity: O(1)

*/

public class Solution {
  public ListNode detectCycle(ListNode head) {
    // Initialize two pointers, slow and fast, to the head of the linked list.
    ListNode slow = head;
    ListNode fast = head;

    // Move the slow pointer one step and the fast pointer two steps at a time through the linked list,
    // until they either meet or the fast pointer reaches the end of the list.
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        //by our mathematical explanaion above we know that now wherever head
        //and slow meet after single node moving
        ListNode temp = head;
        while (slow != temp) {
          slow = slow.next;
          temp = temp.next;
        }
        return slow;
      }
    }

    // If the fast pointer reaches the end of the list without meeting the slow pointer,
    // there is no cycle in the linked list. Return null.
    return null;
  }
}
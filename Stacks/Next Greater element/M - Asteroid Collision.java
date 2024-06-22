// 735. Asteroid Collision
// Solved
// Medium
// Topics
// Companies
// Hint
// We are given an array asteroids of integers representing asteroids in a row.

// For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

// Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

// Example 1:

// Input: asteroids = [5,10,-5]
// Output: [5,10]
// Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
// Example 2:

// Input: asteroids = [8,-8]
// Output: []
// Explanation: The 8 and -8 collide exploding each other.
// Example 3:

// Input: asteroids = [10,2,-5]
// Output: [10]
// Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 

// Constraints:

// 2 <= asteroids.length <= 104
// -1000 <= asteroids[i] <= 1000
// asteroids[i] != 0

import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            if (a > 0) 
            {
                stack.push(a);
            } 
            else 
            { // a < 0
                // while(as long as) we see a more negative number than stack top  
                // Destroy the previous positive one(s).
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a) 
                {
                    stack.pop();
                }
                //the number in hand is negative, and the stack is empty
                // or the stack also has negatives at the top 
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(a);
                }
                // the top of the stack is same in value opp sign  
                else if (stack.peek() == -a) 
                {
                    stack.pop(); // Both asteroids explode.
                } 
                else 
                {
                    // stack.peek() > the current asteroid.
                    // which is actually stack.peek() > -a
                    // Destroy the current asteroid, so do nothing.
                    continue;
                }
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}

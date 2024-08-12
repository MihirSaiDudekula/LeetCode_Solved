// reverse using recursion

class GfG {
    // Function to reverse the queue.
    public Queue<Integer> rev(Queue<Integer> q) {
        if (q.isEmpty()) {
            return q;
        }
        
        int front = q.poll(); // Remove the front element
        
        // Recursively reverse the remaining queue
        q = rev(q);
        
        // Insert the front element to the rear of the reversed queue
        q.offer(front);
        
        return q;
    }
}
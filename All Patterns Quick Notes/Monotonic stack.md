You're **absolutely right**—there's a clear pattern in **monotonic stack** problems like Next Greater Element (NGE), Trapping Rain Water, and others. Let's break it down:  

---

### **Understanding the Pattern: "for - while - if - push"**
The typical stack-based approach follows this sequence:

**for loop** → Traverse each element of the array  
**while loop** → Pop from the stack while the condition holds  
**if condition** → Process the stack (e.g., store an answer)  
**push to stack** → Store the current index  

#### **Why does this pattern work?**
- The **while loop** ensures the stack **only stores useful elements** by removing elements that are no longer relevant.
- The **if condition** is where we derive our answer for the current element.
- The **push step** ensures that we can process future elements efficiently.

---

### **Breaking it Down with an Example: Previous Less Element (PLE)**
This code finds the **Previous Less Element (PLE)** for every index in the array.

```java
for (int i = 0; i < n; i++) {  
    while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) { 
        stack.pop();
    }
    if (!stack.isEmpty()) {  
        PLE[i] = stack.peek();
    }
    stack.push(i);  
}
```

---

### **Why These Steps Are Important**
#### **1️⃣ The `for` loop → Iterate over every element**
We need to process each element **once**, and we do this in **left-to-right order**.

#### **2️⃣ The `while` loop → Maintain the monotonic property**
- We are maintaining a **monotonic increasing stack** (smallest element at the top).
- If `arr[stack.peek()] >= arr[i]`, that means **it cannot be the previous less element**, so we pop it.

#### **3️⃣ The `if` condition → Find the useful result**
- If the stack is not empty, that means we have found a **valid Previous Less Element**.

#### **4️⃣ The `push` step → Store the index for future elements**
- Every element needs to be stored because it **might be useful for a future element**.

---

### **Applying This to Next Greater Element (NGE)**
If we modify this pattern slightly, we can solve **NGE**:

```java
for (int i = 0; i < n; i++) {  // Traverse array
    while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {  // Pop smaller elements
        stack.pop();
    }
    if (!stack.isEmpty()) {  // The remaining top is NGE
        NGE[i] = stack.peek();
    }
    stack.push(i);  // Store the current index
}
```
🚀 **Notice the only change?**  
- Instead of **`>=`**, we use **`<=`** to maintain a decreasing stack.

---

### **Conclusion**
The pattern works because:
1. **The while loop maintains a monotonic stack** (either increasing or decreasing).
2. **The if condition processes results efficiently**.
3. **Pushing the index ensures we can use this information later**.

This is why **all monotonic stack problems** (like NGE, Rainwater, Histogram, etc.) follow this structure! 😃

# Monotonic Stack Pattern: A Comprehensive Guide

## What is a Monotonic Stack?

A monotonic stack is a stack that maintains elements in either strictly increasing order (monotonic increasing) or strictly decreasing order (monotonic decreasing). This data structure is particularly useful for problems where we need to find the "next greater element" or "next smaller element" for each element in an array.

## The Core Pattern

1. **Initialize a stack** (typically storing indices rather than values)
2. **Iterate through the array** elements
3. **While loop for stack maintenance**: 
   - For monotonic increasing: pop while current element < stack top element
   - For monotonic decreasing: pop while current element > stack top element
4. **Process the popped elements** (calculate spans, areas, etc.)
5. **Push the current element** (or its index) onto the stack
6. **Process any remaining elements** in the stack after the main iteration

## Common Problem Types and Variations

### Type 1: Next Greater/Smaller Element
Finding the next greater or smaller element for each position in an array.

### Type 2: Previous Greater/Smaller Element
Finding the previous greater or smaller element for each position in an array.

### Type 3: Span Calculation
Calculating distances between elements and their next/previous greater/smaller elements.

### Type 4: Area/Volume Calculation
Using heights/widths bounded by next/previous greater/smaller elements to calculate areas or volumes.

## Problem Examples

### 1. Stock Span Problem (Span Calculation)

**Problem**: Find consecutive days before today (including today) where stock price was less than or equal to today's price.

**Stack Type**: Monotonic decreasing (prices)

**Approach**:
```
Initialize stack and spans array
For each price at index i:
    While stack not empty AND price[i] >= price[stack.top()]:
        Pop from stack
    If stack is empty:
        spans[i] = i + 1
    Else:
        spans[i] = i - stack.top()
    Push i onto stack
Return spans array
```

**Key Insight**: The stack maintains indices of days with higher prices. When we pop elements, we're removing days that aren't relevant for the current day's span calculation.

### 2. Largest Rectangle in Histogram (Area Calculation)

**Problem**: Find the largest rectangular area possible in a histogram.

**Stack Type**: Monotonic increasing (heights)

**Approach**:
```
Initialize stack and maxArea = 0
For each bar at index i (including a sentinel 0-height bar at the end):
    While stack not empty AND heights[i] < heights[stack.top()]:
        height = heights[stack.pop()]
        width = stack.empty() ? i : i - stack.top() - 1
        maxArea = max(maxArea, height * width)
    Push i onto stack
Return maxArea
```

**Key Insight**: When we encounter a shorter bar, we can calculate the maximum rectangle with the height of each taller bar (popped from stack). The width extends from the previous smaller bar to the current smaller bar.

### 3. Trapping Rainwater (Volume Calculation)

**Problem**: Calculate how much water can be trapped between bars of a histogram.

**Stack Type**: Monotonic decreasing (heights)

**Approach**:
```
Initialize stack and total water = 0
For each bar at index i:
    While stack not empty AND heights[i] > heights[stack.top()]:
        bottom = heights[stack.pop()]
        If stack is empty:
            break
        width = i - stack.top() - 1
        height = min(heights[stack.top()], heights[i]) - bottom
        water += width * height
    Push i onto stack
Return total water
```

**Key Insight**: Water can be trapped between two higher bars. When we find a higher bar, we calculate the water trapped above each lower bar (popped from stack) between the current bar and the previous higher bar.

## Common Implementation Patterns

1. **Using indices instead of values**: This allows access to both the element value and its position
2. **Adding sentinel elements**: Often adding a 0 height at the end simplifies processing
3. **Two-pass approaches**: Sometimes scanning left-to-right and right-to-left simplifies the solution
4. **Pre-computation**: Computing next/previous greater/smaller arrays first

## Time and Space Complexity

For all these problems:
- **Time Complexity**: O(n) - Each element is pushed and popped at most once
- **Space Complexity**: O(n) - In the worst case, all elements might be in the stack

## Decision Guide: When to Use a Monotonic Stack

Consider a monotonic stack when:
- You need to find the next/previous greater/smaller element
- You're calculating spans, areas, or volumes based on array elements
- You need to find boundaries where elements change their relative ordering
- The problem involves finding the closest element meeting a certain criteria
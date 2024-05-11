Possible types of problems and in which type Binary Search can be applied or not:

1) When Input is sorted:
In this case, Identification as a binary search problem is very straightforward as we can easily deduce which half needs to be removed from the search space.

2)When Input is unsorted but the problem follows a monotonic nature:
In this case also binary search can be applied as the problem follows a monotonic nature which means the function can be either increasing or decreasing with an increase in a parameter so that one-half can be removed from search space.

3)When the Expected answer is ordered:
Whenever we can identify that the answer to the problem lies between in a range L to R and there is a Monotonic Behaviour of the answer in range L to R then we can think to apply binary search on the answer.

4)When Neither input is sorted nor the problem follows monotonic behavior:
In this case we can not apply binary search.



Monotonic function

Binary search works well with monotonic functions because it leverages the property that as you move along the function's domain (the input values), the function's output values either consistently increase or decrease.

Imagine you're searching for a specific value in a sorted list. You can start in the middle, compare the value you're searching for with the middle element, and based on whether it's greater or smaller, you can eliminate half of the remaining search space. Then you repeat this process in the remaining half, and so on, until you find the desired value.

Similarly, in the case of monotonic functions, when you're looking for a specific output value, you can start with an initial guess in the middle of the input range. Then, based on whether the function's output at that point is greater or smaller than the desired value, you can eliminate half of the input range and repeat the process in the remaining half. This process continues until you narrow down the input range to the point where you find the desired output value.

In essence, binary search efficiently exploits the fact that in monotonic functions, the behavior of the function as you move along the input range is predictable: it either consistently increases or consistently decreases. This predictability allows binary search to quickly converge to the desired input value, making it a powerful algorithm for optimization and searching tasks.

ask yourself the question

Given the mid, can i PREDICT BOTH SIDES OF THE MID (the monotonicity/pattern)? 
if yes, then use BS
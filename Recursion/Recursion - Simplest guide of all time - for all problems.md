1. Recursion is basically a function calling itself. within the function body,whenever we encounter a call to the same function(recursive call), we need to go back to the first line of the function body and start executing again.

2.But just before going back to line 1, we push all our current progress (the variables,etc.) into a function call stack.

3.on each function call, the call is added to the call stack and whenever we encounter the `return` statement, the function is popped from the call stack

4.so, this process of adding to call stack goes on until a base case is satisfied. base case is that case of recursion which indicates the end of the process. usually, it is determined by one of the variables that are saved in the call stack(in point no.2)
`syntax`
```java
if(/*condition*/)
{
	/*final remaining process*/
	return;
}
```

5.the return value of the recursion depends on what type of data the function returns. the variables and data structures like(arraylist,set,etc) must be passed by reference for modification of the actual structure. so if the current function doesnt have the required return type and parameters, define a new function and recurse it.

6. once a particular call reaches return, it exits from the call stack and goes back to the `next line of the previous call`. that is -> it goes back to the line which had called it and continues from there. the data for that is stored at the topmost call of the call stack.

7.while drawing the recursion tree of the recursion. for a particular node , the number of branches that emerge out from it , is equal to the number of recursive calls in the code.

ex: in fibonacci sequence code :
`return fibo(n-1)+fibo(n-2)`

can be re written as 
`int x = fibo(n-1)
 int y = fibo(n-2)
 return x+y`

 so if n were to be 5, from 5, the node for 4 originates on 1 side and 3 originates on the other side. this indicates the prescence of 2 recursive calls in single function body - a hint in problem solving.

this is more apparent in permutations questions and merge sort algo

8.The number of branches need not be constant either,(like fibo has a constant 2), in permutation based problems, it varies at each level, so these calls are then put into for/while loops.

```java
for (i=0;i<n;i++) {
	funcs(a,b,i);
}
```

9.DP is an extension of multiple recursion. the idea is to memoize existing recursion trees instead of rebuilding them
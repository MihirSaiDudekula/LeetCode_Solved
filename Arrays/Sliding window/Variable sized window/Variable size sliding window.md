1. There are 2 variables which act as 2 pointers. i and j.

2. 1 of these variables will traverse th entire array
in a for loop, usually the right variable , i.e j

`for (int j = 0; j < s.length(); j++)`

3. hashmaps are often used to keep track of count of characters if used in the problem.
`HashMap<Character, Integer> map = new HashMap<>();`

4. The most important step is to increase the max valuse according to the questions requirements.

in cases where longest window,etc is asked , this computation need not necessarily happen only when the condtion is staisfied but van happen all the time

ex:
Longest Substring Without Repeating Characters, the longest window will not be only computed when we encounter a repeated character - as one may assume

since there may be strings where no character ever repeats, we need to always keep track of longest string

ex: in the string `abcde` the entire string = the entire window = Longest Substring Without Repeating Characters
`maxLength = Math.max(maxLength, j - i + 1);`


5.general code structure looks like this:
```java
	for (int j = 0; j < nums.length; j++) {
	    sum += nums[j];

	    while (sum > goal) {
	        sum -= nums[i++];
	    }

	    if (sum == goal) {
	        count++;
	    }
	}
```
- a changing variable : sum
- while comes first and checks for exceeding condition, for which it does i++ and reduces the changing variable,so we can proceed, as a solution
- matching condition in which we perform the req operation
ex:
`if (sum == goal) {count++;}`

 
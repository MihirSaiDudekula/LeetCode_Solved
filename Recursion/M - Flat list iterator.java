// 341. Flatten Nested List Iterator
// Solved
// Medium
// Topics
// Companies
// You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.

// Implement the NestedIterator class:

// NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
// int next() Returns the next integer in the nested list.
// boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
// Your code will be tested with the following pseudocode:

// initialize iterator with nestedList
// res = []
// while iterator.hasNext()
//     append iterator.next() to the end of res
// return res
// If res matches the expected flattened list, then your code will be judged as correct.

 

// Example 1:

// Input: nestedList = [[1,1],2,[1,1]]
// Output: [1,1,2,1,1]
// Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
// Example 2:

// Input: nestedList = [1,[4,[6]]]
// Output: [1,4,6]
// Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 

// Constraints:

// 1 <= nestedList.length <= 500
// The values of the integers in the nested list is in the range [-106, 106].

public class NestedIterator implements Iterator<Integer> {
    private List<Integer> flat;
    private int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        flat = new ArrayList<>();
        index = 0;
        flat = flatten(nestedList);
    }

    private List flatten(List<NestedInteger> nestedList) {
        List<Integer> result = new ArrayList<>();
        for (NestedInteger x : nestedList) {
            if (x.isInteger()) {
                result.add(x.getInteger());
            } else {
                result.addAll(flatten(x.getList()));
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        return flat.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < flat.size();
    }
}



/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
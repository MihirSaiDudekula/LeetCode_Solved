# Sorting Algorithms Guide

## 1. Problem Identification

### General Sorting Indicators
- Need to arrange elements in ascending/descending order
- Keywords: "sort", "order", "arrange", "rank"
- Requirements about comparison-based ordering
- Specific constraints about space/time complexity

### Algorithm-Specific Indicators

1. **Bubble Sort**
   - Small array size
   - Nearly sorted array
   - Simple implementation needed
   - Teaching/learning context

2. **Insertion Sort**
   - Small array size
   - Online sorting (stream of data)
   - Nearly sorted array
   - Memory constraints

3. **Selection Sort**
   - Small array size
   - Memory writing needs to be minimized
   - Simple implementation needed
   - Stable sort not required

4. **Quick Sort**
   - Large array size
   - Average case O(nlogn) needed
   - In-place sorting required
   - Random access to elements

5. **Merge Sort**
   - Stable sorting required
   - Linked list sorting
   - External sorting
   - Guaranteed O(nlogn) needed

## 2. General Steps

### Bubble Sort
1. Start from beginning of array
2. Compare adjacent elements
3. Swap if out of order
4. Continue to end of unsorted portion
5. Repeat until no swaps needed

### Insertion Sort
1. Start from second element
2. Compare with sorted portion, the LHS
3. Shift larger elements right
4. Insert element in correct position
5. Repeat for all elements

### Selection Sort
1. Find minimum in unsorted portion
2. Swap with first unsorted position
3. Move boundary of sorted portion
4. Repeat until array sorted

### Quick Sort
1. Choose pivot element
2. Partition array around pivot
3. Recursively sort left partition
4. Recursively sort right partition
5. Combine results

### Merge Sort
1. Divide array into two halves
2. Recursively sort each half
3. Merge sorted halves
4. Use auxiliary space for merging
5. Copy back to original array

## 3. Code Templates

```java
public class SortingAlgorithms {
    // Bubble Sort Template
    public void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Insertion Sort Template
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Selection Sort Template
    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                swap(arr, i, minIdx);
            }
        }
    }

    // Quick Sort Template
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Merge Sort Template
    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        
        for (i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

## 4. Common Variations

### Bubble Sort Variations
1. **Bidirectional Bubble Sort (Cocktail Sort)**
   - Modification: Traverse both directions
   - Focus: Handles turtle values better

2. **Odd-Even Sort**
   - Modification: Alternate between odd and even indices
   - Focus: Parallel implementation possible

### Insertion Sort Variations
1. **Binary Insertion Sort**
   - Modification: Use binary search for insertion point
   - Focus: Reduces comparisons

2. **Shell Sort**
   - Modification: Use gap sequence
   - Focus: Improved efficiency for large arrays

### Quick Sort Variations
1. **Three-Way Quick Sort**
   - Modification: Handle equal elements separately
   - Focus: Better handling of duplicates

2. **Dual Pivot Quick Sort**
   - Modification: Use two pivots
   - Focus: Better performance on many types of data

### Merge Sort Variations
1. **Bottom-up Merge Sort**
   - Modification: Iterative instead of recursive
   - Focus: Better for linked lists

2. **In-place Merge Sort**
   - Modification: Minimize extra space
   - Focus: Space efficiency

## 5. Common Error Solutions

### Implementation Solutions
1. **Boundary Checking**
   - Always validate array indices
   - Handle empty or single-element arrays
   - Check for null arrays

2. **Pivot Selection (Quick Sort)**
   - Use median-of-three for pivot
   - Handle duplicate elements properly
   - Consider random pivot selection

3. **Memory Management (Merge Sort)**
   - Reuse temporary arrays
   - Consider in-place merging
   - Handle large arrays efficiently

4. **Stability Maintenance**
   - Compare equal elements' original positions
   - Maintain relative order during swaps
   - Use stable merge implementation

5. **Recursion Handling**
   - Check stack depth
   - Consider iterative implementations
   - Handle base cases properly

## 6. Edge Cases

### Input Array Characteristics
1. **Array Size**
   - Empty array
   - Single element
   - Two elements
   - Very large arrays
   - Power of 2 sized arrays

2. **Element Values**
   - All elements same
   - All elements different
   - Negative numbers
   - Integer overflow cases
   - NaN/Infinity (for float arrays)

3. **Initial Ordering**
   - Already sorted
   - Reverse sorted
   - Nearly sorted
   - Random order
   - Partially sorted

4. **Special Patterns**
   - Many duplicates
   - No duplicates
   - Alternating elements
   - Palindrome array
   - Cyclic array

5. **Memory Constraints**
   - Limited memory
   - Cache considerations
   - Stack depth limits
   - Memory alignment issues
   - External sorting needs
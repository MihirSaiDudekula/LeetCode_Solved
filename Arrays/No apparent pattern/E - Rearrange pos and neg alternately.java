// Rearrange Array Elements by Sign


// 51

// 1
// Variety-1

// Problem Statement:

// There’s an array ‘A’ of size ‘N’ with an equal number of positive and negative elements. Without altering the relative order of positive and negative elements, you must return an array of alternately positive and negative values.

// Note: Start the array with positive elements.

// Examples: 

// Example 1:

// Input:
// arr[] = {1,2,-4,-5}, N = 4
// Output:
// 1 -4 2 -5

// Explanation: 

// Positive elements = 1,2
// Negative elements = -4,-5
// To maintain relative ordering, 1 must occur before 2, and -4 must occur before -5.

// Example 2:
// Input:
// arr[] = {1,2,-3,-1,-2,-3}, N = 6
// Output:
// 1 -3 2 -1 3 -2
// Explanation: 

// Positive elements = 1,2,3
// Negative elements = -3,-1,-2
// To maintain relative ordering, 1 must occur before 2, and 2 must occur before 3.
// Also, -3 should come before -1, and -1 should come before -2.

import java.util.*;

class PosNegAlt{

public static int[] RearrangebySign(int[] A, int n){
    
  // Define 2 vectors, one for storing positive 
  // and other for negative elements of the array.
  ArrayList<Integer> pos=new ArrayList<>();
  ArrayList<Integer> neg=new ArrayList<>();
  
  // Segregate the array into positives and negatives.
  for(int i=0;i<n;i++){
      
      if(A[i]>0) pos.add(A[i]);
      else neg.add(A[i]);
  }
  
  // Positives on even indices, negatives on odd.
  for(int i=0;i<n/2;i++){
      
      A[2*i] = pos.get(i);
      A[2*i+1] = neg.get(i);
  }

 
  return A;
}    

public static void main(String args[]) 
{
  // Array Initialisation.
  int n = 4;
  int A[]= {1,2,-4,-5};


  int[]ans= RearrangebySign(A,n);
  
  for (int i = 0; i < n; i++) {
    System.out.print(ans[i]+" ");
  }

}
}
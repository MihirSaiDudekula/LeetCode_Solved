// Given an array arr[] of N elements, sort the array according to the following relations:  

//     arr[i] >= arr[i – 1], if i is even, ∀ 1 <= i < N
//     arr[i] <= arr[i – 1], if i is odd, ∀ 1 <= i < N

// Print the resultant array.

// Examples:  

//     Input: N = 4, arr[] = {1, 2, 2, 1}
//     Output: 2 1 2 1
//     Explanation:

//         For i = 1, arr[1] <= arr[0]. So, 1 <= 2.
//         For i = 2, arr[2] >= arr[1]. So, 2 >= 1.
//         For i = 3, arr[3] <= arr[2]. So, 1 <= 2.

//     Input: arr[] = {1, 3, 2}
//     Output: 3 1 2
//     Explanation:

//         For i = 1, arr[1] <= arr[0]. So, 1 <= 3.
//         For i = 2, arr[2] >= arr[1]. So, 2 >= 1.

import java.util.ArrayList;

class Solution{
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    ArrayList<Integer> assign(int a[], int n)
    {
        // Complete the function
        ArrayList <Integer> arl = new ArrayList<>();
        for(int i=1;i<n;i++)
        {
            if(i%2==0)
            {
                if(a[i]<a[i-1])
                {
                    swap(a,i,i-1);
                }
            }
            else
            {
                if(a[i]>a[i-1])
                {
                    swap(a,i,i-1);
                }
            }
            // System.out.println(x);
        }
        for(int x:a)
        {
            System.out.println(x);
            arl.add(x);
        }
        return arl;
    }
  
    
}

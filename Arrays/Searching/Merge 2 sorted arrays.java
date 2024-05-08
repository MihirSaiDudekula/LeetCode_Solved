import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List< Integer > sortedArray(int []a, int []b) {
        // Write your code here
        List<Integer> l = new ArrayList<Integer>();
        int i=0;
        int j=0;
        int n = a.length;
        int m = b.length;
        while(i<n && j<m)
        {
            if(a[i]<b[j])
            {
                l.add(a[i]);
                i++;
            }
            else if(a[i]>b[j])
            {
                l.add(b[j]);
                j++;
            }
            else if(a[i]==b[j])
            {
                l.add(a[i]);
                i++;
                j++;
            }

        }
                // Add remaining elements of array a, if any
        while (i < n) {
            l.add(a[i]);
            i++;
        }

        // Add remaining elements of array b, if any
        while (j < m) {
            l.add(b[j]);
            j++;
        }

        int k = 0;
        while (k < l.size() - 1) {
            if (l.get(k).equals(l.get(k + 1))) {
                l.remove(k + 1);
            } else {
                k++;
            }
        }

        return l;
    }
}

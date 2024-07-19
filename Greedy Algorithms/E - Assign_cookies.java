// 455. Assign Cookies
// Easy
// Topics
// Companies
// Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.

// Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

 

// Example 1:

// Input: g = [1,2,3], s = [1,1]
// Output: 1
// Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
// And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
// You need to output 1.
// Example 2:

// Input: g = [1,2], s = [1,2,3]
// Output: 2
// Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
// You have 3 cookies and their sizes are big enough to gratify all of the children, 
// You need to output 2.
 

// Constraints:

// 1 <= g.length <= 3 * 104
// 0 <= s.length <= 3 * 104
// 1 <= g[i], s[j] <= 231 - 1

                           
import java.util.Arrays;

public class Solution {
    // Function to find the maximum
    // number of content children
    public static int findContentChildren(int[] greed, int[] cookieSize) {
        // Get the size of the greed array
        int n = greed.length;

        // Get the size of the cookieSize array
        int m = cookieSize.length;

        // Sort the greed factors in ascending order to try and satisfy the least greedy children first
        Arrays.sort(greed);

        // Sort the cookie sizes in ascending order to use the smallest cookies first
        Arrays.sort(cookieSize);

        // Initialize a left pointer for the cookieSize array, starting from the first cookie
        int l = 0;

        // Initialize a right pointer for the greed array, starting from the first child
        int r = 0;

        // Iterate while there are both cookies and children left to consider, i.e ,we are within bounds
        while (l < m && r < n) {
            // If the current cookie can
            // satisfy the current child's greed
            if (greed[r] <= cookieSize[l]) {
                // Move to the next child,
                // as the current child is satisfied
                r++;
            }
            // Always move to the next cookie whether the current child was satisfied or not

            //this is because if we satisfy childs greed, then since we already did r++ above, we have satisfied his greed, so this cookie is assigned to child 'l' and we need to move to next cookie -> l++

            //if we didnt satisfy, it means we have come here if greed > cookieSize, which means that since the greed is more, this smaller value of cookie wont suffice/ we know the array is sorted and the larger cookie values are to the right hence -> l++
            l++;
        }

        // The value of r at the end of the loop represents the number of children that were satisfied (all children before rth index have been satisfied)
        return r;
    }
}
                            

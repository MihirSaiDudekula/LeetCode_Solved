// Floyd Warshall
// Difficulty: MediumAccuracy: 32.89%Submissions: 155K+Points: 4
// The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed graph. The graph is represented as an adjacency matrix. mat[i][j] denotes the weight of the edge from i to j. If mat[i][j] = -1, it means there is no edge from i to j.
// Note: Modify the distances for every pair in place.

// Examples :

// Input: mat = [[0, 25], [-1, 0]]

// Output: [[0, 25], [-1, 0]]

// Explanation: The shortest distance between every pair is already given(if it exists).
// Input: mat = [[0, 1, 43],[1, 0, 6], [-1, -1, 0]]

// Output: [[0, 1, 7], [1, 0, 6], [-1, -1, 0]]

// Explanation: We can reach 2 from 0 as 0->1->2 and the cost will be 1+6=7 which is less than 43.
// Constraints:
// 1 <= mat.size() <= 100
// -1 <= mat[ i ][ j ] <= 1000

class Solution {
    public void shortestDistance(int[][] mat) {
        // Code here
        int n = mat.length;
        

        // wherever there is -1, replace it with inf
        // coz we will be checking dist < dist + len 
        // if dist = -1, entire program messes up
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int)(1e9);
                }
                if (i == j) matrix[i][j] = 0;
            }
        }

        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(i==k||j==k||i==j)
                    {
                        continue;
                    }
                    else
                    {
                        mat[i][j] = Math.min(mat[i][j],
                                            mat[i][k] + mat[k][j]);
                    }
                }
            }
        }

        //revert to old state once done
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int)(1e9)) {
                    matrix[i][j] = -1;
                }
            }
        }
    }
}
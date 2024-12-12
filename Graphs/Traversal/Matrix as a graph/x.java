// class Solution {
//     public int shortestPathBinaryMatrix(int[][] grid) 
//     {
//         if(grid[0][0]==1)
//         {
//             return -1;
//         }

//         int m = grid.length;
//         int n = grid[0].length;

//         int r = 0;
//         int c = 0;
//         int path = 0;

//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[]{r,c});


//         while(!q.isEmpty())
//         {
//             int[] curr = q.poll();
//             int r = curr[0];
//             int c = curr[1];

//             if((r==m-1) && (c==n-1))
//             {
//                 break;
//             }

//             if(r+1<m && c+1<n)
//             {
//                 if(grid[r+1][c+1]==0)
//                 {
//                     path++;
//                     q.offer(new int[]{r+1, c+1});
//                 }
//                 else
//                 {
//                    if (r + 1 < m && grid[r + 1][c] == 0) 
//                    {
//                        q.offer(new int[]{r + 1, c});
//                    }
//                    else if (c + 1 < n && grid[r][c+1] == 0) 
//                    {
//                        q.offer(new int[]{r + 1, c});
//                    } 
//                 }
//             }

//             else if (r + 1 < m && grid[r + 1][c] == val) 
//             {
//                 q.offer(new int[]{r + 1, c});
//             }

//             if (r - 1 >= 0 && grid[r - 1][c] == val) {
//                 q.offer(new int[]{r - 1, c});
//             }

//             if (c + 1 < n && grid[r][c + 1] == val) {
//                 q.offer(new int[]{r, c + 1});
//             }

//             if (c - 1 >= 0 && grid[r][c - 1] == val) {
//                 q.offer(new int[]{r, c - 1});
//             }


//         }
        
//     }
// }



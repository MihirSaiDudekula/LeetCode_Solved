// Rat in a Maze Problem - I
// Difficulty: MediumAccuracy: 35.75%Submissions: 284K+Points: 4
// Consider a rat placed at (0, 0) in a square matrix mat of order n* n. It has to reach the destination at (n - 1, n - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
// Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell. In case of no path, return an empty list. The driver will output "-1" automatically.

// Examples:

// Input: mat[][] = [[1, 0, 0, 0],
//                 [1, 1, 0, 1], 
//                 [1, 1, 0, 0],
//                 [0, 1, 1, 1]]
// Output: DDRDRR DRDDRR
// Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.
// Input: mat[][] = [[1, 0],
//                 [1, 0]]
// Output: -1
// Explanation: No path exists and destination cell is blocked.
// Expected Time Complexity: O(3n^2)
// Expected Auxiliary Space: O(l * x)
// Here l = length of the path, x = number of paths.

// Constraints:
// 2 ≤ n ≤ 5
// 0 ≤ mat[i][j] ≤ 1

class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> paths = new ArrayList<>();
        if (mat.length == 0 || mat[0].length == 0) return paths; 
        makePaths("", paths, mat, 0, 0);
        return paths;
    }

    private void makePaths(String path, ArrayList<String> paths, int[][] mat, int row, int col) {
        int n = mat.length;
        int m = mat[0].length;

        // this is the check for out of bounds or unaccessible cell - the cell which cannot be included in a path - like a wall in a maze - indicated by 0 in the matrix
        // we simply go back to previous call when we encounter such a cell
        if (row < 0 || row >= n || col < 0 || col >= m || mat[row][col] == 0) {
            return;
        }

        if (row == n - 1 && col == m - 1) {
            paths.add(path);
            return;
        }

        // by this point, all cells must be of the value 1
        mat[row][col] = 0;
        //indicates visited, so that the path doesnt go backwards

        if (row + 1 < n) {
            makePaths(path + 'D', paths, mat, row + 1, col);
        }

        if (col + 1 < m) {
            makePaths(path + 'R', paths, mat, row, col + 1);
        }

        if (row - 1 >= 0) {
            makePaths(path + 'U', paths, mat, row - 1, col);
        }

        if (col - 1 >= 0) {
            makePaths(path + 'L', paths, mat, row, col - 1);
        }

        mat[row][col] = 1;
        //backtracking - we restore the state of the visited cell to unvisited so that now we can explore a new path with this cell as a junction point
    }
}
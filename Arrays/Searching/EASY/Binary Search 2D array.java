// https://leetcode.com/problems/search-a-2d-matrix/description/

// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n)) time complexity.

// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true

// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// Output: false

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //no of rows
        int nrows = matrix.length;
        //no of cols
        int ncols = matrix[0].length;

        int row = 0;
        int col = ncols-1;

        // together (row,col) is the element pointing to top right corner element of the matrix

        //we will be incrementing rows while decrementing columns
        while(row<nrows && col>=0)
        {
            if(matrix[row][col]==target)
            {
                return true;
            }
            if(matrix[row][col]<target)
            {
                //it is not in this row,
                // it is greater than the greatest(rightmost) element of this row,
                // so it is in the next row
                row++;
            }
            else
            {
                //it is in this row, just not in this column
                //this column is the rightmost, our element is smaller(towards left)
                //lets go back to the previous column then
                col--;
            }
        }
        //not found
        return false;
    }
}

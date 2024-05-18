// 69. Sqrt(x)
// Solved
// Easy
// Topics
// Companies
// Hint
// Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

// You must not use any built-in exponent function or operator.

class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int s = 1;
        int e = x / 2;
        while (s <= e) {
            int mid = s + ((e - s) / 2);
            long ms = (long) mid * mid;
            //dont forget to typecast
            System.out.println(ms);
            if (ms == x) {
                return mid;
            } else if (ms > x) {
                e = mid - 1;
            } else if (ms < x) {
                s = mid + 1;
            }
        }
        return e;
    }
}
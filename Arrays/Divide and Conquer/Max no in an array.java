// Function to find the maximum number
// in a given array.
static int findMax(int[] a, int lo, int hi)
{
    // If lo becomes greater than hi, then return
    // minimum integer possible
    if (lo > hi)
        return Integer.MIN_VALUE;
    // If the subarray has only one element, return the
    // element
    if (lo == hi)
        return a[lo];
    int mid = (lo + hi) / 2;
    // Get the maximum element from the left half
    int leftMax = findMax(a, lo, mid);
    // Get the maximum element from the right half
    int rightMax = findMax(a, mid + 1, hi);
    // Return the maximum element from the left and
    // right half
    return Math.max(leftMax, rightMax);
}

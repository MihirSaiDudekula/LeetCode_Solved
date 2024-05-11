public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target is present at the middle
            if (arr[mid] == target) {
                return mid;
            }
            // If the target is greater, ignore the left half
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            // If the target is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }
        // If we reach here, then the element was not present in the array
        return -1;
    }
}
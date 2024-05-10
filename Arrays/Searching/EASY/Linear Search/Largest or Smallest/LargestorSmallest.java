//largest and smallest in an array

public static int findLargest(int[] arr) {
        int max = arr[0]; // Assume the first element is the largest

        // Iterate through the array to find the largest element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int findSmallest(int[] arr) {
        int min = arr[0]; // Assume the first element is the smallest

        // Iterate through the array to find the smallest element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
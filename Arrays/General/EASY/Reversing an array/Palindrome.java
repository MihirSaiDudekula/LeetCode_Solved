//check if an arrays elements make a palindrome
// 12321

public static boolean isPalindrome(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        // Loop until start index is less than end index
        while (start < end) {
            // If elements at start and end indices are not equal, return false
            if (arr[start] != arr[end]) {
                return false;
            }
            // Move start index to the right and end index to the left
            start++;
            end--;
        }
        // If loop completes without returning false, array is a palindrome
        return true;
    }
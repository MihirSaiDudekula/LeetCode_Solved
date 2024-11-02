In Java, you can convert an integer to its binary representation using the `Integer.toBinaryString()` method. Here's a simple example:

```java
public class IntToBinary {
    public static void main(String[] args) {
        int number = 42; // Example integer
        String binaryString = Integer.toBinaryString(number);
        System.out.println("The binary representation of " + number + " is: " + binaryString);
    }
}
```
To extract each digit of a binary string one by one, you can use the `toCharArray()` method to convert the string into an array of characters. Then, you can iterate through the array, converting each character to an integer. Here's how you can do that:

```java
public class ExtractBinaryDigits {
    public static void main(String[] args) {
        int number = 42; // Example integer
        String binaryString = Integer.toBinaryString(number);
        
        // Convert the binary string to a char array
        char[] binaryChars = binaryString.toCharArray();
        
        // Iterate through each character and convert to int
        for (char c : binaryChars) {
            int digit = Character.getNumericValue(c); // Convert char to int
            System.out.println("Binary digit: " + digit);
        }
    }
}
```

### Explanation:
1. **Convert to Binary String:** `Integer.toBinaryString(number)` gets the binary representation.
2. **Convert to Char Array:** `binaryString.toCharArray()` converts the string to a character array.
3. **Iterate and Convert:** Using a `for` loop, `Character.getNumericValue(c)` converts each character back to its integer value (0 or 1).

You can replace `42` with any integer to see its binary digits.

In this code, `Integer.toBinaryString(number)` converts the integer `42` to its binary representation, which is `101010`. You can replace `42` with any integer you want to convert.

To convert a binary string back to an integer in Java, you can use the `Integer.parseInt()` method with a radix of 2. Here’s an example:

```java
public class BinaryToInt {
    public static void main(String[] args) {
        String binaryString = "101010"; // Example binary string
        int number = Integer.parseInt(binaryString, 2);
        System.out.println("The integer representation of binary " + binaryString + " is: " + number);
    }
}
```

In this code, `Integer.parseInt(binaryString, 2)` converts the binary string `101010` back to its integer representation, which is `42`. You can replace `101010` with any binary string you wish to convert.
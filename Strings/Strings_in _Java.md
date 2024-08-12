## Strings and StringBuilder in Java

### Introduction to Strings
- **Strings** in Java represent a sequence of characters.
- A string is stored using the `String` data type.
- Example: `String name = "kunal";`

### Internal Representation and Memory Allocation
- Strings are **objects** in Java and are managed in the heap memory.
- **Stack memory** holds references to these objects, while the actual data resides in the heap.

### String Pool
- Java uses a **String Pool** to manage memory efficiently.
- When you create a string, Java checks if the string already exists in the pool:
  - If it does, it reuses the existing string.
  - If it does not, it adds the new string to the pool.
- Example:
  ```java
  String a = "kunal";
  String b = "kunal";
  ```
  - Both `a` and `b` point to the same object in the String Pool.

### Immutability
- **Strings are immutable** in Java.
- Once a string object is created, it cannot be changed. 
- Modifying a string results in the creation of a new string object.
- Example:
  ```java
  
  String a = "kunal";
  a = "kushwaha"; // Creates a new string object, `a` now points to the new object
  ```

### Benefits of Immutability
- **Security**: Immutable objects are inherently thread-safe and prevent accidental modification.
- **Optimization**: Allows the use of string pools and efficient memory usage.

### Comparison of Strings
- Use `==` to compare **references**:
  - Checks if both references point to the same object.
  - Example:
    ```java
    System.out.println(a == b); // true if both `a` and `b` reference the same object
    ```

- Use `.equals()` to compare **values**:
  - Checks if the values of the strings are the same.
  - Example:
    ```java
    System.out.println(a.equals(b)); // true if the values of `a` and `b` are the same
    ```

### Creating Strings Explicitly
- To create a new string object bypassing the String Pool:
  ```java
  String a = new String("kunal");
  String b = new String("kunal");
  ```
  - `a` and `b` will be different objects, even though their values are the same.
  - `a == b` will return `false`.

### String Methods
- **Common methods** include:
  - `.length()`: Returns the length of the string.
  - `.charAt(index)`: Returns the character at the specified index.
  - `.substring(start, end)`: Returns a substring from `start` to `end`.

- Example:
  ```java
  String name = "kunal";
  int length = name.length(); // 5
  char firstChar = name.charAt(0); // 'k'
  String sub = name.substring(1, 3); // "un"
  ```

### StringBuilder
- **StringBuilder** is used to create mutable strings.
- Unlike `String`, `StringBuilder` allows modifications without creating new objects.
- **Common methods** include:
  - `.append()`: Adds content to the end.
  - `.insert()`: Inserts content at a specified index.
  - `.delete()`: Deletes characters from a specified range.
  - `.reverse()`: Reverses the content.

- Example:
  ```java
  StringBuilder sb = new StringBuilder("kunal");
  sb.append(" kushwaha"); // "kunal kushwaha"
  sb.insert(6, " Singh "); // "kunal Singh kushwaha"
  sb.delete(5, 11); // "kunal kushwaha"
  sb.reverse(); // "ahwsk lanuk"
  ```

### Summary
- **Strings** are immutable and managed in the String Pool for optimization.
- **StringBuilder** provides a mutable alternative for scenarios requiring frequent modifications.
- Proper use of `String` and `StringBuilder` can significantly impact performance and memory usage in Java applications.

Feel free to use this guide as a reference to understand and utilize strings and `StringBuilder` effectively in your Java projects.

### Java Object Printing and `toString` Method

#### **Overview of Object Printing**

In Java, when you use `System.out.println()` to print an object, Java needs to convert the object into a **string** representation. By default, this conversion is handled by the object's **`toString()`** method.

#### **Understanding the `toString()` Method**

1. **Default Behavior**:
   - When you print an object, Java uses the object's **`toString()`** method to convert it to a string.
   - If **`toString()`** is not overridden in the object's class, it will use the default implementation from the **`Object`** class.
   - The default **`toString()`** method returns a string that consists of the class name, the `@` character, and the object's **hash code** (e.g., `ClassName@HashCode`).

2. **Null Handling**:
   - If the object is **null**, `System.out.println()` will print `"null"`.

3. **Custom `toString()` Method**:
   - To provide a meaningful string representation, you can override the **`toString()`** method in your own classes.
   - This allows you to define how an object should be represented as a string (e.g., including specific fields like `name`, `rollNumber`, etc.).

#### **Example of `toString()` Implementation**

Consider a class `Student`:

```java
public class Student {
    private String name;
    private int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', rollNumber=" + rollNumber + "}";
    }
}
```

- In this example, the `toString()` method is overridden to provide a readable representation of the `Student` object.

#### **`Arrays.toString()` Method**

- For arrays, Java provides a utility method `Arrays.toString()` which provides a formatted string representation of the array.

Example usage:

```java
int[] numbers = {1, 2, 3, 4};
System.out.println(Arrays.toString(numbers)); // Output: [1, 2, 3, 4]
```

- This method formats the array in a way that's easier to read, including brackets and commas.

#### **Wrapper Classes and `toString()`**

- **Wrapper Classes** like `Integer`, `Double`, etc., in Java also override the **`toString()`** method.
- These classes allow primitive types (e.g., `int`, `double`) to be treated as objects.

Example:

```java
Integer num = 123;
System.out.println(num.toString()); // Output: "123"
```

- The `Integer` class wraps the primitive `int` and provides the `toString()` method to get a string representation.

#### **Primitive vs. Object-Oriented Types**

- **Primitive types** (e.g., `int`, `char`) are stored in stack memory and do not have methods.
- **Objects** are stored in heap memory and can use methods including `toString()`.

#### **Common Errors and Considerations**

- **NullPointerException**: Occurs if you try to call a method on a `null` object. Always check if an object is `null` before invoking methods on it.

Example:

```java
Student student = null;
System.out.println(student.toString()); // Throws NullPointerException
```

- **Wrapper Classes**: They provide object-oriented features for primitive types, allowing the use of methods like `toString()`.

### Code Example: Using `toString()`

```java
public class Example {
    public static void main(String[] args) {
        Student student = new Student("John Doe", 123);
        System.out.println(student); // Uses overridden toString method

        int[] numbers = {1, 2, 3, 4};
        System.out.println(Arrays.toString(numbers)); // Array representation

        Integer num = 456;
        System.out.println(num.toString()); // Wrapper class toString method
    }
}
```

- **Output**:
  - `Student{name='John Doe', rollNumber=123}`
  - `[1, 2, 3, 4]`
  - `456`

This summary covers the key aspects of printing objects and handling `toString()` in Java, including practical examples and considerations.

### Detailed Notes on Fast Input/Output and String Handling in Java

---

#### **1. Formatting Output in Java**

**1.1 Using `printf` for Formatting**

- **Objective**: Format and control the number of decimal places for floating-point numbers.

**Example**:
```java
float a = 453.123456f;
System.out.printf("Formatted number is %.2f", a);
```
- **Explanation**: The `%` symbol is used as a placeholder in the format string. The `.2f` specifies that the floating-point number should be printed with two decimal places. The result will be rounded if necessary.

**1.2 Printing Mathematical Constants**

- **Objective**: Print the value of mathematical constants with specific precision.

**Example**:
```java
import java.lang.Math;
System.out.printf("%.3f", Math.PI);
```
- **Explanation**: The `%.3f` in the format string limits the output to three decimal places for the constant `Math.PI`.

**1.3 String Formatting with Placeholders**

- **Objective**: Format strings by inserting variables into placeholders.

**Example**:
```java
System.out.printf("Hello my name is %s and I am %s", "Kunal", "cool");
```
- **Explanation**: The `%s` is a placeholder for strings. The order of placeholders determines which variable gets inserted where.

**1.4 List of Common Placeholders**

- **%d**: Integer values.
- **%f**: Floating-point numbers.
- **%s**: Strings.
- **%c**: Characters.
- **%x**: Hexadecimal integers.
- **%o**: Octal integers.
- **%e**: Exponential notation.
- **%b**: Boolean values.

---

#### **2. Operators and Type Handling**

**2.1 Character and String Addition**

- **Objective**: Understand the behavior of addition operators with characters and strings.

**Examples**:
```java
char a = 'A';
char b = 'B';
System.out.println(a + b); // Prints integer value of the sum of their ASCII values

String str = "A";
System.out.println(str + 'B'); // Concatenates characters to the string
```
- **Explanation**: When adding characters directly, their ASCII values are summed. When adding a character to a string, it concatenates.

**2.2 String and Integer Concatenation**

- **Objective**: Handle concatenation of strings and integers.

**Example**:
```java
int num = 1;
String str = "Number: ";
System.out.println(str + num); // Outputs "Number: 1"
```
- **Explanation**: The integer is converted to a string before concatenation.

**2.3 Addition of Complex Data Types**

- **Objective**: Combine strings with complex objects.

**Example**:
```java
ArrayList<Integer> list = new ArrayList<>();
list.add(1);
System.out.println("ArrayList: " + list);
```
- **Explanation**: When printing objects like `ArrayList`, their `toString()` method is invoked to produce a string representation.

---

#### **3. Performance Considerations with Strings**

**3.1 String Immutability**

- **Objective**: Understand the impact of string immutability on performance.

**Example**:
```java
String series = "";
for (int i = 0; i < 26; i++) {
    char ch = (char) ('a' + i);
    series += ch;
}
```
- **Explanation**: Each concatenation creates a new string object, leading to a time complexity of **O(n^2)** due to repeated copying.

**3.2 Efficient String Manipulation with `StringBuilder`**

- **Objective**: Use `StringBuilder` to improve performance when modifying strings.

**Example**:
```java
StringBuilder builder = new StringBuilder();
for (int i = 0; i < 26; i++) {
    char ch = (char) ('a' + i);
    builder.append(ch);
}
String result = builder.toString();
System.out.println(result);
```
- **Explanation**: `StringBuilder` allows appending characters without creating new string objects each time, leading to **O(n)** time complexity.

---

#### **4. Common String Methods**

**4.1 Converting to Lowercase/Uppercase**

**Example**:
```java
String name = "Hello";
System.out.println(name.toLowerCase()); // Output: hello
System.out.println(name.toUpperCase()); // Output: HELLO
```

**4.2 Getting Characters and Bytes**

**Example**:
```java
String name = "Hello";
char[] charArray = name.toCharArray();
byte[] byteArray = name.getBytes();
```

**4.3 Trimming and Splitting Strings**

**Example**:
```java
String text = "   Hello World   ";
System.out.println(text.strip()); // Removes leading and trailing spaces

String[] words = text.split(" ");
System.out.println(Arrays.toString(words)); // Outputs [Hello, World]
```

**4.4 Checking Palindromes**

**Objective**: Check if a string is a palindrome.

**Example**:
```java
public static boolean isPalindrome(String str) {
    str = str.toLowerCase();
    int left = 0, right = str.length() - 1;
    while (left < right) {
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}
```
- **Explanation**: Compares characters from both ends moving towards the center.

---

### **Conclusion**

Understanding efficient string manipulation and formatting in Java is crucial for optimizing performance and ensuring correct output. Using classes like `StringBuilder` and methods for string manipulation can significantly enhance the efficiency of your code.

---

If you have further questions or need additional examples, feel free to ask!
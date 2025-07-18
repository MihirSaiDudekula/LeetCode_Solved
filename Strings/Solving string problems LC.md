## 🧰 Common Java Tools for Strings & Arrays

Here’s your Java "toolbox" — a few key methods and techniques you'll see **over and over** in problems.

---

### 1. **charAt()** – Access Individual Characters

```java
String word = "apple";
char c = word.charAt(0);  // 'a'
```

---

### 2. **substring()** – Extract Substrings

```java
String word = "hello";
String part = word.substring(1, 4);  // "ell"
```

---

### 3. **toCharArray()** – Convert String to Array of Chars

```java
char[] chars = "leetcode".toCharArray();
```

---

### 4. **split()** – Break a String by a Delimiter

```java
String s = "a,b,c";
String[] parts = s.split(",");  // ["a", "b", "c"]
```

---

### 5. **Arrays.toString()** – Print Array Nicely

```java
System.out.println(Arrays.toString(new int[]{1, 2, 3}));
```

---

## 🔧 Data Type Conversion Techniques

### 1. Convert `char` to `int` (for digit characters)

```java
char c = '5';
int digit = c - '0';  // 5
```

### 2. Convert `String` to `int`

```java
int num = Integer.parseInt("123");  // 123
```

### 3. Convert `int` to `String`

```java
String str = String.valueOf(123);  // "123"
```

### 4. Convert `int[]` to `String`

```java
int[] arr = {1, 2, 3};
StringBuilder sb = new StringBuilder();
for (int num : arr) {
    sb.append(num);
}
String result = sb.toString();  // "123"
```

---

## 💡 High-Value Concepts & Patterns

### 1. **Using `HashMap` for Frequency Count**

Great for problems like anagrams, counting chars, etc.

```java
Map<Character, Integer> freq = new HashMap<>();
for (char c : s.toCharArray()) {
    freq.put(c, freq.getOrDefault(c, 0) + 1);
}
```

---

### 2. **Two Pointers**

Used for palindromes, removing duplicates, merging sorted arrays, etc.

```java
int left = 0, right = s.length() - 1;
while (left < right) {
    if (s.charAt(left) != s.charAt(right)) return false;
    left++;
    right--;
}
```

---

### 3. **Sliding Window**

Used for longest substring, subarray sums, etc.

```java
int left = 0, maxLen = 0;
Set<Character> seen = new HashSet<>();

for (int right = 0; right < s.length(); right++) {
    while (seen.contains(s.charAt(right))) {
        seen.remove(s.charAt(left++));
    }
    seen.add(s.charAt(right));
    maxLen = Math.max(maxLen, right - left + 1);
}
```

---

### 4. **StringBuilder for Efficient String Manipulation**

```java
StringBuilder sb = new StringBuilder();
sb.append("leet");
sb.append("code");
System.out.println(sb.toString());  // "leetcode"
```

---

### 5. **Regular Expressions (Advanced Tool)**

```java
String s = "abc123";
boolean matched = s.matches("[a-z]+\\d+");  // true
```
---

Absolutely, Mihir — great instinct here. While your current toolbox covers the **essentials**, Java offers **many more string methods** and **tricks** that can help you *write cleaner, faster, and more efficient solutions* to LeetCode problems — especially with string parsing, comparisons, and manipulations.

Let’s now expand the toolbox with **all relevant string methods and techniques** you’ll find helpful for LeetCode.

---


### 5. `equals()` vs. `==` — String Comparison

⚠️ **Important:** Use `equals()` for comparing values, not `==`.

```java
String a = "abc", b = "abc";
System.out.println(a.equals(b));  // true
System.out.println(a == b);       // false (sometimes)
```

---

### 6. `equalsIgnoreCase()` — Case-insensitive Comparison

```java
"aBc".equalsIgnoreCase("AbC");  // true
```

---

### 7. `contains()` — Substring Check

Perfect for substring problems.

```java
"leetcode".contains("code");  // true
```

---

### 8. `startsWith()` and `endsWith()`

Useful in string pattern matching.

```java
String s = "banana";
s.startsWith("ba");  // true
s.endsWith("na");    // true
```

---

### 9. `indexOf()` and `lastIndexOf()`

To find the **first or last** occurrence of a character or substring.

```java
String s = "banana";
int i = s.indexOf('a');       // 1
int j = s.lastIndexOf("na"); // 4
```

---

### 10. `replace()` and `replaceAll()`

* `replace()` works on chars or substrings.
* `replaceAll()` uses **regex**.

```java
String s = "hello";
System.out.println(s.replace("l", "x"));      // "hexxo"
System.out.println(s.replaceAll("[aeiou]", ""));  // "hll"
```

---

### 11. `trim()` — Remove Leading & Trailing Spaces

Often needed when parsing.

```java
"  hello  ".trim();  // "hello"
```

---

### 12. `toLowerCase()` / `toUpperCase()` — Case Normalization

Crucial in problems involving **case-insensitive** processing.

```java
"AbC".toLowerCase();  // "abc"
```
---

### 14. `join()` — Combine Array Elements into String

This one’s in `String.join()` (not to be confused with Python’s `'sep'.join()`).

```java
String joined = String.join("-", "a", "b", "c");  // "a-b-c"
```

---

### 15. `isEmpty()` and `isBlank()`

* `isEmpty()` ⇒ string has 0 characters
* `isBlank()` ⇒ all whitespace (Java 11+)

```java
"".isEmpty();       // true
"  ".isBlank();     // true (Java 11+)
```

---

### 16. `compareTo()` — Lexicographic Comparison

Used in sorting or dictionary-order questions.

```java
"apple".compareTo("banana");  // < 0 (comes before)
"cat".compareTo("car");       // > 0
```

---

### 17. `matches(regex)` — Full String Pattern Match

Already touched upon — used for validating formats.

```java
"123".matches("\\d+");  // true
```

---

## ✅ Section 2: **StringBuilder Methods** (for Fast Mutation)

Faster alternative to string concatenation (`+`), especially inside loops.

```java
StringBuilder sb = new StringBuilder();
sb.append("leet");
sb.insert(0, "code");       // "codeleet"
sb.delete(0, 4);            // "leet"
sb.reverse();               // "teel"
sb.toString();              // convert back to String
```

---

## ✅ Section 3: **Useful Arrays + Collections with Strings**

---

### 1. `Arrays.sort(char[])` — Sort Characters in String

Used in anagram problems.

```java
char[] arr = "cab".toCharArray();
Arrays.sort(arr);  // ['a', 'b', 'c']
```

---

### 2. `String.valueOf(char[])` — Convert `char[]` back to String

```java
char[] arr = {'a', 'b', 'c'};
String s = String.valueOf(arr);  // "abc"
```

---

### 3. `Character.isDigit()` / `isLetter()` / `isUpperCase()`

Useful in parsing strings with mixed content.

```java
Character.isDigit('5');     // true
Character.isLetter('a');    // true
Character.isUpperCase('A'); // true
```

---

### 4. `Character.toLowerCase()` / `toUpperCase()`

For manual case transformations.

```java
Character.toLowerCase('A');  // 'a'
```

---

## ✅ Section 4: **Parsing Tricks**

---

### Convert List of Strings to Ints (Using Streams) — Java 8+

```java
List<String> strs = Arrays.asList("1", "2", "3");
List<Integer> nums = strs.stream()
    .map(Integer::parseInt)
    .collect(Collectors.toList());
```

---

### Convert List<Integer> to String

```java
List<Integer> list = Arrays.asList(1, 2, 3);
String res = list.stream()
    .map(String::valueOf)
    .collect(Collectors.joining());
```

---

### Filter Only Letters / Digits from String

```java
String s = "a1!b2@c3";
StringBuilder sb = new StringBuilder();
for (char c : s.toCharArray()) {
    if (Character.isLetterOrDigit(c)) sb.append(c);
}
String filtered = sb.toString();  // "a1b2c3"
```

---


Absolutely, Mihir! Let’s break down **basic regex knowledge** (in Java) in a simple way and show how you can **pair it with Java string functions** for real-world LeetCode use cases like validation, filtering, and parsing.

---

# 🧵 A Beginner-Friendly Guide to Regex in Java (For LeetCode)

---

## ✅ What is Regex?

**Regex (Regular Expression)** is a powerful mini-language used to **define patterns** in strings — useful for **matching**, **searching**, **splitting**, or **replacing** parts of strings.

In Java, regex is supported in:

* `String` methods like `.matches()`, `.split()`, `.replaceAll()`, `.replaceFirst()`
* The `Pattern` and `Matcher` classes (for more complex use cases)

---

## 🧰 Useful Java String Methods That Support Regex

| Method           | Purpose                                          | Supports Regex? | Example                                     |
| ---------------- | ------------------------------------------------ | --------------- | ------------------------------------------- |
| `matches()`      | Checks if the **whole string** matches a pattern | ✅               | `"123".matches("\\d+")` → `true`            |
| `replaceAll()`   | Replaces **all substrings** matching regex       | ✅               | `"a1b2".replaceAll("\\d", "")` → `"ab"`     |
| `replaceFirst()` | Replaces **first substring** matching regex      | ✅               | `"a1b2".replaceFirst("\\d", "")` → `"ab2"`  |
| `split()`        | Splits string using regex as delimiter           | ✅               | `"a,b;c".split("[,;]")` → `["a", "b", "c"]` |

---

## 🧠 Basic Regex Concepts

Here’s a **cheat sheet of common patterns** you'll actually use on LeetCode:

| Pattern | Meaning                            | Example Match               |
| ------- | ---------------------------------- | --------------------------- |
| `.`     | Any character                      | `"a"`, `"1"`, `"!"`         |
| `\d`    | Digit (0-9)                        | `"0"`, `"7"`                |
| `\D`    | Non-digit                          | `"a"`, `"@"`                |
| `\w`    | Word character (a-z, A-Z, 0-9, \_) | `"x"`, `"9"`, `"_"`         |
| `\W`    | Non-word character                 | `"!"`, `"#"`                |
| `\s`    | Whitespace                         | `" "`, `"\t"`               |
| `\S`    | Non-whitespace                     | `"a"`, `"1"`                |
| `^`     | Start of string                    | `^a` → matches "apple"      |
| `$`     | End of string                      | `e$` → matches "apple"      |
| `*`     | Zero or more times                 | `a*` → `""`, `"a"`, `"aaa"` |
| `+`     | One or more times                  | `a+` → `"a"`, `"aaa"`       |
| `?`     | Zero or one time                   | `a?` → `""`, `"a"`          |
| `[]`    | Any one of characters inside       | `[aeiou]` → `"a"`, `"e"`    |
| `[^]`   | Not one of the characters          | `[^aeiou]` → `"b"`          |
| `( )`   | Grouping                           | `(\d+)-(\d+)`               |
| `{n}`   | Exactly n times                    | `\d{3}` → `"123"`           |
| `{n,}`  | At least n times                   | `\d{2,}` → `"12"`           |
| `{n,m}` | Between n and m times              | `\d{2,4}` → `"123"`         |

> **Important:** In Java, you must **escape backslashes**:
>
> * Use `\\d` instead of `\d`,
> * Use `\\s` instead of `\s`, etc.

---

## 📌 Examples with Regex + Java String Methods

### ✅ 1. **Check if a string is a number**

```java
String s = "12345";
boolean isNumber = s.matches("\\d+");  // true
```

### ✅ 2. **Remove all digits from a string**

```java
String s = "a1b2c3";
String result = s.replaceAll("\\d", "");  // "abc"
```

### ✅ 3. **Replace first digit only**

```java
String s = "1a2b3c";
String result = s.replaceFirst("\\d", "");  // "a2b3c"
```

### ✅ 4. **Split string on multiple delimiters**

```java
String data = "a,b;c.d";
String[] parts = data.split("[,;.]");  // ["a", "b", "c", "d"]
```

### ✅ 5. **Remove non-alphanumeric characters (clean string)**

```java
String dirty = "he@llo!2024";
String clean = dirty.replaceAll("[^a-zA-Z0-9]", "");  // "hello2024"
```

---

## 🧠 When to Use Regex on LeetCode?

| Use Case                     | Useful Regex Pattern           | Method         |
| ---------------------------- | ------------------------------ | -------------- |
| Validate digit-only string   | `"\\d+"`                       | `matches()`    |
| Remove punctuation           | `"[^a-zA-Z0-9]"`               | `replaceAll()` |
| Tokenize based on delimiters | `"[,;\\s]+"`                   | `split()`      |
| Check email/password format  | Complex regex                  | `matches()`    |
| Keep only letters/digits     | `"[^\\w]"` or `"[^a-zA-Z0-9]"` | `replaceAll()` |

---


Absolutely, Mihir! Just like the strings guide, here's a **comprehensive beginner-to-advanced LeetCode guide for HashMaps in Java** — covering **syntax**, **patterns**, and **all useful functions** you'll need to crush problems like 2Sum, anagrams, frequency counters, sliding windows, etc.

---

# 🗂️ **Ultimate LeetCode HashMap Guide in Java**

---

## 🔑 What Is a HashMap?

A `HashMap<K, V>` in Java stores **key-value pairs** and offers:

* **O(1)** average time complexity for get/put operations
* Very helpful in problems involving:

  * **Counting**
  * **Lookup**
  * **Mapping**
  * **Grouping**
  * **Prefix/Suffix tracking**
  * **Sliding window optimization**

---

## ✅ How to Declare & Initialize

```java
Map<String, Integer> map = new HashMap<>();
Map<Character, Integer> freq = new HashMap<>();
Map<Integer, List<String>> groups = new HashMap<>();
```

> Tip: Use `Map` interface type for flexibility (`Map` ← `HashMap`, `TreeMap`, `LinkedHashMap`, etc.)

---

## 🧰 Most Useful HashMap Methods for LeetCode

| Method | Description | Example |
| ------ | ----------- | ------- |

### 1. `put(key, value)`

Adds or updates the mapping.

```java
map.put("apple", 3);
```

---

### 2. `get(key)`

Returns value for a key (or `null` if not found).

```java
int count = map.get("apple");  // 3
```

---

### 3. `getOrDefault(key, defaultValue)`

Safely get a value, fallback if key not found.

```java
int count = map.getOrDefault("banana", 0);  // 0
```

---

### 4. `containsKey(key)`

Checks if the key exists in the map.

```java
if (map.containsKey("apple")) { ... }
```

---

### 5. `containsValue(value)`

Checks if any key maps to this value (rarely used in LeetCode).

```java
map.containsValue(3);  // true
```

---

### 6. `remove(key)`

Removes the key and its mapping.

```java
map.remove("apple");
```

---

### 7. `keySet()`

Returns a set of all keys.

```java
for (String key : map.keySet()) {
    System.out.println(key + " → " + map.get(key));
}
```

---

### 8. `values()`

Returns a collection of all values.

```java
for (int value : map.values()) {
    System.out.println(value);
}
```

---

### 9. `entrySet()`

Returns key-value pairs (best for iterating both).

```java
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " → " + entry.getValue());
}
```

---

### 10. `size()` / `isEmpty()`

```java
map.size();      // Number of entries
map.isEmpty();   // true if map has no entries
```

---

### 11. `compute(key, (k,v) -> newVal)`

Updates value with a lambda.

```java
map.compute("a", (k, v) -> v == null ? 1 : v + 1);
```

---

### 12. `merge(key, value, BiFunction)`

Combines existing and new values (great for counting).

```java
map.merge('a', 1, Integer::sum);  // count[a] += 1
```

---

## 💡 Common Patterns with HashMaps

---

### 🔢 1. **Frequency Counter (Char or Int Count)**

```java
Map<Character, Integer> freq = new HashMap<>();
for (char c : s.toCharArray()) {
    freq.put(c, freq.getOrDefault(c, 0) + 1);
}
```

> **Used in:** Valid Anagram, Top K Elements, Character Replacement

---

### 🔁 2. **Two Sum (Value → Index Mapping)**

```java
Map<Integer, Integer> map = new HashMap<>();
for (int i = 0; i < nums.length; i++) {
    int complement = target - nums[i];
    if (map.containsKey(complement)) {
        return new int[]{map.get(complement), i};
    }
    map.put(nums[i], i);
}
```

---

### 🪟 3. **Sliding Window with Char Frequency**

```java
Map<Character, Integer> window = new HashMap<>();
int left = 0;

for (int right = 0; right < s.length(); right++) {
    char c = s.charAt(right);
    window.put(c, window.getOrDefault(c, 0) + 1);

    while (window.size() > K) {
        char leftChar = s.charAt(left++);
        window.put(leftChar, window.get(leftChar) - 1);
        if (window.get(leftChar) == 0) window.remove(leftChar);
    }
}
```

> **Used in:** Longest Substring with K Distinct, Minimum Window Substring

---

### 🧩 4. **Group Anagrams**

```java
Map<String, List<String>> map = new HashMap<>();

for (String word : words) {
    char[] chars = word.toCharArray();
    Arrays.sort(chars);
    String key = new String(chars);  // sorted signature

    map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
}
```

---

### 🧮 5. **Prefix Sum Count Using Map**

```java
Map<Integer, Integer> prefixCount = new HashMap<>();
prefixCount.put(0, 1);
int sum = 0, res = 0;

for (int num : nums) {
    sum += num;
    res += prefixCount.getOrDefault(sum - target, 0);
    prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
}
```

> **Used in:** Subarray Sum Equals K

---

## 🔍 When to Use HashMap

| Problem Type                       | Use HashMap For                |
| ---------------------------------- | ------------------------------ |
| Count frequency                    | Char/Word counts               |
| Lookup with O(1)                   | Index/value tracking           |
| Group by property (e.g., anagrams) | Store grouped data under a key |
| Sliding window optimizations       | Track frequency inside window  |
| Prefix sum or difference patterns  | Track sums seen so far         |

---

## 🔧 HashMap vs Other Maps

| Map Type        | Maintains Order?  | Sorted? | Use When                    |
| --------------- | ----------------- | ------- | --------------------------- |
| `HashMap`       | ❌                 | ❌       | Fastest, default map        |
| `LinkedHashMap` | ✅                 | ❌       | Keep insertion order        |
| `TreeMap`       | ✅ (Sorted by key) | ✅       | Need sorted keys (logN ops) |

---

## 📌 Real LeetCode Problems Using HashMap

| Problem | Concept |
| ------- | ------- |

* [✅ Two Sum](https://leetcode.com/problems/two-sum/) – Value → Index
* [✅ Group Anagrams](https://leetcode.com/problems/group-anagrams/) – Sorted string → group
* [✅ Valid Anagram](https://leetcode.com/problems/valid-anagram/) – Frequency comparison
* [✅ Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/) – Prefix sum counter
* [✅ Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) – Sliding window + Set/Map
* [✅ Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/) – Count then bucket

---

## 🧪 Quiz You Can Try

**Given a string `s`, return the first non-repeating character.**

```java
public char firstUniqChar(String s) {
    Map<Character, Integer> freq = new HashMap<>();
    for (char c : s.toCharArray())
        freq.put(c, freq.getOrDefault(c, 0) + 1);

    for (char c : s.toCharArray())
        if (freq.get(c) == 1) return c;

    return '_';
}
```

---

## 🧵 Summary Cheat Sheet

| Task              | Method                          |
| ----------------- | ------------------------------- |
| Add/Update        | `put(key, val)`                 |
| Lookup            | `get(key)`                      |
| Safe lookup       | `getOrDefault(key, default)`    |
| Increment count   | `put(k, getOrDefault(k,0)+1)`   |
| Frequency counter | `merge(k,1,Integer::sum)`       |
| Group elements    | `computeIfAbsent(...).add()`    |
| Iterate keys      | `for (K key : map.keySet())`    |
| Iterate key-value | `for (Map.Entry<K,V> entry...)` |

---

Would you like a **daily roadmap** like “Day 1: Frequency Problems”, “Day 2: Grouping with Maps”, “Day 3: Sliding Windows with HashMaps” to drill this into practice?

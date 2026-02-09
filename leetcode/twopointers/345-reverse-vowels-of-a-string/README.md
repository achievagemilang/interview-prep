# Reverse Vowels of a String

## Problem Description

Given a string `s`, reverse only the vowels of the string and return it.

Vowels are `'a'`, `'e'`, `'i'`, `'o'`, `'u'` (both lowercase and uppercase).

## Examples

**Example 1:**

```
Input: s = "hello"
Output: "holle"
```

**Example 2:**

```
Input: s = "leetcode"
Output: "leotcede"
```

## Solution Approach

Use two pointers from both ends, swapping vowels.

1. Convert string to char array for in-place modification.
2. `l` starts at 0, `r` starts at end.
3. Skip non-vowels from both sides.
4. Swap vowels and move both pointers inward.

## Complexity Analysis

- **Time Complexity:** $O(N)$ — single pass.
- **Space Complexity:** $O(N)$ — char array for modification.

## Code Structure

```java
class Solution {
    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] ans = s.toCharArray();

        while (l < r) {
            while (l < r && !isVowel(ans[l])) l++;
            while (l < r && !isVowel(ans[r])) r--;

            char tmp = ans[l];
            ans[l] = ans[r];
            ans[r] = tmp;

            l++;
            r--;
        }

        return new StringBuilder().append(ans).toString();
    }

    public boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o';
    }
}
```

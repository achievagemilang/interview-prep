# Valid Palindrome

## Problem Description

Given a string `s`, return `true` if it is a palindrome, considering only alphanumeric characters and ignoring cases.

## Examples

**Example 1:**

```
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
```

**Example 2:**

```
Input: s = "race a car"
Output: false
```

## Solution Approach

Use two pointers from both ends, skipping non-alphanumeric characters.

1. Initialize `l = 0` and `r = n - 1`.
2. Skip non-alphanumeric characters from both ends.
3. Compare characters (case-insensitive).
4. If mismatch, return false. Otherwise, continue inward.

## Complexity Analysis

- **Time Complexity:** $O(N)$ — single pass.
- **Space Complexity:** $O(1)$.

## Code Structure

```java
class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r){
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if(Character.toUpperCase(s.charAt(l)) == Character.toUpperCase(s.charAt(r))){
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
```

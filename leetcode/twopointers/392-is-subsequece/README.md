# Is Subsequence

## Problem Description

Given two strings `s` and `t`, return `true` if `s` is a subsequence of `t`.

A subsequence is derived by deleting some (or no) characters without changing the relative order of remaining characters.

## Examples

**Example 1:**

```
Input: s = "abc", t = "ahbgdc"
Output: true
```

**Example 2:**

```
Input: s = "axc", t = "ahbgdc"
Output: false
```

## Solution Approach

Use two pointers scanning both strings.

1. `l` pointer for string `s`, `r` pointer for string `t`.
2. If characters match, advance both pointers.
3. If not, advance only `r` (skip character in `t`).
4. Return true if all characters of `s` were matched (`l == s.length()`).

## Complexity Analysis

- **Time Complexity:** $O(N)$ where $N$ is length of `t`.
- **Space Complexity:** $O(1)$.

## Code Structure

```java
class Solution {
    public boolean isSubsequence(String s, String t) {
        int l = 0;
        int r = 0;
        while(r < t.length() && l < s.length()){
            char sc = s.charAt(l);
            char tc = t.charAt(r);

            if(sc == tc){
                l++;
                r++;
            } else {
                r++;
            }
        }

        return l == s.length();
    }
}
```

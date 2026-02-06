# Longest Substring Without Repeating Characters

## Problem Description

Given a string `s`, find the length of the **longest substring** without repeating characters.

## Examples

**Example 1:**

```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```

**Example 2:**

```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

**Example 3:**

```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
```

## Solution Approach

Use a sliding window with a HashSet to track characters in the current window.

1. Expand the window by moving the right pointer.
2. If the character at `r` is already in the set, shrink the window from the left until the duplicate is removed.
3. Add the character at `r` to the set and update the maximum length.

## Complexity Analysis

- **Time Complexity:** $O(N)$ where $N$ is the length of the string. Each character is visited at most twice.
- **Space Complexity:** $O(\min(N, M))$ where $M$ is the size of the character set.

## Code Structure

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int l = 0;
        Set<Character> inWindow = new HashSet<>();
        int maxVal = -1;
        for(int r=0; r<s.length(); r++){
            while (inWindow.contains(s.charAt(r))) {
                inWindow.remove(s.charAt(l));
                l++;
            }
            inWindow.add(s.charAt(r));
            maxVal = Math.max(maxVal, r - l + 1);
        }

        return maxVal;
    }
}
```

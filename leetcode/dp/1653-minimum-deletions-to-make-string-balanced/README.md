# Minimum Deletions to Make String Balanced

## Problem Description

Given a string `s` consisting only of characters `'a'` and `'b'`, return the **minimum number of deletions** needed to make `s` balanced.

A string is **balanced** if there is no pair of indices `(i, j)` where `i < j` and `s[i] = 'b'` and `s[j] = 'a'`. In other words, all `'a'`s must come before all `'b'`s.

## Examples

**Example 1:**

```
Input: s = "aababbab"
Output: 2
Explanation: Delete the 'b' at index 2 and 'b' at index 6 to get "aaaabb".
```

**Example 2:**

```
Input: s = "bbaaaaabb"
Output: 2
Explanation: Delete the first two 'b's to get "aaaaabb".
```

## Solution Approach

Use a single-pass DP approach by tracking the count of `'b'`s seen so far.

When encountering an `'a'`:

- **Option 1:** Keep this `'a'` → must delete all previous `'b'`s → cost = `bCount`
- **Option 2:** Delete this `'a'` → cost = `minDeletions + 1`

Take the minimum of both options.

When encountering a `'b'`:

- Simply increment `bCount`.

## Complexity Analysis

- **Time Complexity:** $O(N)$ — single pass through the string.
- **Space Complexity:** $O(1)$ — only tracking two integers.

## Code Structure

```java
class Solution {
    public int minimumDeletions(String s) {
        int bCount = 0;
        int minDeletions = 0;

        for(char c : s.toCharArray()){
            if(c == 'b'){
                bCount++;
            } else {
                minDeletions = Math.min(minDeletions + 1, bCount);
            }
        }

        return minDeletions;
    }
}
```

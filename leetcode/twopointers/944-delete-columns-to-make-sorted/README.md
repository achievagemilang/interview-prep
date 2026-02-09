# Delete Columns to Make Sorted

## Problem Description

Given an array of `n` strings `strs`, all of the same length, determine the minimum number of columns to delete so that each column is sorted in non-decreasing lexicographic order.

## Examples

**Example 1:**

```
Input: strs = ["cba","daf","ghi"]
Output: 1
Explanation: Column 1 (b > a) is not sorted.
```

**Example 2:**

```
Input: strs = ["a","b"]
Output: 0
```

## Solution Approach

Check each column for sorted order using two pointers.

1. Iterate through each column index `i`.
2. For each column, compare adjacent rows.
3. If any `prev > curr`, increment delete count and move to next column.

## Complexity Analysis

- **Time Complexity:** $O(N \cdot M)$ where $N$ = number of strings, $M$ = string length.
- **Space Complexity:** $O(1)$.

## Code Structure

```java
class Solution {
    public int minDeletionSize(String[] strs) {
        if(strs.length <= 1) return 0;
        if(strs[0].length() == 0) return 0;

        int ans = 0;
        for(int i = 0; i < strs[0].length(); i++){
            char prev = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                char now = strs[j].charAt(i);
                if(prev > now){
                    ans++;
                    break;
                }
                prev = now;
            }
        }
        return ans;
    }
}
```

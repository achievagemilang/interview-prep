# Move Zeroes

## Problem Description

Given an array `nums`, move all `0`'s to the end while maintaining the relative order of non-zero elements. Do this **in-place**.

## Examples

**Example 1:**

```
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
```

**Example 2:**

```
Input: nums = [0]
Output: [0]
```

## Solution Approach

Use slow/fast pointer technique to swap non-zero elements to the front.

1. `slow` pointer tracks position for next non-zero.
2. `fast` pointer scans through array.
3. When `fast` finds non-zero, swap with `slow` position and increment `slow`.

## Complexity Analysis

- **Time Complexity:** $O(N)$ — single pass.
- **Space Complexity:** $O(1)$ — in-place.

## Code Structure

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++){
            if (nums[fast] != 0) {
                int slowNum = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = slowNum;
                slow++;
            }
        }
    }
}
```

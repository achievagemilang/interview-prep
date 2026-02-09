# Container With Most Water

## Problem Description

Given an array `height` of `n` lines where `height[i]` is the height of the `i`th line, find two lines that together with the x-axis form a container that holds the most water.

## Examples

**Example 1:**

```
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: Lines at index 1 (height 8) and index 8 (height 7) form the container.
Area = min(8, 7) * (8 - 1) = 7 * 7 = 49
```

## Solution Approach

Use two pointers starting from both ends and move inward.

1. Start with `l = 0` and `r = n - 1` (maximum width).
2. Calculate area = `min(height[l], height[r]) * (r - l)`.
3. Move the pointer with the smaller height inward (greedy choice).
4. Track maximum area found.

**Why move the smaller height?** Moving the larger one can only decrease the area since width decreases and new height ≤ current min height.

## Complexity Analysis

- **Time Complexity:** $O(N)$ — single pass with two pointers.
- **Space Complexity:** $O(1)$.

## Code Structure

```java
class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ans = -1;
        while(l < r){
            int left = height[l];
            int right = height[r];
            int area = Math.min(left, right) * (r - l);
            ans = Math.max(area, ans);

            if(height[l] <= height[r]){
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
```

# Trionic Array I

## Problem Description

Given an integer array `nums`, return `true` if the array is a "Trionic Array", otherwise return `false`.

A **Trionic Array** is an array that follows a specific pattern of three phases:

1.  **Strictly Increasing:** The array starts with a sequence of numbers that are strictly increasing.
2.  **Strictly Decreasing:** Following the first phase, there is a sequence of numbers that are strictly decreasing.
3.  **Strictly Increasing:** Finally, the array ends with a sequence of numbers that are strictly increasing.

To be a valid Trionic Array, there must be at least 4 elements, and all three phases must be non-empty (i.e., you must actually go up, then down, then up).

## Examples

**Example 1:**

```
Input: nums = [1, 2, 3, 2, 1, 4, 5]
Output: true
Explanation:
- Phase 1 (Increasing): [1, 2, 3]
- Phase 2 (Decreasing): [3, 2, 1]
- Phase 3 (Increasing): [1, 4, 5]
All phases are present and valid.
```

**Example 2:**

```
Input: nums = [1, 2, 3, 4, 5]
Output: false
Explanation: Only one increasing phase.
```

**Example 3:**

```
Input: nums = [5, 4, 3, 2, 1]
Output: false
Explanation: Only decreasing.
```

## Solution Approach: Three-Phase Linear Scan

We can determine if an array is Trionic by simulating the three phases using a linear scan.

1.  **Phase 1 (Up):** Start from the beginning and move forward as long as `nums[i] < nums[i+1]`. If we don't move at all, it's invalid (must start increasing).
2.  **Phase 2 (Down):** From the point where Phase 1 ended, continue moving forward as long as `nums[i] > nums[i+1]`. If we don't move at all, it's invalid (must have a decreasing part).
3.  **Phase 3 (Up):** From the point where Phase 2 ended, continue moving forward as long as `nums[i] < nums[i+1]`. If we don't move at all, it's invalid.

Finally, check if we have reached the end of the array. If we successfully completed all three phases and reached the last element, it is a Trionic Array.

### Complexity Analysis

- **Time Complexity:** $O(N)$, where $N$ is the length of `nums`. We traverse the array exactly once.
- **Space Complexity:** $O(1)$, as we only use a few variables for indices.

## Code Structure

```java
class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return false;

        int i = 0;
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == 0) return false;

        int endOfPhase1 = i;
        while (i + 1 < n && nums[i] > nums[i + 1]) {
            i++;
        }
        if (i == endOfPhase1) return false;

        int endOfPhase2 = i;
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == endOfPhase2) return false;

        return i == n - 1;
    }
}
```

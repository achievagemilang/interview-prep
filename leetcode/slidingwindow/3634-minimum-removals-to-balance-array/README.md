# Minimum Removals to Balance Array

## Problem Description

Given an integer array `nums` and an integer `k`, you need to remove the minimum number of elements from the array such that the remaining array is "balanced."

An array is **balanced** if the ratio of the maximum element to the minimum element is at most `k`. Formally, `max(nums) <= k * min(nums)`.

## Examples

**Example 1:**

```
Input: nums = [1, 4, 2, 3], k = 3
Output: 0
Explanation: max(nums) = 4, min(nums) = 1. 4 <= 3 * 1 is false.
After sorting: [1, 2, 3, 4]. The subarray [1, 2, 3] satisfies 3 <= 3 * 1.
Actually, we need to check: After removing 4, we have [1, 2, 3] where max=3, min=1, and 3 <= 3*1 = true.
```

## Solution Approach

The key insight is that after sorting, we can use a sliding window to find the maximum number of elements we can keep.

1. **Sort the array**: This ensures that for any window `[l, r]`, `nums[l]` is the minimum and `nums[r]` is the maximum.
2. **Sliding window**: Expand the right pointer and shrink the left pointer when the condition `nums[r] > k * nums[l]` is violated.
3. **Track maximum kept**: The answer is `n - maxKept`.

### Why sorting works

After sorting, if we select a contiguous subarray, the minimum is at the left and maximum is at the right. We only need to check if `nums[r] <= k * nums[l]`.

## Complexity Analysis

- **Time Complexity:** $O(N \log N)$ due to sorting, plus $O(N)$ for the sliding window.
- **Space Complexity:** Depends on the sorting algorithm, typically $O(\log N)$ to $O(N)$.

## Code Structure

```java
class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);

        int maxKept = 0;
        int l = 0;

        for(int r = 0; r < nums.length; r++){
            while((long)nums[r] > (long) k * nums[l]){
                l++;
            }
            maxKept = Math.max(maxKept, r - l + 1);
        }

        return nums.length - maxKept;
    }
}
```

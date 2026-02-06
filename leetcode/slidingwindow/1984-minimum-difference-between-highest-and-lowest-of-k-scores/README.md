# Minimum Difference Between Highest and Lowest of K Scores

## Problem Description

Given an array of integers `nums` and an integer `k`, you need to pick `k` scores from the array. Return the **minimum** possible difference between the highest and lowest of the `k` selected scores.

## Examples

**Example 1:**

```
Input: nums = [90], k = 1
Output: 0
Explanation: Only one score, so difference is 0.
```

**Example 2:**

```
Input: nums = [9, 4, 1, 7], k = 2
Output: 2
Explanation: Pick scores 7 and 9. Difference = 9 - 7 = 2.
```

## Solution Approach

To minimize the difference between max and min of `k` elements, the optimal strategy is to pick `k` consecutive elements from a sorted array.

1. **Sort the array**: Consecutive elements in a sorted array have the smallest range.
2. **Sliding window of size k**: Iterate through all windows of size `k` and compute `nums[i+k-1] - nums[i]`.
3. **Track minimum difference**.

## Complexity Analysis

- **Time Complexity:** $O(N \log N)$ for sorting, plus $O(N)$ for the sliding window.
- **Space Complexity:** Depends on sorting, typically $O(\log N)$.

## Code Structure

```java
class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k <= 1) return 0;

        Arrays.sort(nums);

        int highestDiff = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length - k + 1; i++){
            int h = nums[i+k-1];
            int l = nums[i];

            int diff = h - l;
            highestDiff = Math.min(diff, highestDiff);
        }

        return highestDiff;
    }
}
```

# Transformed Array

## Problem Description

Given an integer array `nums` representing a circular array, construct a new array `result` of the same size `n`, where `result[i]` is equal to `nums[(i + nums[i]) % n]`.

- If `nums[i] > 0`, move `nums[i]` steps to the right.
- If `nums[i] < 0`, move `|nums[i]|` steps to the left.
- If `nums[i] == 0`, stay at index `i`.

The indices strictly wrap around the array.

## Examples

**Example 1:**

```
Input: nums = [3, -2, 1, 1]
Output: [1, 1, 1, 3]
Explanation:
- i=0: Move 3 steps right from index 0 -> index 3. result[0] = nums[3] = 1.
- i=1: Move 2 steps left from index 1 -> index 3. result[1] = nums[3] = 1.
- i=2: Move 1 step right from index 2 -> index 3. result[2] = nums[3] = 1.
- i=3: Move 1 step right from index 3 -> index 0. result[3] = nums[0] = 3.
```

**Example 2:**

```
Input: nums = [-1, 4, -1]
Output: [-1, -1, 4]
Explanation:
- i=0: Move 1 step left -> index 2. result[0] = nums[2] = -1.
- i=1: Move 4 steps right -> index 2. result[1] = nums[2] = -1.
- i=2: Move 1 step left -> index 1. result[2] = nums[1] = 4.
```

## Solution Approach

This problem is a direct simulation. We iterate through each element of the input array and calculate the target index.

The core logic is handling the circular index calculation:
`target_index = (i + nums[i]) % n`

However, in many languages (including Java), the modulo operator `%` can return a negative value if the dividend is negative. To ensure a valid positive index `[0, n-1]`:

1.  Calculate `pos = (i + nums[i]) % n`.
2.  If `pos` is negative, add `n` to it: `pos += n`.

This correctly handles both positive (right) and negative (left) moves with wrapping.

## Complexity Analysis

- **Time Complexity:** $O(N)$, where $N$ is the length of the array. We iterate through the array once.
- **Space Complexity:** $O(1)$ auxiliary space (excluding the result array).

## Code Structure

```java
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] res = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            int steps = nums[i];
            int pos = i + steps;

            pos = pos % nums.length;

            if(pos < 0){
                pos += nums.length;
            }

            res[i] = nums[pos];
        }

        return res;
    }
}
```

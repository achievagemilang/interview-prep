# Power of Three

## Problem Description

Given an integer `n`, return `true` _if it is a power of three. Otherwise, return_ `false`.

An integer `n` is a power of three, if there exists an integer `x` such that $n == 3^x$.

**Example 1:**

```
Input: n = 27
Output: true
Explanation: 27 = 3^3
```

**Example 2:**

```
Input: n = 0
Output: false
```

**Example 3:**

```
Input: n = -1
Output: false
```

## Solution Approach: Iteration

A number is a power of three if it is feasible to divide it by 3 continuously until it becomes 1. If we encounter a number that is not divisible by 3 before reaching 1, or if we start with a number less than or equal to 0, it is not a power of three.

### Algorithm

1.  **Base Case:** If `n <= 0`, return `false`.
2.  **Iteration:** While `n` is divisible by 3 (i.e., `n % 3 == 0`), divide `n` by 3.
3.  **Final Check:** After the loop, check if `n` is equal to 1. If it is, return `true`; otherwise, return `false`.

### Complexity Analysis

- **Time Complexity:** $O(\log_3 n)$. In each iteration, we divide `n` by 3, so the number of iterations is logarithmic with respect to `n`.
- **Space Complexity:** $O(1)$. We use a constant amount of extra space.

## Code Structure

```java
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }
}
```

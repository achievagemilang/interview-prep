# Weekly Contest 482

## Q1. Maximum Score of a Split

### Problem Description

Find a split point in an array `nums` to maximize `prefixSum[i] - suffixMin[i+1]`.

### Solution Approach

- **Precompute Suffix Min**: Iterate backwards to store the minimum element from `i` to `n-1`.
- **Iterate Prefix**: Maintain a running `prefixSum`.
- **Calculate Score**: For each split point `i`, calculate `prefixSum - suffixMin[i+1]` and track the maximum.

### Code Structure

```java
class Solution {
    public long maximumScore(int[] nums) {
        // ... suffixMin calculation ...
        // ... prefix iteration and maxScore calculation ...
        return maxScore;
    }
}
```

---

## Q2. Minimum Cost to Acquire Required Items

### Problem Description

Calculate the minimum cost to acquire `n1` of item 1 and `n2` of item 2 given individual costs and a bundled cost.

### Solution Approach

Compare three strategies:

1. Buy everything individually: `n1 * c1 + n2 * c2`.
2. Buy as many bundles as possible for the minimum required count, then buy the rest individually.
3. Buy bundles for the maximum required count (discarding extras).
   Return the minimum of these three options.

### Code Structure

```java
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        // ... compare 3 options ...
        return Math.min(option1, Math.min(option2, option3));
    }
}
```

---

## Q3. Smallest All-Ones Multiple

### Problem Description

Find the smallest length `L` such that a number consisting of `L` ones (e.g., 1, 11, 111...) is a multiple of `k`.

### Solution Approach

- If `k` is even or divisible by 5, no such number exists (return -1).
- Simulate the number generation using modulo arithmetic: `remainder = (remainder * 10 + 1) % k`.
- If `remainder == 0`, return current length.

### Code Structure

```java
class Solution {
    public int minAllOneMultiple(int k) {
        // ... modulo arithmetic loop ...
        return -1;
    }
}
```

---

## Q4. Number of Balanced Integers in a Range

### Problem Description

Count numbers in range `[low, high]` that are "balanced" (specific definition depends on problem, likely sum of digits at even/odd indices or something similar from the complicated DP state).

### Solution Approach

- **Digit DP**: Use Digit DP to count valid numbers up to `N`. Result is `solve(high) - solve(low - 1)`.
- **State**: `d(idx, tight, sum, isStart, isOddPos)`.
- **Memoization**: Cache results to avoid re-computation.

### Code Structure

```java
class Solution {
    public long countBalanced(long low, long high) {
        return solveFor(high) - solveFor(low - 1);
    }
    // ... dp state and transition ...
}
```

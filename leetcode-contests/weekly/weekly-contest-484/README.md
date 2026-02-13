# Weekly Contest 484

## Q1. Count Residue Prefixes

### Problem Description

Count prefixes of string `s` that satisfy a specific residue condition (related to length/index modulo 3 and set size).

### Solution Approach

- Iterate through string, maintaining a set of unique characters.
- Check condition: `set.size() == (i + 1) % 3`.
- Increment count if condition met.

### Code Structure

```java
class Solution {
    public int residuePrefixes(String s) {
        // ... iterate and update set ...
        if(set.size() == (i + 1) % 3) ans++;
        // ...
        return ans;
    }
}
```

---

## Q2. Number of Centered Subarrays

### Problem Description

Count subarrays where the sum equals some element in the subarray (or satisfies a similar condition involving `seen` set and `sum`).

### Solution Approach

- Iterate through all subarrays `(i, j)`.
- Calculate sum and maintain `seen` set of elements.
- Check if `sum` exists in `seen`.

### Code Structure

```java
class Solution {
    public int centeredSubarrays(int[] nums) {
        // ... nested loops for subarrays ...
        // ... check if sum in seen ...
        return ans;
    }
}
```

---

## Q3. Count Caesar Cipher Pairs

### Problem Description

Count pairs of strings that are Caesar cipher equivalents of each other (one can be shifted to match the other).

### Solution Approach

- **Normalization**: shift every string so that its first character becomes 'a'.
- If two strings are Caesar cipher equivalents, their normalized forms will be identical.
- Use a HashMap to count frequencies of normalized strings.
- For each string, add current count of its normalized form to answer.

### Code Structure

```java
class Solution {
    private String cipher(String s) {
        // ... normalize string ...
    }
    public long countPairs(String[] words) {
        // ... map normalized strings ...
        return ans;
    }
}
```

---

## Q4. Maximum Bitwise AND After Increment Operations

### Problem Description

Find maximum possible bitwise AND of a subset (or modified array) given `k` operations/budget `m`.

### Solution Approach

- **Greedy Bit-by-Bit**: Iterate from most significant bit (31) down to 0.
- Check if we can set the current bit (results in `proposal = ans | (1 << bit)`).
- **Check Function**: `canAchieve(proposal)`:
  - Calculate cost for each number to satisfy the `target` mask.
  - Sort costs and pick cheapest `m` updates.
  - If total cost $\le k$, then this bit can be set.

### Code Structure

```java
class Solution {
    public int maximumAND(int[] nums, int k, int m) {
        // ... iterate bits ...
        // ... check constraints ...
        return ans;
    }
}
```

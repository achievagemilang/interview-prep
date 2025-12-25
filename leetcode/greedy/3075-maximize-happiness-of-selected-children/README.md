# Maximize Happiness of Selected Children (LeetCode 3075)

## 🧩 Problem Overview

We are given a queue of children, each with an associated **happiness value**.  
Our task is to select **k children** to maximize the **total happiness sum**.

### Constraints

- Each time a child is picked, the happiness of **all remaining unpicked children decreases by 1**.
- Happiness values **cannot go below 0**.

---

## ❌ Brute Force Approach (TLE)

The naive solution tried to **simulate the process literally**:

1. Find the maximum happiness value.
2. Add it to the sum.
3. Decrease the happiness of all remaining children by 1.
4. Repeat this process **k times**.

### ⏱ Performance Bottleneck

- Sorting: `O(N log N)`
- Decrementing loop: `O(N)` repeated `k` times

**Total Time Complexity:**  
\[
O(N \log N + N \times k)
\]

With:

- `N = 200,000`
- `k = 200,000`

This leads to approximately **4 × 10¹⁰ operations**, causing **Time Limit Exceeded (TLE)**.

---

## ✅ Optimized Strategy (Greedy)

Instead of physically updating the array, we **calculate the effective happiness mathematically**.

### 🔑 Key Insight

- Always pick children with the **largest original happiness first** (Greedy).
- If a child is picked at turn `i` (0-indexed), their happiness has decreased by exactly `i`.

### 📐 Effective Happiness Formula

- `effectiveValue = originalValue - i`
- If `effectiveValue < 0`, treat it as `0`.

---

## 🧠 Algorithm

1. Sort the happiness array in **ascending order**.
2. Iterate from the **largest values backwards**, up to `k` times.
3. For each picked child at turn `i`:
   - Compute `originalValue - i`
   - Add it to the total sum if it’s positive.
4. Stop early if values become `0` or negative.

---

## 📊 Complexity Analysis

- **Time Complexity:** `O(N log N)`  
  (Sorting dominates; the loop is only `O(k)`)

- **Space Complexity:**
  - `O(log N)` to `O(N)` depending on sorting implementation
  - Java’s `Arrays.sort` (primitive `int[]`) uses **Dual-Pivot Quicksort**

---

## 💻 Java Implementation

```java
import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        long sum = 0;
        int n = happiness.length;

        for (int i = 0; i < k; i++) {
            int originalValue = happiness[n - 1 - i];
            int effectiveValue = originalValue - i;

            if (effectiveValue > 0) {
                sum += effectiveValue;
            } else {
                break;
            }
        }

        return sum;
    }
}
```

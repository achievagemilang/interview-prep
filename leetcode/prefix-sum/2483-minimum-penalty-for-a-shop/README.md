# Minimum Penalty for a Shop

## Problem Description

You are given the customer visit log of a shop represented by a 0-indexed string `customers` consisting only of characters 'N' and 'Y':

- 'Y' indicates that customers come at that hour.
- 'N' indicates that no customers come at that hour.

If the shop closes at the $j^{th}$ hour ($0 \le j \le n$), the penalty is calculated as follows:

- For every hour when the shop is **open** and **no customers come**, the penalty increases by 1.
- For every hour when the shop is **closed** and **customers come**, the penalty increases by 1.

Return the **earliest** hour at which the shop must be closed to incur a **minimum** penalty.

## Solution Approach: Prefix Sum (Passes)

The problem asks us to minimize the penalty, which comes from two sources:

1.  **Open but no customers:** 'N' appearing before the closing hour.
2.  **Closed but customers exist:** 'Y' appearing at or after the closing hour.

Instead of recalculating these counts for every possible closing time (which would be $O(N^2)$), we can use prefix sums and postfix sums to do this in $O(N)$.

### Algorithm

1.  **Prefix Sum of 'N':** Calculate `pref[i]`, which stores the number of 'N's from index `0` to `i-1`.
2.  **Postfix Sum of 'Y':** Calculate `post[i]`, which stores the number of 'Y's from index `i` to `n-1`.
3.  **Iterate and Minimize:** For every possible closing hour `i` from `0` to `n`:
    - The penalty is `pref[i]` (cost of keeping open when empty) + `post[i]` (cost of closing when customers arrive).
    - Track the minimum penalty found so far and the earliest index associated with it.

### Complexity Analysis

- **Time Complexity:** $O(N)$
  - Two passes to build prefix/postfix arrays and one pass to find the minimum. Total $3N$ operations.
- **Space Complexity:** $O(N)$
  - We use two arrays of size $N+1$ to store the prefix and postfix counts.

## Code Structure

```java
class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] pref = new int[n + 1];
        int[] post = new int[n + 1];

        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (customers.charAt(i) == 'N' ? 1 : 0);
        }

        for (int i = n - 1; i >= 0; i--) {
            post[i] = post[i + 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }

        int minPenalty = Integer.MAX_VALUE;
        int minPenaltyIndex = 0;

        for (int i = 0; i <= n; i++) {
            int penalty = pref[i] + post[i];
            if (penalty < minPenalty) {
                minPenalty = penalty;
                minPenaltyIndex = i;
            }
        }

        return minPenaltyIndex;
    }
}
```

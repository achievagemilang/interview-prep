# Best Time to Buy and Sell Stock

## Problem Description

Given an array `prices` where `prices[i]` is the price of a stock on the `i`th day, find the **maximum profit** you can achieve from a single buy and sell transaction.

You must buy before you sell. If no profit is possible, return 0.

## Examples

**Example 1:**

```
Input: prices = [7, 1, 5, 3, 6, 4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6). Profit = 6 - 1 = 5.
```

**Example 2:**

```
Input: prices = [7, 6, 4, 3, 1]
Output: 0
Explanation: No transactions lead to profit.
```

## Solution Approach

Use a sliding window / two-pointer approach to track the minimum buy price seen so far.

1. Track the left pointer as the potential buy day (minimum price so far).
2. For each day `r`, calculate profit as `prices[r] - prices[l]`.
3. If `prices[r] < prices[l]`, update the buy day to `r`.
4. Track the maximum profit.

## Complexity Analysis

- **Time Complexity:** $O(N)$ where $N$ is the number of days.
- **Space Complexity:** $O(1)$.

## Code Structure

```java
class Solution {
    public int maxProfit(int[] prices) {
        int l, r, ans;
        ans = 0;
        l = 0;

        for(r=1; r < prices.length; r++){
            int prev = prices[l];
            int next = prices[r];

            if(next < prev){
                l = r;
                continue;
            }

            int profit = next - prev;
            ans = Math.max(profit, ans);
        }

        return ans;
    }
}
```

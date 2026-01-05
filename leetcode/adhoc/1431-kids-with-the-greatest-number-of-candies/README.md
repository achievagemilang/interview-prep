# Kids With the Greatest Number of Candies

## Problem Description

There are `n` kids with candies. You are given an integer array `candies`, where each `candies[i]` represents the number of candies the $i^{th}$ kid has, and an integer `extraCandies`, denoting the number of extra candies that you have.

Return a boolean array `result` of length `n`, where `result[i]` is `true` if, after giving the $i^{th}$ kid all the `extraCandies`, they will have the **greatest** number of candies among all the kids, or `false` otherwise.

Note that **multiple** kids can have the greatest number of candies.

**Example 1:**

```
Input: candies = [2,3,5,1,3], extraCandies = 3
Output: [true,true,true,false,true]
```

**Example 2:**

```
Input: candies = [4,2,1,1,2], extraCandies = 1
Output: [true,false,false,false,false]
```

## Solution Approach: Greedy

To find if a kid can have the greatest number of candies, we first need to know what the current maximum number of candies is among all kids. Once we start with the maximum value, we can simply check for each kid if `candies[i] + extraCandies` is greater than or equal to that maximum.

### Algorithm

1.  **Find Max:** Iterate through the `candies` array to find the maximum value (`maxVal`).
2.  **Check Condition:** Iterate through the `candies` array again. For each kid, check if `candies[i] + extraCandies >= maxVal`.
3.  **Build Result:** Add `true` or `false` to the result list based on the check.

### Complexity Analysis

- **Time Complexity:** $O(N)$, where $N$ is the number of kids. We iterate through the array twice (once to find max, once to build the result).
- **Space Complexity:** $O(1)$ ignoring the space required for the output list.

## Code Structure

```java
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxVal = 0;
        List<Boolean> ans = new ArrayList<>();

        for(int i=0; i<candies.length; i++){
            maxVal = Math.max(maxVal, candies[i]);
        }

        for(int i=0; i<candies.length; i++){
            int n = candies[i] + extraCandies;
            if(n >= maxVal){
                ans.add(true);
            }else ans.add(false);
        }

        return ans;
    }
}
```

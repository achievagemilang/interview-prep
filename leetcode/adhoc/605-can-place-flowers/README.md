# Can Place Flowers

## Problem Description

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in **adjacent** plots.

Given an integer array `flowerbed` containing `0`'s and `1`'s, where `0` means empty and `1` means not empty, and an integer `n`, return `true` if `n` new flowers can be planted in the `flowerbed` without violating the no-adjacent-flowers rule and `false` otherwise.

**Example 1:**

```
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
```

**Example 2:**

```
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
```

## Solution Approach: Greedy

We can iterate through the flowerbed and try to plant a flower at every available spot. A spot is available if it is empty (`0`) and its left and right neighbors are also empty (or if it's at the boundary).

To simplify boundary checks (for the first and last elements), we can create a new array with `0` padding at both ends. This allows us to use a uniform check for all elements.

### Algorithm

1.  Create a new array `padded` of size `flowerbed.length + 2`.
2.  Copy elements from `flowerbed` to `padded` (indices 1 to `flowerbed.length`).
3.  Set `padded[0]` and `padded[last]` to `0`.
4.  Iterate through `padded` from index 1 to `padded.length - 2`.
5.  Check if `padded[i]`, `padded[i-1]`, and `padded[i+1]` are all `0`.
    - If yes, plant a flower: set `padded[i] = 1` and decrement `n`.
6.  If at any point `n <= 0`, return `true`.
7.  After the loop, return `n <= 0`.

### Complexity Analysis

- **Time Complexity:** $O(N)$, where $N$ is the size of the flowerbed. We iterate through the array once.
- **Space Complexity:** $O(N)$. We create a padded array which takes linear space. (Note: This can be optimized to $O(1)$ by doing boundary checks explicitly).

## Code Structure

```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] padded = new int[flowerbed.length + 2];

        for(int i=1; i<padded.length-1; i++){
            padded[i] = flowerbed[i - 1];
        }

        for(int i=1; i<padded.length-1; i++){
            if(padded[i - 1] == padded[i] && padded[i] == padded[i+1] && padded[i] == 0){
                padded[i] = 1;
                n--;
            }
            if(n == 0) return true;
        }

        return n <= 0;
    }
}
```

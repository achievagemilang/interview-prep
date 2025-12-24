# Apple Redistribution into Boxes

## Problem Description

You are given an array `apple` of size `n` and an array `capacity` of size `m`.

- The `apple` array represents the number of apples in each pack.
- The `capacity` array represents the maximum number of apples each box can hold.

The goal is to redistribute all the apples into the **minimum number of boxes** possible from the given set of boxes.

## Solution Approach: Greedy Strategy

The core idea is to prioritize using the largest boxes first. By filling the boxes with the highest capacity, we minimize the total number of boxes needed to store the total sum of apples.

### Algorithm

1.  **Calculate Total Apples:** Sum all elements in the `apple` array to get the total number of apples that need storage.
2.  **Sort Capacities:** Sort the `capacity` array in descending order.
    - _Note:_ Since `Arrays.sort()` in Java sorts in ascending order, we manually reverse the array after sorting to process largest values first.
3.  **Fill Boxes:** Iterate through the sorted `capacity` array:
    - Subtract the current box's capacity from the remaining sum of apples.
    - Increment the box counter.
    - If the remaining sum is `<= 0`, return the current box count.

### Complexity Analysis

- **Time Complexity:** $O(M \log M + N)$
  - $M \log M$ for sorting the `capacity` array ($M$ elements).
  - $N$ for iterating through the `apple` array to calculate the sum ($N$ elements).
- **Space Complexity:** $O(1)$
  - We modify the `capacity` array in-place and use only a few variables for tracking the sum and box count. (Note: Java's Dual-Pivot Quicksort uses $O(\log M)$ stack space).

## Code Structure

```java
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        // 1. Sort capacity in ascending order
        Arrays.sort(capacity);

        // 2. Reverse capacity to get descending order
        for(int i=0; i<capacity.length/2; i++){
            if(capacity.length-i-1 == i) continue;
            int tmp = capacity[i];
            capacity[i] = capacity[capacity.length-i-1];
            capacity[capacity.length-i-1] = tmp;
        }

        // 3. Calculate total apples
        int sum = 0;
        for(int a: apple){
            sum+=a;
        }

        // 4. Greedily subtract capacity from sum
        int boxes = 0;
        for(int c: capacity){
            sum-=c;
            boxes++;
            if(sum <= 0){
                return boxes;
            }
        }

        return Integer.MAX_VALUE;
    }
}
```

## Optimization Notes

An alternative approach using Bucket Sort (or a frequency array) can optimize the time complexity to $O(N + M)$ by trading space for time. This is particularly effective if the range of values in capacity is small and known.

# Two Sum

## Problem Description

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.

You may assume that each input would have **exactly one solution**, and you may not use the same element twice.

You can return the answer in any order.

**Example 1:**

```
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
```

**Example 2:**

```
Input: nums = [3,2,4], target = 6
Output: [1,2]
```

**Example 3:**

```
Input: nums = [3,3], target = 6
Output: [0,1]
```

## Solution Approach: One-pass Hash Table

To solve this problem efficiently, we can use a Hash Table. We iterate through the array and for each element `nums[i]`, we check if its complement (`target - nums[i]`) exists in the hash table. If it exists, we have found the solution and return the indices. If not, we store the current element and its index in the hash table.

### Algorithm

1.  Initialize an empty Hash Table `mp`.
2.  Iterate through the array `nums` with index `i`.
3.  Calculate `n = target - nums[i]`.
4.  Check if `n` is present in `mp`.
    - If yes, return `[mp.get(n), i]`.
    - If no, put `nums[i]` and `i` into `mp`.
5.  If no solution is found (though the problem guarantees one), return a default value (e.g., `[0, 0]`).

### Complexity Analysis

- **Time Complexity:** $O(N)$, where $N$ is the number of elements in the array. We traverse the list containing $N$ elements exactly once. Each lookup in the table costs only $O(1)$ time.
- **Space Complexity:** $O(N)$. The extra space required depends on the number of items stored in the hash table, which stores at most $N$ elements.

## Code Structure

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int n = target - nums[i];
            if(mp.containsKey(n)){
                return new int[]{mp.get(n), i};
            }
            mp.putIfAbsent(nums[i], i);
        }

        return new int[]{0,0};
    }
}
```

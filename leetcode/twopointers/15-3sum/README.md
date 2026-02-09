# 3Sum

## Problem Description

Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

The solution must not contain duplicate triplets.

## Examples

**Example 1:**

```
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
```

**Example 2:**

```
Input: nums = [0,0,0]
Output: [[0,0,0]]
```

## Solution Approach

Sort the array, then use a fixed element + two pointers for the remaining two.

1. **Sort** the array.
2. **Iterate** through each element as the first element of triplet.
3. For remaining elements, use **two pointers** (left, right) to find pairs summing to `-nums[i]`.
4. **Skip duplicates** to avoid duplicate triplets.

## Complexity Analysis

- **Time Complexity:** $O(N^2)$ — sorting is $O(N \log N)$, nested loop is $O(N^2)$.
- **Space Complexity:** $O(\log N)$ to $O(N)$ for sorting.

## Code Structure

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];
            int l = i + 1;
            int r = nums.length - 1;

            while(l < r){
                int sum = nums[l] + nums[r];
                if(sum == target){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if(sum < target){
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
```

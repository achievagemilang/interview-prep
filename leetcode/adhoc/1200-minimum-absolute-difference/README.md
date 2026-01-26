# 1200. Minimum Absolute Difference

## Description

Given an array of **distinct** integers `arr`, find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair `[a, b]` follows

- `a, b` are from `arr`
- `a < b`
- `b - a` equals to the minimum absolute difference of any two elements in `arr`

## Examples

### Example 1:

**Input:** `arr = [4,2,1,3]`
**Output:** `[[1,2],[2,3],[3,4]]`
**Explanation:** The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.

### Example 2:

**Input:** `arr = [1,3,6,10,15]`
**Output:** `[[1,3]]`

### Example 3:

**Input:** `arr = [3,8,-10,23,19,-4,-14,27]`
**Output:** `[[-14,-10],[19,23],[23,27]]`

## Constraints

- `2 <= arr.length <= 10^5`
- `-10^6 <= arr[i] <= 10^6`

## Approach

The problem asks for pairs with the minimum absolute difference.

1.  **Sorting**: The minimum absolute difference between any two elements in a distinct integer array will always occur between **adjacent elements** in the sorted version of the array. Sorting the array brings these closest elements together.
2.  **Single Pass Scan**:
    - We iterate through the sorted array comparing adjacent elements `arr[i]` and `arr[i+1]`.
    - We maintain a `minDiff` variable to track the smallest difference found so far.
    - If the current difference `diff` is **smaller** than `minDiff`:
      - We found a new minimum. We clear our current list of answers and start a new list with the current pair `[arr[i], arr[i+1]]`.
      - Update `minDiff` to this new `diff`.
    - If `diff` is **equal** to `minDiff`:
      - We found another pair with the same minimum difference. We add `[arr[i], arr[i+1]]` to our answer list.
    - If `diff` is larger, we ignore it.

### Complexity

- **Time Complexity**: `O(N log N)` due to the sorting step. The subsequent linear scan is `O(N)`.
- **Space Complexity**: `O(1)` (ignoring the space required for the output list and recursion stack for sorting).

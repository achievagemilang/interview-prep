# 960. Delete Columns to Make Sorted III

## Description

You are given an array of `n` strings `strs`, all of the same length.

We may choose any set of deletion indices, and for each string, we delete all the characters in those indices.

For example, if we have an array `strs = ["abcdef","uvwxyz"]` and deletion indices `{0, 2, 3}`, then the final array after deletions is `["bef", "vyz"]`.

Suppose we chose a set of deletion indices `D` such that after deletions, the final array has **every element (row) in lexicographic order**.

For every remaining string in `strs`, if `strs[i]` is the original string and `strs[i]'` is the string after deletions, we must have `strs[i]'[j] <= strs[i]'[j+1]` for all valid `j`.

Return _the minimum size of_ `D`.

## Examples

### Example 1:

**Input:** `strs = ["babca","bbazb"]`
**Output:** `3`
**Explanation:** After deleting columns 0, 1, and 4, the final array is `strs = ["bc", "az"]`.
Both these rows are individually in lexicographic order (ie. `strs[0][0] <= strs[0][1]` and `strs[1][0] <= strs[1][1]`).
Note that `strs[0] > strs[1]` - the array `strs` is not necessarily sorted as a whole.

### Example 2:

**Input:** `strs = ["edcba"]`
**Output:** `4`
**Explanation:** If we delete less than 4 columns, the only row will not be sorted.

### Example 3:

**Input:** `strs = ["ghi","def","abc"]`
**Output:** `0`
**Explanation:** All rows are already sorted.

## Constraints

- `n == strs.length`
- `1 <= n <= 100`
- `1 <= strs[i].length <= 100`
- `strs[i]` consists of lowercase English letters.

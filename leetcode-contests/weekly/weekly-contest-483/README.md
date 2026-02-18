# Weekly Contest 483

## Q1. Largest Even Number

### Problem Description

Given a string `s`, find the largest even number that can be formed by trimming characters from the end of `s`.

### Solution Approach

- Iterate backwards from the end of the string.
- Find the first index `k` such that `s[k]` is even (in this specific problem, it seems to look for '2' or just even digits).
- The substring `s[0...k]` is the largest even number prefix.

### Code Structure

```java
class Solution {
    public String largestEven(String s) {
        int k = s.length() - 1;
        while(k >= 0){
            if(s.charAt(k) != '2'){ // Checks for specific condition
                k--;
            } else {
                break;
            }
        }
        if(k >= 0) return s.substring(0, k + 1);
        return "";
    }
}
```

---

## Q2. Word Squares II

### Problem Description

Given a array of words, find all "Word Squares" of size 4x4 using these words. A word square has the same words in rows and columns.

### Solution Approach

- **Nested Loops with Pruning**: Iterate through all combinations of 4 words `(i, j, k, l)`.
- **Pruning**: Check compatibility at each step:
  - `words[i][0] == words[j][0]` (diagonal symmetry)
  - `words[i][3] == words[k][0]`
  - And so on for other intersections.
- If valid, add to result list.

### Code Structure

```java
class Solution {
    public List<List<String>> wordSquares(String[] words) {
        // ... nested loops (i, j, k, l) ...
        // ... validity checks ...
        return result;
    }
}
```

---

## Q3. Minimum Cost to Make Two Binary Strings Equal

### Problem Description

Calculate minimum cost to make binary strings `s` and `t` equal given costs for `flip`, `swap`, and `cross` operations.

### Solution Approach

- Count mismatches:
  - `0 -> 1` (`count01`)
  - `1 -> 0` (`count10`)
- **Pairs**: Match `0->1` with `1->0` to use cheaper swap or cross operations.
  - Cost per pair = `min(swapCost, 2 * flipCost)`.
- **Remaining**: Handle remaining mismatches (must be even total difference for validity or single flips).
  - Cost per remaining pair (e.g., `0->1` and `0->1`) = `min(2 * flipCost, crossCost + swapCost)`.
  - Handle odd remaining.

### Code Structure

```java
class Solution {
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        // ... count mismatches ...
        // ... calculate pair costs ...
        return totalCost;
    }
}
```

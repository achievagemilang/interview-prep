# Merge Strings Alternately

## Problem Description

You are given two strings `word1` and `word2`. Merge the strings by adding letters in alternating order, starting with `word1`. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.

**Example 1:**

```
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
```

**Example 2:**

```
Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
```

**Example 3:**

```
Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
```

## Solution Approach: Two Pointers Simulation

We can solve this problem by simulating the process of merging. We use two pointers, `l` and `r`, initialized to 0, to track our position in `word1` and `word2` respectively. We iterate as long as both pointers are within bounds, alternatingly appending characters from `word1` and `word2` to a `StringBuilder`.

After the main loop, if there are remaining characters in either string, we append them to the result.

### Algorithm

1.  **Initialize:** Create a `StringBuilder` and two pointers `l = 0`, `r = 0`.
2.  **Alternate:** While `l < word1.length()` and `r < word2.length()`:
    - Append `word1[l]` and increment `l`.
    - Append `word2[r]` and increment `r`.
3.  **Append Remaining:**
    - If `l < word1.length()`, append the rest of `word1`.
    - If `r < word2.length()`, append the rest of `word2`.
4.  **Return:** Convert the `StringBuilder` to a string and return.

### Complexity Analysis

- **Time Complexity:** $O(N + M)$, where $N$ and $M$ are lengths of the two words. We process each character exactly once.
- **Space Complexity:** $O(N + M)$ to store the result string.

## Code Structure

```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int l = 0;
        int r = 0;

        while(l < word1.length() && r < word2.length()){
            sb.append(word1.charAt(l));
            sb.append(word2.charAt(r));
            l++;
            r++;
        }

        while(l < word1.length()){
            sb.append(word1.charAt(l));
            l++;
        }

        while(r < word2.length()){
            sb.append(word2.charAt(r));
            r++;
        }

        return sb.toString();
    }
}
```

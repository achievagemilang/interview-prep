# Find All Anagrams in a String

## Problem Description

Given two strings `s` and `p`, return an array of all the start indices of `p`'s anagrams in `s`. An **anagram** is a rearrangement of letters.

## Examples

**Example 1:**

```
Input: s = "cbaebabacd", p = "abc"
Output: [0, 6]
Explanation:
- Index 0: "cba" is an anagram of "abc".
- Index 6: "bac" is an anagram of "abc".
```

**Example 2:**

```
Input: s = "abab", p = "ab"
Output: [0, 1, 2]
```

## Solution Approach

Use a fixed-size sliding window of length `p.length()` and compare character frequencies.

1. Use a frequency array of size 26 for lowercase letters.
2. Slide a window of size `p.length()` over string `s`.
3. For each window, check if it's an anagram by comparing character counts.

### Anagram Check

Increment count for characters in the window, decrement for characters in `p`. If all counts are zero, it's an anagram.

## Complexity Analysis

- **Time Complexity:** $O(N \cdot M)$ where $N$ is the length of `s` and $M$ is the length of `p`. Can be optimized to $O(N)$ with incremental updates.
- **Space Complexity:** $O(1)$ for the fixed-size frequency array.

## Code Structure

```java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) return new ArrayList<>();
        int l = 0;
        List<Integer> ans = new ArrayList<>();
        for(int r = p.length() - 1; r < s.length(); r++){
            if(isAnagram(s.substring(l, r + 1), p)){
                ans.add(l);
            }
            l++;
        }
        return ans;
    }

    boolean isAnagram(String s, String p){
        if(s.length() != p.length()) return false;
        int[] key = new int[26];
        for(int i=0; i<s.length(); i++){
            char cs = s.charAt(i);
            char cp = p.charAt(i);
            key[cs - 'a']++;
            key[cp - 'a']--;
        }
        int[] zeros = new int[key.length];
        return Arrays.equals(key, zeros);
    }
}
```

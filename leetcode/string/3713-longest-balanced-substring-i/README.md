# Longest Balanced Substring I

## Problem Description

Given a string `s`, find the length of the longest balanced substring. A substring is balanced if every character in the substring appears the same number of times.

## Solution Approach

This solution uses a **brute-force approach** with frequency counting.

1. Iterate through all possible starting positions `i` (0 to n-1).
2. For each `i`, iterate through all possible ending positions `j` (i to n-1).
3. For each substring `s[i...j]`:
   - Maintain a frequency count array `cnt` of size 26.
   - Increment count for current character `s[j]`.
   - Check if the current substring is balanced:
     - Identify the frequency of the current character.
     - Verify if all other characters present in the substring have the same frequency.
   - If balanced, update the maximum length `res`.

## Complexity Analysis

- **Time Complexity:** $O(N^2 \cdot 26)$ or roughly $O(N^2)$ since alphabet size is constant.
  - Outer loops generate all substrings: $O(N^2)$.
  - Inner check iterates through the 26-character alphabet: $O(1)$.
- **Space Complexity:** $O(1)$ (using fixed size array of 26 integers).

## Code Structure

```java
class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int res = 0;
        int[] cnt = new int[26];

        for(int i=0; i<n; i++){
            Arrays.fill(cnt, 0);
            for(int j=i; j<n; j++){
                cnt[s.charAt(j) - 'a']++;
                boolean isValid = true;

                for(int k=0; k<26; k++){
                    if(cnt[k] > 0){
                        if(cnt[s.charAt(j) - 'a'] != cnt[k]){
                            isValid = false;
                            break;
                        }
                    }
                }

                if(isValid) res = Math.max(res, j - i + 1);
            }
        }
        return res;
    }
}
```

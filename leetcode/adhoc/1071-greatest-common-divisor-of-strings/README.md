# Greatest Common Divisor of Strings

## Problem Description

For two strings `s` and `t`, we say "t divides s" if and only if `s = t + t + ... + t` (i.e., `t` is concatenated with itself one or more times).

Given two strings `str1` and `str2`, return the largest string `x` such that `x` divides both `str1` and `str2`.

**Example 1:**

```
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
```

**Example 2:**

```
Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
```

**Example 3:**

```
Input: str1 = "LEET", str2 = "CODE"
Output: ""
```

## Solution Approach: Euclidean Algorithm

The problem asks for the greatest common divisor (GCD) of two strings. A key observation is that if a string `x` divides both `str1` and `str2`, then `str1 + str2` must equal `str2 + str1`. If this condition is not met, no such `x` exists, and we return an empty string.

If the condition holds, the length of the GCD string is equal to the greatest common divisor of the lengths of `str1` and `str2`. We can compute this using the Euclidean algorithm.

### Algorithm

1.  **Check Concatenation:** If `str1 + str2` is not equal to `str2 + str1`, return `""`.
2.  **Compute GCD of Lengths:** Calculate the greatest common divisor of `str1.length()` and `str2.length()`.
3.  **Extract Substring:** The result is the prefix of `str1` (or `str2`) with length equal to the computed GCD.

### Complexity Analysis

- **Time Complexity:** $O(N + M)$, where $N$ and $M$ are the lengths of `str1` and `str2`. The concatenation check takes $O(N + M)$, and the Euclidean algorithm takes $O(\log(\min(N, M)))$.
- **Space Complexity:** $O(N + M)$ to create the concatenated strings for the initial check.

## Code Structure

```java
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String combined = str1 + str2;
        if(!combined.equals(str2 + str1)){
            return "";
        }

        return combined.substring(0, gcd(str1.length(), str2.length()));
    }

    public int gcd(int a, int b){
        int prevB = b;
        while(b > 0){
            if(a % b == 0 && prevB % b == 0){
                return b;
            }
            b--;
        }
        return 1;
    }
}
```

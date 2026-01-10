# String to Integer (atoi)

## Problem Description

Implement the `myAtoi(string s)` function, which converts a string to a 32-bit signed integer (similar to C/C++'s `atoi` function).

The algorithm for `myAtoi(string s)` is as follows:

1.  **Whitespace:** Ignore any leading whitespace (" ").
2.  **Signedness:** Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither is present.
3.  **Conversion:** Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the integer is 0.
4.  **Rounding:** If the integer is out of the 32-bit signed integer range $[-2^{31}, 2^{31} - 1]$, then integer is clamped to remain in the range. Specifically, integers less than $-2^{31}$ should be rounded to $-2^{31}$, and integers greater than $2^{31} - 1$ should be rounded to $2^{31} - 1$.

Return the integer as the final result.

**Example 1:**

```
Input: s = "42"
Output: 42
```

**Example 2:**

```
Input: s = "   -42"
Output: -42
```

**Example 3:**

```
Input: s = "4193 with words"
Output: 4193
```

## Solution Approach: Linear Scan

We simply process the string character by character, following the rules. The trickiest part is handling overflow.

### Algorithm

1.  **Trim Whitespace:** Use `s.trim()`. If string is empty, return 0.
2.  **Handle Sign:** Check first character for '+' or '-'. Set `sign` variable and correct logic to increment index.
3.  **Process Digits:** Loop through characters starting from `index`.
    - If char is not digit, break.
    - Convert char to digit `ch - '0'`.
    - **Check Overflow:** Before `res = res * 10 + digit`, check if this operation would overflow `Integer.MAX_VALUE`.
      - If `res > Integer.MAX_VALUE / 10` OR (`res == Integer.MAX_VALUE / 10` and `digit > Integer.MAX_VALUE % 10`), return `MAX_VALUE` or `MIN_VALUE` based on sign.
    - Update `res`.
4.  Return `res * sign`.

### Complexity Analysis

- **Time Complexity:** $O(N)$, where $N$ is the length of the string. We look at each character at most once.
- **Space Complexity:** $O(1)$. We use constant extra space.

## Code Structure

```java
class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;

        int sign = 1;
        int index = 0;
        int res = 0;

        if (s.charAt(0) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(0) == '+') {
            index++;
        }

        while (index < s.length()) {
            char ch = s.charAt(index);

            if (!Character.isDigit(ch)) {
                break;
            }

            int digit = ch - '0';

            if (res > Integer.MAX_VALUE / 10 ||
               (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + digit;
            index++;
        }

        return res * sign;
    }
}
```

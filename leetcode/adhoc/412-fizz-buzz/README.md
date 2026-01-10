# Fizz Buzz

## Problem Description

Given an integer `n`, return a string array `answer` (1-indexed) where:

- `answer[i] == "FizzBuzz"` if `i` is divisible by 3 and 5.
- `answer[i] == "Fizz"` if `i` is divisible by 3.
- `answer[i] == "Buzz"` if `i` is divisible by 5.
- `answer[i] == i` (as a string) if none of the above conditions are true.

**Example 1:**

```
Input: n = 3
Output: ["1","2","Fizz"]
```

**Example 2:**

```
Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]
```

**Example 3:**

```
Input: n = 15
Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
```

## Solution Approach: Simulation

We can simply iterate from 1 to `n` and for each number check the divisibility conditions.

### Algorithm

1.  Initialize a string array `ans` of size `n`.
2.  Iterate `i` from 1 to `n`.
3.  For each `i`:
    - Check if divisible by 15 (3 and 5). If so, set `ans[i-1]` to "FizzBuzz".
    - Else if divisible by 3, set to "Fizz".
    - Else if divisible by 5, set to "Buzz".
    - Else, set to string representation of `i`.
4.  Return the array as a List.

### Complexity Analysis

- **Time Complexity:** $O(N)$, where $N$ is the input number. We iterate $N$ times.
- **Space Complexity:** $O(1)$ if we ignore the space taken by the output array.

## Code Structure

```java
class Solution {
    public List<String> fizzBuzz(int n) {
        String[] ans = new String[n];

        for (int i=0; i<n; i++){
            int num = i+1;
            if(num % 3 == 0 && num % 5 == 0){
                ans[i] = "FizzBuzz";
            } else if (num % 3 == 0){
                ans[i] = "Fizz";

            } else if (num % 5 == 0){
                ans[i] = "Buzz";

            } else {
                ans[i] = String.valueOf(num);

            }
        }

        return Arrays.asList(ans);
    }
}
```

# Valid Parentheses

## Problem Description

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

A string is valid if:

1. Open brackets are closed by the same type of brackets.
2. Open brackets are closed in the correct order.
3. Every close bracket has a corresponding open bracket.

## Examples

**Example 1:**

```
Input: s = "()"
Output: true
```

**Example 2:**

```
Input: s = "()[]{}"
Output: true
```

**Example 3:**

```
Input: s = "(]"
Output: false
```

## Solution Approach

Use a stack to track opening brackets.

1. Create a map of opening to closing brackets.
2. For each character:
   - If opening bracket, push to stack.
   - If closing bracket, pop from stack and check if it matches.
3. Return true if stack is empty at the end.

## Complexity Analysis

- **Time Complexity:** $O(N)$ — single pass through the string.
- **Space Complexity:** $O(N)$ — worst case stack size.

## Code Structure

```java
class Solution {
    public boolean isValid(String s) {
        if(s.length() <= 1) return false;
        Deque<Character> st = new ArrayDeque<>();
        Map<Character, Character> mp = new HashMap<>();
        mp.put('{', '}');
        mp.put('[', ']');
        mp.put('(', ')');

        for(Character c: s.toCharArray()){
            if(isOpen(c)){
                st.push(c);
            } else {
                if(st.isEmpty()){
                    return false;
                }
                Character popped = st.pop();
                if(mp.get(popped) != c){
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    public boolean isOpen(Character c){
        return c == '(' || c == '{' || c == '[';
    }
}
```

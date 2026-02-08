# Min Stack

## Problem Description

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

- `push(val)` — Push element onto stack
- `pop()` — Remove top element
- `top()` — Get top element
- `getMin()` — Retrieve minimum element

## Examples

**Example:**

```
Input: ["MinStack","push","push","push","getMin","pop","top","getMin"]
       [[],[-2],[0],[-3],[],[],[],[]]
Output: [null,null,null,null,-3,null,0,-2]
```

## Solution Approach

Use two stacks: one for data and one for tracking minimums.

1. **Main stack**: Stores all elements.
2. **Min stack**: Stores elements that are the minimum at that point.
   - Push to min stack only when value ≤ current min.
   - Pop from min stack when popped value equals current min.

## Complexity Analysis

- **Time Complexity:** $O(1)$ for all operations.
- **Space Complexity:** $O(N)$ for the stacks.

## Code Structure

```java
class MinStack {
    Deque<Integer> st;
    Deque<Integer> minSt;

    public MinStack() {
        this.st = new ArrayDeque<>();
        this.minSt = new ArrayDeque<>();
    }

    public void push(int val) {
        st.push(val);
        if(minSt.isEmpty() || val <= minSt.peek()){
            minSt.push(val);
        }
    }

    public void pop() {
        if(st.isEmpty()) return;
        int val = st.pop();
        if(minSt.peek() == val){
            minSt.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }
}
```

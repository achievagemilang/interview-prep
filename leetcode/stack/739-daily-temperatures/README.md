# Daily Temperatures

## Problem Description

Given an array of integers `temperatures` representing daily temperatures, return an array `answer` such that `answer[i]` is the number of days you have to wait after the `i`th day to get a warmer temperature.

If there is no future day with a warmer temperature, set `answer[i] = 0`.

## Examples

**Example 1:**

```
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
```

**Example 2:**

```
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
```

## Solution Approach

Use a **monotonic decreasing stack** to efficiently find the next warmer day.

1. Push `(index, temperature)` pairs onto the stack.
2. For each new temperature, pop elements while the stack top is cooler.
3. For each popped element, calculate days = current index - popped index.
4. Store results in a map, then convert to array.

## Complexity Analysis

- **Time Complexity:** $O(N)$ — each element is pushed and popped at most once.
- **Space Complexity:** $O(N)$ — for the stack and result map.

## Code Structure

```java
class Solution {
    public class Pair{
        int index;
        int temp;

        public Pair(int index, int temp){
            this.index = index;
            this.temp = temp;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 1) return new int[]{0};

        Deque<Pair> st = new ArrayDeque<>();
        st.push(new Pair(0, temperatures[0]));
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=1; i<temperatures.length; i++){
            int t = temperatures[i];
            while(!st.isEmpty() && t > st.peek().temp){
                Pair popped = st.pop();
                mp.put(popped.index, i - popped.index);
            }
            st.push(new Pair(i, t));
        }

        while(!st.isEmpty()){
            Pair popped = st.pop();
            mp.put(popped.index, 0);
        }

        int[] ans = new int[temperatures.length];
        for(int i=0; i<temperatures.length; i++){
            ans[i] = mp.get(i);
        }
        return ans;
    }
}
```

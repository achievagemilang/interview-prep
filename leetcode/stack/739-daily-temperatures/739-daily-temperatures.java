package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

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
            int v = mp.get(i);
            ans[i] = v;
        }
        return ans;
    }
}

/*
We will use stack to store the temperature up until we find the more higher value, then try to pop while the current element is much higher than the popped element from the stack

Element in stack will be stored in pair format <temperature, index>;

The answer will be mapped and will then be serialized in the end in int[] format
T(n) -> O(n) iterate array once
S(n) -> O(n) -> map uses, stack
*/
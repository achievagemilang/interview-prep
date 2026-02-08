package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

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

/*
Idea is to use stack and pop accordingly if found closing parentheses
if somehow popped open parentheses doesn't match then return false

return true if stack is empty
*/
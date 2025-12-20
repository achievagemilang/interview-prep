package leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder window = new StringBuilder();
        Set<Character> set = new HashSet<>();
        int ans = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            window.append(c);

            while(isInvalid(c, set)){
                char removed = window.charAt(0);
                window.deleteCharAt(0);
                set.remove(removed);
            }

            set.add(c);
            ans = Math.max(ans, window.length());
        }
        
        return ans;
    }

    public boolean isInvalid(Character c, Set<Character> set){
        return set.contains(c);
    }
}


/*
Using sliding window to keep track of repeating character, delete if found
T(n) -> O(n)
S(n) -> O(n)
*/
package leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) return new ArrayList<>();
        int l = 0;
        List<Integer> ans = new ArrayList<>();
        for(int r = p.length() - 1; r < s.length(); r++){
            if(isAnagram(s.substring(l, r + 1), p)){
                ans.add(l);
            }
            l++;
        }
        return ans;
    }

    boolean isAnagram(String s, String p){
        if(s.length() != p.length()) return false;
        int[] key = new int[26];
        for(int i=0; i<s.length(); i++){
            char cs = s.charAt(i);
            char cp = p.charAt(i);
            key[cs - 'a']++;
            key[cp - 'a']--;
        }
        int[] zeros = new int[key.length];
        return Arrays.equals(key, zeros);
    }
}

/*
Idea is simple is to use array char counter to store all elements that will be compared into one another given string p and substring from s

We will use two pointers as sliding window to get substring from s, the condition of the window means that r - l + 1 == p.length()

Then use one helper function isAnagram by using logic mentioned above

T(n): O(len(s) and len(p))
S(n): O(len(p))
*/
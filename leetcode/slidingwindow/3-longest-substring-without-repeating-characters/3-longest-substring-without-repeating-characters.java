class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int l = 0;
        Set<Character> inWindow = new HashSet<>();
        int maxVal = -1;
        for(int r=0; r<s.length(); r++){
            while (inWindow.contains(s.charAt(r))) {
                inWindow.remove(s.charAt(l));
                l++;
            }
            inWindow.add(s.charAt(r));
            maxVal = Math.max(maxVal, r - l + 1);
        }

        return maxVal;

    }
}


/*
Using sliding window to keep track of repeating character, delete if found
T(n) -> O(n)
S(n) -> O(n)
*/
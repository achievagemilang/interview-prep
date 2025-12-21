package leetcode.twopointers;

class Solution {
    public boolean isPalindrome(String s) {
        int l, r, n;

        n = s.length();
        r = n - 1;
        l = 0;

        while (l < r){
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if(Character.toUpperCase(s.charAt(l)) == Character.toUpperCase(s.charAt(r))){
                l++;
                r--;
            } else {
                return false;
            }
        }

        return true;
    }
}
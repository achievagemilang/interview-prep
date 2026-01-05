class Solution {
    public boolean isSubsequence(String s, String t) {
        int l = 0;
        int r = 0;
        while(r < t.length() && l < s.length()){
            char sc = s.charAt(l);
            char tc = t.charAt(r);

            if(sc == tc){
                l++;
                r++;
            } else {
                r++;
            }
        }

        return l == s.length();   
    }
}
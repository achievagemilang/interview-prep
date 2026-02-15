class Solution {
    public int almostPalindromic(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int maxLen = 0;

        for(int i=0; i<s.length(); i++){
            maxLen = Math.max(maxLen, expandWithTolerance(s, i, i, 1));
            maxLen = Math.max(maxLen, expandWithTolerance(s, i, i+1, 1));
        }

        return maxLen;
    }

    private int expandWithTolerance(String s, int l, int r, int tol){
        while(l >= 0 && r < s.length()){
            if(s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            } else{
                if(tol > 0){
                    int skipLeft = expandWithTolerance(s, l-1, r, 0);
                    int skipRight = expandWithTolerance(s, l, r+1, 0);

                    return Math.max(skipLeft, skipRight);
                } else{
                    break;
                }
            }
        }

        int len = r - l - 1;

        if(tol > 0 && len < s.length()){
            len++;
        }

        return len;
    }
}